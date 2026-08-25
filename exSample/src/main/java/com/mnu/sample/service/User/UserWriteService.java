package com.mnu.sample.service.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
//회원가입
public class UserWriteService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/User/user_insert.jsp"); // 기본 폼
//		RequestDispatcher rd = request.getRequestDispatcher("/User/user_insert_sms.jsp"); // sms 폼
//		RequestDispatcher rd = request.getRequestDispatcher("/User/user_insert_email.jsp"); // email 폼
		rd.forward(request, response);

	}

}
