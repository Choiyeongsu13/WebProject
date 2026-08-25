package com.profill.journal.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.PostDTO;
import com.profill.model.ProfillDAO;
import com.profill.service.Action;

public class JournalViewService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int postId = toInt(request.getParameter("id"));

		if (postId <= 0) {
			response.sendRedirect(request.getContextPath() + "/Journal?cmd=journal_list");
			return;
		}

		ProfillDAO dao = ProfillDAO.getInstance();
		PostDTO post = dao.postView(postId);

		if (post == null) {
			response.sendRedirect(request.getContextPath() + "/Journal?cmd=journal_list");
			return;
		}

		dao.postCountUp(postId);

		request.setAttribute("post", post);
		request.setAttribute("comments", dao.commentList(postId));

		RequestDispatcher rd = request.getRequestDispatcher("/post.jsp");
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
