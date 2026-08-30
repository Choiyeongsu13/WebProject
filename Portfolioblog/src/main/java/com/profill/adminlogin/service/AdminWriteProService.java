package com.profill.adminlogin.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.PostDTO;
import com.profill.model.ProfillDAO;
import com.profill.service.Action;
import com.profill.util.FileUploadUtil;

/** 글 등록 처리를 담당. */
public class AdminWriteProService implements Action {

	private static String UPLOAD_DIR = "/images/posts";

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> fields = new HashMap<String, String>();
		String fileName = null;

		try {
			fileName = FileUploadUtil.parseAndSave(request, fields, "thumbnail", UPLOAD_DIR);
		} catch (Exception e) {
			e.printStackTrace();
			back(request, response, toDto(fields), e.getMessage());
			return;
		}

		PostDTO dto = toDto(fields);
		dto.setStatus("PUBLISHED");

		String problem = check(dto);
		if (problem != null) {
			back(request, response, dto, problem);
			return;
		}

		dto.setThumbnail(fileName);

		ProfillDAO dao = ProfillDAO.getInstance();
		int postId = dao.postInsert(dto, null);

		if (postId == 0) {
			back(request, response, dto, "저장하지 못했습니다. 잠시 후 다시 시도해 주세요.");
			return;
		}

		response.sendRedirect(request.getContextPath() + "/Journal?cmd=journal_view&id=" + postId);
	}

	private PostDTO toDto(Map<String, String> fields) {
		PostDTO dto = new PostDTO();
		dto.setCategoryid(toInt(fields.get("categoryId")));
		dto.setTitle(fields.get("title"));
		dto.setSlug(fields.get("slug"));
		dto.setContent(fields.get("content"));
		dto.setReadminutes(toInt(fields.get("readMinutes")));
		return dto;
	}

	private String check(PostDTO dto) {
		if (dto.getCategoryid() <= 0) {
			return "분류를 선택해 주세요.";
		}
		if (dto.getTitle() == null || dto.getTitle().trim().length() == 0) {
			return "제목을 입력해 주세요.";
		}
		if (dto.getTitle().length() > 200) {
			return "제목은 200자까지입니다.";
		}
		if (dto.getContent() == null || dto.getContent().trim().length() == 0) {
			return "내용을 입력해 주세요.";
		}
		return null;
	}

	private void back(HttpServletRequest request, HttpServletResponse response,
	                  PostDTO dto, String message) throws ServletException, IOException {

		String lang = (String) request.getSession().getAttribute("lang");

		request.setAttribute("error", message);
		request.setAttribute("post", dto);
		request.setAttribute("isEdit", Boolean.FALSE);
		request.setAttribute("categories", ProfillDAO.getInstance().categoryList(lang));

		RequestDispatcher rd = request.getRequestDispatcher("/admin/write.jsp");
		rd.forward(request, response);
	}

	private int toInt(String value) {
		if (value == null) {
			return 0;
		}
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception e) {
			return 0;
		}
	}
}