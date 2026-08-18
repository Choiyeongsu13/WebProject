package com.mnu.ElectionMVC.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.ElectionMVC.service.Action;
import com.mnu.ElectionMVC.service.ScoreService;
import com.mnu.ElectionMVC.service.SearchService;
import com.mnu.ElectionMVC.service.VoteListService;
import com.mnu.ElectionMVC.service.VoteService;

/**
 * Servlet implementation class ElectionController
 */
@WebServlet("/Election")
public class ElectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ElectionController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cmd = request.getParameter("cmd");

		System.out.println("사용자의 요청: " + cmd);
		Action action = null;

		if (cmd.equals("Search")) {
			action = new SearchService();
		} else if (cmd.equals("Vote")) {
			action = new VoteService();
		} else if (cmd.equals("VoteList")) {
			action = new VoteListService();
		} else if (cmd.equals("Score")) {
			action = new ScoreService();
		} else if(cmd.equals("Search")){
			action = new SearchService();
		}

		action.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
