package com.mnu.sample.service.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminUserDTO;
import com.mnu.sample.model.UserDAO;
import com.mnu.sample.service.Action;
//회원 수정폼
public class UserModifyProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO dao = UserDAO.getInstance();
		AdminUserDTO dto = new AdminUserDTO();
	
		dto.setUserid(request.getParameter("userid"));

		dto.setName(request.getParameter("name"));
		dto.setTel(request.getParameter("tel"));
		dto.setEmail(request.getParameter("email"));
		
		int row = dao.userModify(dto);
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("/User/user_modify.jsp");
		rd.forward(request, response);

	}

}
