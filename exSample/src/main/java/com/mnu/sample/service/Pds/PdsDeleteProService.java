package com.mnu.sample.service.Pds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.PdsDAO;
import com.mnu.sample.service.Action;

public class PdsDeleteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));

		PdsDAO Andao = PdsDAO.getInstance();
		Andao.PdsDelete(idx);

		response.sendRedirect("/Pds/Pds?cmd=pdsList");
	}

}
