package com.mnu.sample.AdminUser.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminUserDAO;
import com.mnu.sample.model.AdminUserDTO;
import com.mnu.sample.service.Action;

public class admin_user_viewService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");

		AdminUserDAO Audao = AdminUserDAO.getInstance();
		AdminUserDTO Audto = Audao.AdminUserSearch(userid);
		
		
		request.setAttribute("dto", Audto);
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/user_view.jsp");
		rd.forward(request, response);

	}

}
