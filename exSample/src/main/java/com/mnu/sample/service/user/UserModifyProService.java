package com.mnu.sample.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
//회원정보 수정 처리
public class UserModifyProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RequestDispatcher rd = request.getRequestDispatcher("/");
		rd.forward(request, response);

	}

}
