package com.mnu.ElectionMVC.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.ElectionMVC.model.EltDAO;
import com.mnu.ElectionMVC.model.searchDTO;

public class SearchService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EltDAO dao = EltDAO.getInstance();

		List<searchDTO> list = dao.searchList();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("Search.jsp");
		rd.forward(request, response);
	}
}
