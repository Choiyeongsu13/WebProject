package com.mnu.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.AdminGallery.service.admin_gallery_deleteproService;
import com.mnu.sample.AdminGallery.service.admin_gallery_listService;
import com.mnu.sample.AdminGallery.service.admin_gallery_modifyService;
import com.mnu.sample.AdminGallery.service.admin_gallery_modifyproService;
import com.mnu.sample.AdminGallery.service.admin_gallery_viewService;
import com.mnu.sample.AdminGallery.service.admin_gallery_writeService;
import com.mnu.sample.AdminGallery.service.admin_gallery_writeproService;
import com.mnu.sample.service.Action;

/**
 * Servlet implementation class AdminGalleryController
 */
@WebServlet("/Admin/Gallery")
public class AdminGalleryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGalleryController() {
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

		if(cmd.equals("galleryList")) {
			action= new admin_gallery_listService();
		}
		else if(cmd.equals("galleryWrite"))
		{
			action = new admin_gallery_writeService();
		}
		else if(cmd.equals("galleryWritepro"))
		{
			action = new admin_gallery_writeproService();
		}
		else if(cmd.equals("galleryView"))
		{
			action = new admin_gallery_viewService();
		}
		else if(cmd.equals("galleryModifypro"))
		{
			action = new admin_gallery_modifyproService();
		}
		else if(cmd.equals("galleryModify"))
		{
			action = new admin_gallery_modifyService();
		}
		else if(cmd.equals("galleryDeletepro"))
		{
			action = new admin_gallery_deleteproService();
		}
		else
		{
			action = new admin_gallery_listService();
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
