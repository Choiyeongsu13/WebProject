package com.mnu.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
import com.mnu.sample.service.admin.galley.GalleryListService;
import com.mnu.sample.service.admin.galley.GalleryViewService;

/**
 * Servlet implementation class AdminController
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

		String cmd = request.getParameter("cmd");
		System.out.println("관리자 요청 : " + cmd);
		
		Action action = null;
		if(cmd.equals("galleryList")) {
			action = new GalleryListService();
		}else if(cmd.equals("galleryView")) {
			action = new GalleryViewService();
		}
		
		action.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
