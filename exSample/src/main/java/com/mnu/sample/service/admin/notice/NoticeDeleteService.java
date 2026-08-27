package com.mnu.sample.service.admin.notice;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.NoticeDAO;
import com.mnu.sample.service.Action;

public class NoticeDeleteService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO nDAO = NoticeDAO.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int row = nDAO.noticeDelete(idx);
		
		response.sendRedirect("/Admin/Notice?cmd=noticeList");
		
		//RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_list.jsp");
		//rd.forward(request, response);
	}

}
