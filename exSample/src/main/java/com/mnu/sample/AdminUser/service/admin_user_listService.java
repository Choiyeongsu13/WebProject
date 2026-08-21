package com.mnu.sample.AdminUser.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminUserDAO;
import com.mnu.sample.model.AdminUserDTO;
import com.mnu.sample.service.Action;

public class admin_user_listService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminUserDAO Audao = AdminUserDAO.getInstance();

		int totcount = Audao.AdminUsercountList(); //총 게시글수
		List<AdminUserDTO> AnList = Audao.AdminUserList(); //전체 글 목록

		request.setAttribute("AnList", AnList);
		request.setAttribute("totcount", totcount);

		RequestDispatcher rd = request.getRequestDispatcher("/Admin/user_list.jsp");
		rd.forward(request, response);
	}

}
