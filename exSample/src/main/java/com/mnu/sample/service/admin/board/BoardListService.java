package com.mnu.sample.service.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.NoticeDAO;
import com.mnu.sample.model.NoticeDTO;
import com.mnu.sample.service.Action;

public class BoardListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/board_list.jsp");
		rd.forward(request, response);
	}

}
