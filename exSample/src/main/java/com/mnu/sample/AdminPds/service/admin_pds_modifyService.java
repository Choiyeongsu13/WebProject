package com.mnu.sample.AdminPds.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminPdsDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

public class admin_pds_modifyService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));

		AdminPdsDAO Andao = AdminPdsDAO.getInstance();
		BoardDTO Andto = Andao.AdminpdsSearch(idx);

		request.setAttribute("dto", Andto);

		RequestDispatcher rd = request.getRequestDispatcher("/Admin/pds_modify.jsp");
		rd.forward(request, response);
	}

}
