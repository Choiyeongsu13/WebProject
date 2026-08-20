package com.mnu.sample.service.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.BoardDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

public class BoardModifyProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = new BoardDTO();
		int idx = Integer.parseInt(request.getParameter("idx"));
		dto.setIdx(idx);
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContents(request.getParameter("contents"));
		dto.setPass(request.getParameter("pass"));

		int row = dao.boardModify(dto);
		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("/Board/board_modifypro.jsp");
		rd.forward(request, response);
	}

}