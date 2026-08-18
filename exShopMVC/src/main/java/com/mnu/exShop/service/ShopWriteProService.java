package com.mnu.exShop.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exShop.model.MemberDTO;
import com.mnu.exShop.model.ShopDAO;

public class ShopWriteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ShopDAO dao = ShopDAO.getInstance();
		MemberDTO dto = new MemberDTO();
		
		dto.setCustno(Integer.parseInt(request.getParameter("custno")));
		
		int row = dao.memberWrite(dto);
	
		response.sendRedirect("/");
	}
	
	

}
