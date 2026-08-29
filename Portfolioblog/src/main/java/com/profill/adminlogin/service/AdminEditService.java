package com.profill.adminlogin.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.PostDTO;
import com.profill.model.ProfillDAO;
import com.profill.service.Action;

/** 글 수정 폼을 보여준다. */
public class AdminEditService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int postId = toInt(request.getParameter("id"));

		ProfillDAO dao = ProfillDAO.getInstance();
		PostDTO post = dao.postEditView(postId);

		if (post == null) {
			response.sendRedirect(request.getContextPath() + "/Journal?cmd=journal_list");
			return;
		}

		String lang = (String) request.getSession().getAttribute("lang");

		List<String> tags = dao.postTagList(postId);
		StringBuilder tagsLine = new StringBuilder();
		for (int i = 0; i < tags.size(); i++) {
			if (i > 0) {
				tagsLine.append(", ");
			}
			tagsLine.append(tags.get(i));
		}

		request.setAttribute("post", post);
		request.setAttribute("tagsLine", tagsLine.toString());
		request.setAttribute("isEdit", Boolean.TRUE);
		request.setAttribute("categories", dao.categoryList(lang));

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
