package com.mnu.Vaccine.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.Vaccine.Service.Action;
import com.mnu.Vaccine.Service.VaccListSerivice;
import com.mnu.Vaccine.Service.VaccresvService;

/**
 * Servlet implementation class VaccListController
 */
@WebServlet("/VaccList")
public class VaccListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaccListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String cmd = request.getParameter("cmd");
		
		System.out.println("사용자 요청 : " + cmd);
		
		Action action = null;
		
		if(cmd.equals("VaccList")) {
			action = new VaccListSerivice();
		}
		
		
		action.process(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doGet(request, response);
	}

}
