package com.mnu.sample.service.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mnu.sample.model.AdminUserDTO;
import com.mnu.sample.model.UserDAO;
import com.mnu.sample.service.Action;
import com.mnu.sample.util.UserSHA256;
//로그인 처리
public class UserLoginProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = UserSHA256.getSHA256(request.getParameter("passwd"));

		AdminUserDTO udto = new AdminUserDTO();
		udto.setUserid(userid);
		udto.setPasswd(passwd);

		UserDAO uDAO = UserDAO.getInstance();
		AdminUserDTO user = uDAO.userLogin(udto);

		
		if(user != null) {
			//로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			session.setMaxInactiveInterval(600); //10분
		
		}
		RequestDispatcher rd = request.getRequestDispatcher("/User/userlogin_pro.jsp");
		rd.forward(request, response);
		
	}

}
