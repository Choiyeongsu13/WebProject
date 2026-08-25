package com.profill.admin.manage.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.PostDTO;
import com.profill.model.ProfillDAO;
import com.profill.service.Action;

public class AdminWriteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PostDTO dto = new PostDTO();
		dto.setCategoryid(toInt(request.getParameter("categoryId")));
		dto.setTitle(request.getParameter("title"));
		dto.setSlug(request.getParameter("slug"));
		dto.setSummary(request.getParameter("summary"));
		dto.setContent(request.getParameter("content"));
		dto.setThumbnail(request.getParameter("thumbnail"));
		dto.setReadminutes(toInt(request.getParameter("readMinutes")));

		String status = request.getParameter("status");
		dto.setStatus("PUBLISHED".equals(status) ? "PUBLISHED" : "DRAFT");

		String tagLine = request.getParameter("tags");
		String[] tags = null;
		if (tagLine != null && tagLine.trim().length() > 0) {
			tags = tagLine.split(",");
		}

		String problem = check(dto);
		if (problem != null) {
			back(request, response, dto, problem);
			return;
		}

		ProfillDAO dao = ProfillDAO.getInstance();
		int postId = dao.postInsert(dto, tags);

		if (postId == 0) {
			back(request, response, dto, "저장하지 못했습니다. 잠시 후 다시 시도해 주세요.");
			return;
		}

		response.sendRedirect(request.getContextPath() + "/Journal?cmd=journal_view&id=" + postId);
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

		request.setAttribute("error", message);
		request.setAttribute("post", dto);

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
