package com.mnu.sample.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
import com.mnu.sample.service.User.UserIdcheckService;
import com.mnu.sample.service.User.UserLoginProService;
import com.mnu.sample.service.User.UserLoginService;
import com.mnu.sample.service.User.UserLogoutService;
import com.mnu.sample.service.User.UserModifyProService;
import com.mnu.sample.service.User.UserModifyService;
import com.mnu.sample.service.User.UserWriteProService;
import com.mnu.sample.service.User.UserWriteService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/User")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// FIX: text/plain으로 고정되어 있어 forward된 JSP가 HTML이 아닌 순수 텍스트로 렌더링되던 문제
		response.setContentType("text/html; charset=UTF-8");
		String cmd= request.getParameter("cmd");
		System.out.println("회원관리 요청" +  cmd);
		Action action=null;
		
		if(cmd.equals("user_login")) { //로그인
			action= new UserLoginService();
		}else if(cmd.equals("UserLoginPro")) { //로그인처리
			action = new UserLoginProService();
		}	
		else if(cmd.equals("UserLogout")) { //로그아웃
			action = new UserLogoutService();
		}else if(cmd.equals("userInsert")) { //회원가입
			action = new UserWriteService();
		}else if(cmd.equals("userIdcheck")){	//ID중복검사
			action = new UserIdcheckService();
		}else if(cmd.equals("userModify")) { //수정
			action = new UserModifyService();
		}else if(cmd.equals("UserModifyPro")) { //수정처리
			action = new UserModifyProService();
		}else if(cmd.equals("UserWritePro")) { //회원가입 처리
			action = new UserWriteProService();
		}
		
		
		action.process(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		// FIX: text/plain으로 고정되어 있어 forward된 JSP가 HTML이 아닌 순수 텍스트로 렌더링되던 문제
		response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}
