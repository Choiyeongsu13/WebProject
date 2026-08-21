package com.mnu.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.AdminUser.service.admin_user_deleteproService;
import com.mnu.sample.AdminUser.service.admin_user_listService;
import com.mnu.sample.AdminUser.service.admin_user_modifyService;
import com.mnu.sample.AdminUser.service.admin_user_modifyproService;
import com.mnu.sample.AdminUser.service.admin_user_viewService;
import com.mnu.sample.AdminUser.service.admin_user_writeService;
import com.mnu.sample.AdminUser.service.admin_user_writeproService;
import com.mnu.sample.service.Action;

/**
 * Servlet implementation class AdminUserController
 */
@WebServlet("/Admin/User")
public class AdminUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserController() {
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

		if(cmd.equals("userList")) {
			action= new admin_user_listService();
		}
		else if(cmd.equals("userWrite"))
		{
			action = new admin_user_writeService();
		}
		else if(cmd.equals("userWritepro"))
		{
			action = new admin_user_writeproService();
		}
		else if(cmd.equals("userView"))
		{
			action = new admin_user_viewService();
		}
		else if(cmd.equals("userModifypro"))
		{
			action = new admin_user_modifyproService();
		}
		else if(cmd.equals("userModify"))
		{
			action = new admin_user_modifyService();
		}
		else if(cmd.equals("userDeletepro"))
		{
			action = new admin_user_deleteproService();
		}
		else
		{
			action = new admin_user_listService();
		}

		action.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");// TODO Auto-generated method stub
		doGet(request, response);
	}

}
