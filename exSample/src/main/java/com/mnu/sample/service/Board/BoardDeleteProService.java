package com.mnu.sample.service.Board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.BoardDAO;
import com.mnu.sample.service.Action;

public class BoardDeleteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = request.getParameter("pass");

		BoardDAO dao = BoardDAO.getInstance();
		int row = dao.boardDelete(idx, pass);

	
	

		response.sendRedirect(request.getContextPath() + "/Board?cmd=board_list");
	}

}