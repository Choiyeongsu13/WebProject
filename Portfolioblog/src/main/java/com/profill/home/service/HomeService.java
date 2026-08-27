package com.profill.home.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.ProfillDAO;
import com.profill.service.Action;

public class HomeService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProfillDAO dao = ProfillDAO.getInstance();

		String lang = (String) request.getSession().getAttribute("lang");

		request.setAttribute("featured", dao.projectFeatured(3));
		request.setAttribute("langs", dao.projectTagMap());
		request.setAttribute("catNames", dao.categoryList(lang));
		request.setAttribute("techPosts", dao.postRecent("TECH", 2));
		request.setAttribute("travelPosts", dao.postRecent("TRAVEL", 2));

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}
