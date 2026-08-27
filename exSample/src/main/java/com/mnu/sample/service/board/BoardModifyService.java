package com.mnu.sample.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.BoardDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

//게시글 등록 폼
public class BoardModifyService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO bDAO = BoardDAO.getInstance();
		BoardDTO bDTO = bDAO.boardSearch(idx);
		
		request.setAttribute("bDTO", bDTO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Board/board_modify.jsp");
		rd.forward(request, response);

	}

}
