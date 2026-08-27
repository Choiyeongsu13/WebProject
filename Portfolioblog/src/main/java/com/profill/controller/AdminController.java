package com.profill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.profill.adminlogin.service.AdminLoginProService;
import com.profill.adminlogin.service.AdminWriteProService;
import com.profill.adminlogin.service.AdminWriteService;
import com.profill.adminlogin.service.AdminLoginService;
import com.profill.adminlogin.service.AdminLogoutService;
import com.profill.service.Action;

/**
 * 관리자 화면을 담당
 */
@WebServlet("/Admin")
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private boolean needsLogin(String cmd) {
		return cmd.equals("admin_write") || cmd.equals("admin_writepro");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			cmd = "";
		}
		System.out.println("관리자 요청 " + cmd);

		if (needsLogin(cmd)) {
			HttpSession session = request.getSession();
			if (session.getAttribute("loginUser") == null) {
				response.sendRedirect(request.getContextPath() + "/Admin?cmd=admin_login");
				return;
			}
		}

		Action action = null;

		if (cmd.equals("admin_loginpro")) {
			action = new AdminLoginProService();
		} else if (cmd.equals("admin_logout")) {
			action = new AdminLogoutService();
		} else if (cmd.equals("admin_write")) {
			action = new AdminWriteService();
		} else if (cmd.equals("admin_writepro")) {
			action = new AdminWriteProService();
		}

		if (action == null) {
			action = new AdminLoginService();
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
