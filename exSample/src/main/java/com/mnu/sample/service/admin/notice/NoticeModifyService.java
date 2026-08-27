package com.mnu.sample.service.admin.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.NoticeDAO;
import com.mnu.sample.model.NoticeDTO;
import com.mnu.sample.service.Action;

public class NoticeModifyService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO nDAO = NoticeDAO.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		NoticeDTO nDTO = nDAO.noticeSearch(idx);
		
		request.setAttribute("nDTO", nDTO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_modify.jsp");
		rd.forward(request, response);
	}

}
