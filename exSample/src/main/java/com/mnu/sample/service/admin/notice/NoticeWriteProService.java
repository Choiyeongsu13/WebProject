package com.mnu.sample.service.admin.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.NoticeDAO;
import com.mnu.sample.model.NoticeDTO;
import com.mnu.sample.service.Action;

public class NoticeWriteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO nDAO = NoticeDAO.getInstance();
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setSubject(request.getParameter("subject"));
		nDTO.setContents(request.getParameter("contents"));
		
		int row = nDAO.noticeWrite(nDTO);
	
		response.sendRedirect("/Admin/Notice?cmd=noticeList");
/*		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_list.jsp");
		rd.forward(request, response);
*/		
	}

}
