package com.mnu.sample.AdminUser.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminUserDAO;
import com.mnu.sample.service.Action;

public class admin_user_deleteproService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");

		AdminUserDAO Audao = AdminUserDAO.getInstance();
		Audao.AdminUserDelete(userid);

		response.sendRedirect("/Admin/User?cmd=userList");
	}

}
