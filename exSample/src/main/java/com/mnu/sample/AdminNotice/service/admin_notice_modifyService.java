package com.mnu.sample.AdminNotice.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminNoticeDAO;
import com.mnu.sample.model.AdminNoticeDTO;
import com.mnu.sample.service.Action;

public class admin_notice_modifyService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idx =Integer.parseInt(request.getParameter("idx"));

		AdminNoticeDAO Andao = AdminNoticeDAO.getInstance();
		AdminNoticeDTO Andto = Andao.AdminNoticeSearch(idx);

		request.setAttribute("dto", Andto);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_modify.jsp");
		rd.forward(request, response);

	}

}
