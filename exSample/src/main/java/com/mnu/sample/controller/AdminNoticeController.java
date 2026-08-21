package com.mnu.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.AdminNotice.service.admin_notice_deleteService;
import com.mnu.sample.AdminNotice.service.admin_notice_listService;
import com.mnu.sample.AdminNotice.service.admin_notice_modifyService;
import com.mnu.sample.AdminNotice.service.admin_notice_modifyproService;
import com.mnu.sample.AdminNotice.service.admin_notice_viewService;
import com.mnu.sample.AdminNotice.service.admin_notice_writeService;
import com.mnu.sample.AdminNotice.service.admin_notice_writeproService;
import com.mnu.sample.service.Action;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/Admin/Notice")
public class AdminNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeController() {
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

		if(cmd.equals("noticeList")) {
			action= new admin_notice_listService();
		}
		else if(cmd.equals("noticeWrite")) 
		{
			action = new admin_notice_writeService();
		}
		else if(cmd.equals("noticeWritepro")) 
		{
			action = new admin_notice_writeproService();
		}
		
		else if(cmd.equals("noticeView")) 
		{
			action = new admin_notice_viewService();
		}
		else if(cmd.equals("noticeModifypro")) 
		{
			action = new admin_notice_modifyproService();
		}
		else if(cmd.equals("noticeModify"))
		{
			action = new admin_notice_modifyService();
		}
		else if(cmd.equals("noticeDelete"))
		{
			action = new admin_notice_deleteService();
		}
		else
		{
			action = new admin_notice_listService();
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
