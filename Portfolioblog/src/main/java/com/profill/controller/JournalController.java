package com.profill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.journal.service.CommentDeleteProService;
import com.profill.journal.service.CommentWriteProService;
import com.profill.journal.service.JournalListService;
import com.profill.journal.service.JournalViewService;
import com.profill.service.Action;

/**
 * 글(Journal) 화면과 댓글을 담당
 */
@WebServlet("/Journal")
public class JournalController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			cmd = "";
		}
		System.out.println("글 요청 " + cmd);

		Action action = null;

		if (cmd.equals("journal_view")) {
			action = new JournalViewService();
		} else if (cmd.equals("comment_write")) {
			action = new CommentWriteProService();
		} else if (cmd.equals("comment_delete")) {
			action = new CommentDeleteProService();
		}

		if (action == null) {
			action = new JournalListService();
		}

		action.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}
}
