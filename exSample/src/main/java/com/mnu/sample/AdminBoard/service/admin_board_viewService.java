package com.mnu.sample.AdminBoard.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminBoardDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

public class admin_board_viewService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));

		AdminBoardDAO Andao = AdminBoardDAO.getInstance();
		
		
		
		Andao.AdminboardCount(idx); //조회수 +1
		
		
		
		BoardDTO Andto = Andao.AdminboardSearch(idx);

		Andto.setContents(Andto.getContents().replace("\n","<br>"));
		request.setAttribute("dto", Andto);
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/board_view.jsp");
		rd.forward(request, response);

	}

}
