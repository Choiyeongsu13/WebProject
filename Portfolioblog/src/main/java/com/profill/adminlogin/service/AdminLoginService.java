package com.profill.adminlogin.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.service.Action;

public class AdminLoginService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("loginUser") != null) {
			response.sendRedirect(request.getContextPath() + "/Index?cmd=index");
			return;
		}

		RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
		rd.forward(request, response);
	}
}
