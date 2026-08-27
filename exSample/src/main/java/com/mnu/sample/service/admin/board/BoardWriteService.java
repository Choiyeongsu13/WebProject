package com.mnu.sample.service.admin.board;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;

public class BoardWriteService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/board_write.jsp");
		rd.forward(request, response);
	}

}
