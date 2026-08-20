package com.mnu.sample.AdminNotice.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminNoticeDAO;
import com.mnu.sample.model.AdminNoticeDTO;
import com.mnu.sample.service.Action;

public class admin_notice_modifyproService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AdminNoticeDAO Andao = AdminNoticeDAO.getInstance();
		AdminNoticeDTO Andto = new AdminNoticeDTO();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		Andto.setIdx(idx);
		Andto.setSubject(request.getParameter("subject"));
		Andto.setContents(request.getParameter("contents"));

//		int row = Andao.An
//		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_write.jsp");
		rd.forward(request, response);

	}

}
