package com.mnu.sample.AdminBoard.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminBoardDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

public class admin_board_writeproService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		AdminBoardDAO Andao = AdminBoardDAO.getInstance();
		BoardDTO Andto = new BoardDTO();

		Andto.setName(request.getParameter("name"));
		Andto.setEmail(request.getParameter("email"));
		Andto.setSubject(request.getParameter("subject"));
		Andto.setContents(request.getParameter("contents"));
		Andto.setPass(request.getParameter("pass"));

		Andao.boardwrite(Andto);

		response.sendRedirect("/Admin/Board?cmd=boardList");

	}

}
