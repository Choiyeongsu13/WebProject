package com.profill.adminlogin.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.profill.model.Blog_userDTO;
import com.profill.model.ProfillDAO;
import com.profill.service.Action;

public class AdminLoginProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		ProfillDAO dao = ProfillDAO.getInstance();
		Blog_userDTO user = dao.userLogin(loginId, password);

		if (user == null) {
			request.setAttribute("error", "아이디 또는 비밀번호가 맞지 않습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
			rd.forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("loginUser", user.getName());
		session.setAttribute("loginId", user.getLogin_id());

		response.sendRedirect(request.getContextPath() + "/Home?cmd=home");
	}
}
