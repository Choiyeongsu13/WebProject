package com.mnu.sample.AdminPds.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminPdsDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

public class admin_pds_modifyproService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		AdminPdsDAO Andao = AdminPdsDAO.getInstance();
		BoardDTO Andto = new BoardDTO();

		int idx = Integer.parseInt(request.getParameter("idx"));

		Andto.setIdx(idx);
		Andto.setName(request.getParameter("name"));
		Andto.setEmail(request.getParameter("email"));
		Andto.setSubject(request.getParameter("subject"));
		Andto.setContents(request.getParameter("contents"));
		Andto.setPass(request.getParameter("pass"));

		Andao.AdminpdsModify(Andto);

		response.sendRedirect("/Admin/Pds?cmd=pdsView&idx=" + idx);
	}

}
