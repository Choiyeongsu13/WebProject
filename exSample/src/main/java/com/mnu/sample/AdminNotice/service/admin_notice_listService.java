package com.mnu.sample.AdminNotice.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminNoticeDAO;
import com.mnu.sample.model.AdminNoticeDTO;
import com.mnu.sample.service.Action;

public class admin_notice_listService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AdminNoticeDAO Andao = AdminNoticeDAO.getInstance();
		List<AdminNoticeDTO> AnList =null;
		int totcount=0;
		String search="",key="";
		
		if(request.getParameter("key")!=null) {
			//검색이용시
			search=request.getParameter("search");
			key=request.getParameter("key");
			totcount = Andao.AdminNoticecountList(search, key); //총 게시글수
			AnList = Andao.AdminNoticeList(search, key); //전체 글 목록
		}else {
			totcount = Andao.AdminNoticecountList(); //총 게시글수
			AnList = Andao.AdminNoticeList(); //전체 글 목록
		}

		
		request.setAttribute("AnList", AnList);
		request.setAttribute("totcount", totcount);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_list.jsp");
		rd.forward(request, response);
	}

}
