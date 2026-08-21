package com.mnu.sample.AdminBoard.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminBoardDAO;
import com.mnu.sample.service.Action;

public class admin_board_deleteproService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));

		AdminBoardDAO Andao = AdminBoardDAO.getInstance();
		Andao.AdminboardDelete(idx);

		response.sendRedirect("/Admin/Board?cmd=boardList");
	}

}
