package com.profill.project.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.ProfillDAO;
import com.profill.service.Action;


public class ProjectListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProfillDAO dao = ProfillDAO.getInstance();

		request.setAttribute("projects", dao.projectList());

		RequestDispatcher rd = request.getRequestDispatcher("/projects.jsp");
		rd.forward(request, response);
	}
}
