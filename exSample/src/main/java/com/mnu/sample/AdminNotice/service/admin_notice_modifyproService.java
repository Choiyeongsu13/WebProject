package com.mnu.sample.AdminNotice.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminNoticeDAO;
import com.mnu.sample.model.AdminNoticeDTO;
import com.mnu.sample.service.Action;

public class admin_notice_modifyproService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		AdminNoticeDAO Andao = AdminNoticeDAO.getInstance();
		AdminNoticeDTO Andto = new AdminNoticeDTO();

		int idx = Integer.parseInt(request.getParameter("idx"));

		Andto.setIdx(idx);
		Andto.setSubject(request.getParameter("subject"));
		Andto.setContents(request.getParameter("contents"));

		Andao.AdminNoticeModify(Andto);

//		response.sendRedirect("/Admin/Notice?cmd=noticeView&idx=" + idx);
		response.sendRedirect("/Admin/Notice?cmd=noticeList");

	}

}
