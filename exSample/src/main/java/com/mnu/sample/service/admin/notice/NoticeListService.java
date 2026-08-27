package com.mnu.sample.service.admin.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.NoticeDAO;
import com.mnu.sample.model.NoticeDTO;
import com.mnu.sample.service.Action;

public class NoticeListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO nDAO = NoticeDAO.getInstance();
		String search="", key="";
		
		
		int totcount = 0;
		List<NoticeDTO> nList = null;
		
		if(request.getParameter("key") != null) {
			search = request.getParameter("search");
			key = request.getParameter("key");
			totcount = nDAO.noticeCount(search, key);
			nList = nDAO.noticeList(search, key);
		}else {
			totcount = nDAO.noticeCount();
			nList = nDAO.noticeList();			
		}
		
		request.setAttribute("totcount", totcount);
		request.setAttribute("nList", nList);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_list.jsp");
		rd.forward(request, response);
	}

}
