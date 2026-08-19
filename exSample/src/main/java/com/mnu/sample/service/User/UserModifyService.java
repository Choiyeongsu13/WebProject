package com.mnu.sample.service.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
//회원 수정폼
public class UserModifyService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/User/user_modify.jsp");
		rd.forward(request, response);

	}

}
