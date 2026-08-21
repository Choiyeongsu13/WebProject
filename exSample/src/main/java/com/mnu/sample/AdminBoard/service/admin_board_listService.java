package com.mnu.sample.AdminBoard.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminBoardDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

public class admin_board_listService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AdminBoardDAO Andao = AdminBoardDAO.getInstance();
		
		int totcount = Andao.AdminboardcountList(); //총 게시글수
		List<BoardDTO> AnList = Andao.AdminboardList(); //전체 글 목록
		
		request.setAttribute("AnList", AnList);
		request.setAttribute("totcount", totcount);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/board_list.jsp");
		rd.forward(request, response);
	}

}
