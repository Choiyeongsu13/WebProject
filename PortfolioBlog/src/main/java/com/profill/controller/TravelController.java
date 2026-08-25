package com.profill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.service.Action;
import com.profill.travel.service.TravelListService;

/**
 * 여행(Travel) 화면을 담당
 */
@WebServlet("/Travel")
public class TravelController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			cmd = "";
		}
		System.out.println("여행 요청 " + cmd);

		Action action = null;

		if (cmd.equals("travel_list")) {
			action = new TravelListService();
		}

		if (action == null) {
			action = new TravelListService();
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
