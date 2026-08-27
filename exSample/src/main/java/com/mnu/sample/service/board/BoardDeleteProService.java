package com.mnu.sample.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.BoardDAO;
import com.mnu.sample.service.Action;

//게시글 등록 폼
public class BoardDeleteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = request.getParameter("idx");

		BoardDAO bDAO = BoardDAO.getInstance();
		int row = bDAO.boardDelete(idx, pass);
		
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("/Board/board_delete_pro.jsp");
		rd.forward(request, response);

		//response.sendRedirect("/Board?cmd=boardList");
	}

}
