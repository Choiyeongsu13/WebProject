package com.mnu.sample.service.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
//공지사항 목록
public class NoticeListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RequestDispatcher rd = request.getRequestDispatcher("/Notice/notice_list.jsp");
		rd.forward(request, response);

	}

}
