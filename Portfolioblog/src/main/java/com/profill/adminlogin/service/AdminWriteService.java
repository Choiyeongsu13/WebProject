package com.profill.adminlogin.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.ProfillDAO;
import com.profill.service.Action;


public class AdminWriteService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProfillDAO dao = ProfillDAO.getInstance();
		String lang = (String) request.getSession().getAttribute("lang");
		request.setAttribute("categories", dao.categoryList(lang));

		RequestDispatcher rd = request.getRequestDispatcher("/admin/write.jsp");
		rd.forward(request, response);
	}
}
