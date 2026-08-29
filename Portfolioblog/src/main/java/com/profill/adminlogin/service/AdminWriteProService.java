package com.profill.adminlogin.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.profill.model.PostDTO;
import com.profill.model.ProfillDAO;
import com.profill.service.Action;

public class AdminWriteProService implements Action {


	private static String UPLOAD_DIR = "/images/posts";
	private static int    MAX_SIZE   = 5 * 1024 * 1024;   

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String saveDir = request.getServletContext().getRealPath(UPLOAD_DIR);
		File dir = new File(saveDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		MultipartRequest multi = null;
		try {

			multi = new MultipartRequest(request, saveDir, MAX_SIZE, "UTF-8",
					new DefaultFileRenamePolicy());
		} catch (Exception e) {
		
			e.printStackTrace();
			back(request, response, new PostDTO(), "사진은 5MB 까지만 올릴 수 있습니다.");
			return;
		}

		PostDTO dto = new PostDTO();
		dto.setCategoryid(toInt(multi.getParameter("categoryId")));
		dto.setTitle(multi.getParameter("title"));
		dto.setSlug(multi.getParameter("slug"));
		dto.setSummary(multi.getParameter("summary"));
		dto.setContent(multi.getParameter("content"));
		dto.setReadminutes(toInt(multi.getParameter("readMinutes")));


		dto.setStatus("PUBLISHED");


		dto.setThumbnail(multi.getFilesystemName("thumbnail"));

		String tagLine = multi.getParameter("tags");
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
		if (dto.getTitle().length() > 100) {
			return "제목은 100자까지입니다.";
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