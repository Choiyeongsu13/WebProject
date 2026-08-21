package com.mnu.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.AdminBoard.service.admin_board_deleteproService;
import com.mnu.sample.AdminBoard.service.admin_board_listService;
import com.mnu.sample.AdminBoard.service.admin_board_modifyService;
import com.mnu.sample.AdminBoard.service.admin_board_modifyproService;
import com.mnu.sample.AdminBoard.service.admin_board_viewService;
import com.mnu.sample.AdminBoard.service.admin_board_writeService;
import com.mnu.sample.AdminBoard.service.admin_board_writeproService;
import com.mnu.sample.service.Action;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/Admin/Board")
public class AdminBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd= request.getParameter("cmd");
		if(cmd==null) cmd="";
		System.out.println("관리자 요청" +  cmd);
		Action action=null;

		if(cmd.equals("boardList")) {
			action= new admin_board_listService();
		}
		else if(cmd.equals("boardWrite")) 
		{
			action = new admin_board_writeService();
		}
		else if(cmd.equals("boardWritepro")) 
		{
			action = new admin_board_writeproService();
		}
		
		else if(cmd.equals("boardView")) 
		{
			action = new admin_board_viewService();
		}
		else if(cmd.equals("boardModifypro")) 
		{
			action = new admin_board_modifyproService();
		}
		else if(cmd.equals("boardModify"))
		{
			action = new admin_board_modifyService();
		}
		else if(cmd.equals("boardDeletepro"))
		{
			action = new admin_board_deleteproService();
		}
		else
		{
			action = new admin_board_listService();
		}

		action.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
