package com.profill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.project.service.ProjectListService;
import com.profill.service.Action;


@WebServlet("/Project")
public class ProjectController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			cmd = "";
		}
		System.out.println("작업물 요청 " + cmd);

		Action action = null;

		if (cmd.equals("project_list")) {
			action = new ProjectListService();
		}
		
		/

		if (action == null) {
			action = new ProjectListService();
		}

		action.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}
}
