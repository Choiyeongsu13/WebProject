package com.mnu.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
import com.mnu.sample.service.board.BoardDeleteProService;
import com.mnu.sample.service.board.BoardDeleteService;
import com.mnu.sample.service.board.BoardListService;
import com.mnu.sample.service.board.BoardModifyProService;
import com.mnu.sample.service.board.BoardModifyService;
import com.mnu.sample.service.board.BoardViewService;
import com.mnu.sample.service.board.BoardWriteProService;
import com.mnu.sample.service.board.BoardWriteService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/Board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		System.out.println("자유게시판 요청 : " + cmd);

		Action action = null;
		if(cmd.equals("boardList")) {
			action = new BoardListService();
		}else if(cmd.equals("boardWrite")) {
			action = new BoardWriteService();//등록폼
		}else if(cmd.equals("boardWritePro")) {
			action = new BoardWriteProService();//등록처리
		}else if(cmd.equals("boardView")) {
			action = new BoardViewService();//뷰(상세보기)
		}else if(cmd.equals("boardModify")) {
			action = new BoardModifyService();//수정 폼
		}else if(cmd.equals("boardModifyPro")) {
			action = new BoardModifyProService();//수정처리
		}else if(cmd.equals("boardDelete")) {
			action = new BoardDeleteService();//삭제 폼
		}else if(cmd.equals("boardDeletePro")) {
			action = new BoardDeleteProService();//삭제처리
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
