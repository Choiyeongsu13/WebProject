package com.mnu.sample.service.boardphoto;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.BoardPhotoDAO;
import com.mnu.sample.model.BoardPhotoDTO;
import com.mnu.sample.service.Action;

public class BoardPhotoListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardPhotoDAO bDAO = BoardPhotoDAO.getInstance();
		
		int totcount = bDAO.boardCount();// 총글수
		List<BoardPhotoDTO> bList = bDAO.boardList();
		
		request.setAttribute("totcount", totcount);
		request.setAttribute("bList", bList);
				
		RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_list.jsp");
		rd.forward(request, response);

	}

}
