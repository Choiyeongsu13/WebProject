package com.mnu.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
import com.mnu.sample.service.Board.BoardDeleteProService;
import com.mnu.sample.service.Board.BoardDeleteService;
import com.mnu.sample.service.Board.BoardListService;
import com.mnu.sample.service.Board.BoardModifyProService;
import com.mnu.sample.service.Board.BoardModifyService;
import com.mnu.sample.service.Board.BoardViewService;
import com.mnu.sample.service.Board.BoardWrtieProService;
import com.mnu.sample.service.Board.BoardWrtieService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/Board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cmd = request.getParameter("cmd");
        System.out.println("자유게시판 요청 " + cmd);

        Action action = null;

    

        if (cmd.equals("board_list")) {
            action = new BoardListService();
        } else if (cmd.equals("boardWrite")) {
            action = new BoardWrtieService();
        } else if (cmd.equals("boardWritepro")) {
            action = new BoardWrtieProService();
        } else if (cmd.equals("boardView")) {
            action = new BoardViewService(); //상세보기
        } else if (cmd.equals("boardModify")) { //수정 폼
            action = new BoardModifyService();
        } else if (cmd.equals("boardModifyPro")) { //수정 처리
            action = new BoardModifyProService();
        } else if (cmd.equals("boardDelete")) { //삭제 폼
            action = new BoardDeleteService();
        } else if (cmd.equals("boardDeletePro")) { //삭제처리
            action = new BoardDeleteProService();
        }


        action.process(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}