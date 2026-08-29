package com.profill.adminlogin.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.PostDTO;
import com.profill.model.ProfillDAO;
import com.profill.service.Action;
import com.profill.util.FileUploadUtil;

/** 글 수정 처리를 담당. */
public class AdminEditProService implements Action {

	private static String UPLOAD_DIR = "/images/posts";

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int postId = toInt(request.getParameter("postId"));

		PostDTO dto = new PostDTO();
		dto.setPostid(postId);
		dto.setCategoryid(toInt(request.getParameter("categoryId")));
		dto.setTitle(request.getParameter("title"));
		dto.setSlug(request.getParameter("slug"));
		dto.setSummary(request.getParameter("summary"));
		dto.setContent(request.getParameter("content"));
		dto.setReadminutes(toInt(request.getParameter("readMinutes")));
		dto.setStatus("PUBLISHED");

		String tagLine = request.getParameter("tags");
		String[] tags = null;
		if (tagLine != null && tagLine.trim().length() > 0) {
			tags = tagLine.split(",");
		}

		String problem = check(postId, dto);
		if (problem != null) {
			back(request, response, dto, tagLine, problem);
			return;
		}

		ProfillDAO dao = ProfillDAO.getInstance();

		String fileName = null;
		try {
			fileName = FileUploadUtil.saveImage(request, "thumbnail", UPLOAD_DIR);
		} catch (Exception e) {
			e.printStackTrace();
			back(request, response, dto, tagLine, "사진을 저장하지 못했습니다. 5MB 이하의 이미지만 올릴 수 있습니다.");
			return;
		}

		if (fileName != null) {
			dto.setThumbnail(fileName);
		} else {
			PostDTO old = dao.postEditView(postId);
			dto.setThumbnail(old == null ? null : old.getThumbnail());
		}

		boolean success = dao.postUpdate(dto, tags);

		if (!success) {
			back(request, response, dto, tagLine, "수정하지 못했습니다. 잠시 후 다시 시도해 주세요.");
			return;
		}

		response.sendRedirect(request.getContextPath() + "/Journal?cmd=journal_view&id=" + postId);
	}

	private String check(int postId, PostDTO dto) {
		if (postId <= 0) {
			return "잘못된 접근입니다.";
		}
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
	                  PostDTO dto, String tagLine, String message) throws ServletException, IOException {

		String lang = (String) request.getSession().getAttribute("lang");

		request.setAttribute("error", message);
		request.setAttribute("post", dto);
		request.setAttribute("tagsLine", tagLine);
		request.setAttribute("isEdit", Boolean.TRUE);
		request.setAttribute("categories", ProfillDAO.getInstance().categoryList(lang));

		RequestDispatcher rd = request.getRequestDispatcher("/admin/write.jsp");
		rd.forward(request, response);
	}

	private int toInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception e) {
			return 0;
		}
	}
}
