package com.profill.post.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.ProfillDAO;
import com.profill.service.Action;


public class CommentDeleteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int postId = toInt(request.getParameter("postId"));
		int commentId = toInt(request.getParameter("commentId"));
		String password = request.getParameter("password");

		if (postId <= 0 || commentId <= 0) {
			response.sendRedirect(request.getContextPath() + "/Post?cmd=post_list");
			return;
		}

		ProfillDAO dao = ProfillDAO.getInstance();
		int row = dao.commentDelete(commentId, password);

		if (row == 0) {
			request.getSession().setAttribute("commentError", "비밀번호가 맞지 않습니다.");
		}

		response.sendRedirect(request.getContextPath()
				+ "/Post?cmd=post_view&id=" + postId + "#comments");
	}

	private int toInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception e) {
			return 0;
		}
	}
}
