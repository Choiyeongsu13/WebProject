package com.profill.adminlogin.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.ProfillDAO;
import com.profill.service.Action;

/** 글 삭제 처리를 담당. */
public class AdminDeleteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int postId = toInt(request.getParameter("id"));

		if (postId > 0) {
			ProfillDAO.getInstance().postDelete(postId);
		}

		response.sendRedirect(request.getContextPath() + "/Journal?cmd=journal_list");
	}

	private int toInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception e) {
			return 0;
		}
	}
}
