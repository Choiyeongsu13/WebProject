package com.mnu.sample.AdminPds.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminPdsDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

public class admin_pds_listService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminPdsDAO Andao = AdminPdsDAO.getInstance();

		int totcount = Andao.AdminpdscountList(); //총 자료수
		List<BoardDTO> AnList = Andao.AdminpdsList(); //전체 자료 목록

		request.setAttribute("AnList", AnList);
		request.setAttribute("totcount", totcount);

		RequestDispatcher rd = request.getRequestDispatcher("/Admin/pds_list.jsp");
		rd.forward(request, response);
	}

}
