package com.mnu.sample.service.Pds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.PdsDAO;
import com.mnu.sample.model.PdsDTO;
import com.mnu.sample.service.Action;

public class PdsModifyProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		PdsDAO Andao = PdsDAO.getInstance();
		PdsDTO Andto = new PdsDTO();

		int idx = Integer.parseInt(request.getParameter("idx"));

		Andto.setIdx(idx);
		Andto.setName(request.getParameter("name"));
		Andto.setEmail(request.getParameter("email"));
		Andto.setSubject(request.getParameter("subject"));
		Andto.setContents(request.getParameter("contents"));
		Andto.setPass(request.getParameter("pass"));

		Andao.PdsModify(Andto);

		response.sendRedirect("/Pds/Pds?cmd=pdsView&idx=" + idx);
	}

}
