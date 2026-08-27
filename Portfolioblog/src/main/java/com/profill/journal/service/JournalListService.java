package com.profill.journal.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.ProfillDAO;
import com.profill.service.Action;

public class JournalListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cat = request.getParameter("cat");
		if (!"TECH".equals(cat) && !"TRAVEL".equals(cat) && !"DAILY".equals(cat)) {
			cat = null;
		}

		ProfillDAO dao = ProfillDAO.getInstance();

		String lang = (String) request.getSession().getAttribute("lang");

		request.setAttribute("posts", dao.postList(cat));
		request.setAttribute("catNames", dao.categoryList(lang));
		request.setAttribute("cat", cat == null ? "" : cat);

		RequestDispatcher rd = request.getRequestDispatcher("/posts.jsp");
		rd.forward(request, response);
	}
}
