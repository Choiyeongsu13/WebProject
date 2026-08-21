package com.mnu.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.AdminPds.service.admin_pds_deleteproService;
import com.mnu.sample.AdminPds.service.admin_pds_listService;
import com.mnu.sample.AdminPds.service.admin_pds_modifyService;
import com.mnu.sample.AdminPds.service.admin_pds_modifyproService;
import com.mnu.sample.AdminPds.service.admin_pds_viewService;
import com.mnu.sample.AdminPds.service.admin_pds_writeService;
import com.mnu.sample.AdminPds.service.admin_pds_writeproService;
import com.mnu.sample.service.Action;

/**
 * Servlet implementation class AdminPdsController
 */
@WebServlet("/Admin/Pds")
public class AdminPdsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPdsController() {
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

		if(cmd.equals("pdsList")) {
			action= new admin_pds_listService();
		}
		else if(cmd.equals("pdsWrite"))
		{
			action = new admin_pds_writeService();
		}
		else if(cmd.equals("pdsWritepro"))
		{
			action = new admin_pds_writeproService();
		}
		else if(cmd.equals("pdsView"))
		{
			action = new admin_pds_viewService();
		}
		else if(cmd.equals("pdsModifypro"))
		{
			action = new admin_pds_modifyproService();
		}
		else if(cmd.equals("pdsModify"))
		{
			action = new admin_pds_modifyService();
		}
		else if(cmd.equals("pdsDeletepro"))
		{
			action = new admin_pds_deleteproService();
		}
		else
		{
			action = new admin_pds_listService();
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
