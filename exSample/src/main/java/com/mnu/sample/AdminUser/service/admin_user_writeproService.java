package com.mnu.sample.AdminUser.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminUserDAO;
import com.mnu.sample.model.AdminUserDTO;
import com.mnu.sample.service.Action;

public class admin_user_writeproService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		AdminUserDAO Audao = AdminUserDAO.getInstance();
		AdminUserDTO Audto = new AdminUserDTO();

		Audto.setUserid(request.getParameter("userid"));
		Audto.setName(request.getParameter("name"));
		Audto.setPasswd(request.getParameter("passwd"));
		Audto.setTel(request.getParameter("tel"));
		Audto.setEmail(request.getParameter("email"));

		Audao.Userwrite(Audto);

		response.sendRedirect("/Admin/User?cmd=userList");

	}

}
