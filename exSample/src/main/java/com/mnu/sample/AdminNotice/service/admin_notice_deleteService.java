package com.mnu.sample.AdminNotice.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminNoticeDAO;
import com.mnu.sample.service.Action;

public class admin_notice_deleteService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminNoticeDAO dao = AdminNoticeDAO.getInstance();
		
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int row = dao.AdminNoticeDelete(idx);
		
		response.sendRedirect("/Admin/Notice?cmd=noticeList");
	
	}

}