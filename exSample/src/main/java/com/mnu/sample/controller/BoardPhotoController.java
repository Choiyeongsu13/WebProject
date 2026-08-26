package com.mnu.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
import com.mnu.sample.service.BoardPhoto.BoardPhotoDeleteProService;
import com.mnu.sample.service.BoardPhoto.BoardPhotoDeleteService;
import com.mnu.sample.service.BoardPhoto.BoardPhotoListService;
import com.mnu.sample.service.BoardPhoto.BoardPhotoModifyProService;
import com.mnu.sample.service.BoardPhoto.BoardPhotoModifyService;
import com.mnu.sample.service.BoardPhoto.BoardPhotoService;
import com.mnu.sample.service.BoardPhoto.BoardPhotoViewService;
import com.mnu.sample.service.BoardPhoto.BoardPhotoWriteProService;
import com.mnu.sample.service.BoardPhoto.BoardPhotoWriteService;

/**
 * Servlet implementation class BoardPhotoController
 */
@WebServlet("/BoardPhoto")
public class BoardPhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPhotoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd == null) cmd = "";
		System.out.println("포토게시판 요청" +  cmd);
		Action action = null;
		if(cmd.equals("boardPhotoList")) {
			action = new BoardPhotoListService();
		}
		else if(cmd.equals("boardPhotoWrite")) {
			action = new BoardPhotoWriteService();
		}
		else if(cmd.equals("boardPhotoWritePro")) {
			action = new BoardPhotoWriteProService();
		}
		else if(cmd.equals("boardPhotoView")) {
			action = new BoardPhotoViewService();
		}
		else if(cmd.equals("boardPhotoModify")) {
			action = new BoardPhotoModifyService();
		}
		else if(cmd.equals("boardPhotoModifyPro")) {
			action = new BoardPhotoModifyProService();
		}
		else if(cmd.equals("boardPhotoDelete")) {
			action = new BoardPhotoDeleteService();
		}else if(cmd.equals("boardPhotoDeletePro")) {
			action = new BoardPhotoDeleteProService();
		}else {
			action = new BoardPhotoListService();
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
