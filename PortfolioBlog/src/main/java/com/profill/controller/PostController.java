package com.profill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.post.service.CommentDeleteProService;
import com.profill.post.service.CommentWriteProService;
import com.profill.post.service.PostListService;
import com.profill.post.service.PostViewService;
import com.profill.service.Action;


@WebServlet("/Post")
public class PostController extends HttpServlet {

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

		if (cmd.equals("post_view")) {
			action = new PostViewService();
		} else if (cmd.equals("comment_write")) {
			action = new CommentWriteProService();
		} else if (cmd.equals("comment_delete")) {
			action = new CommentDeleteProService();
		}

		if (action == null) {
			action = new PostListService();
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
