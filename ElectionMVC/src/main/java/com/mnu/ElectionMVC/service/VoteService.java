package com.mnu.ElectionMVC.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.ElectionMVC.model.EltDAO;
import com.mnu.ElectionMVC.model.tbl_memberDTO;
import com.mnu.ElectionMVC.model.tbl_voteDTO;

public class VoteService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		EltDAO dao = EltDAO.getInstance();

		String v_jumin = request.getParameter("v_jumin");

		
			tbl_voteDTO dto = new tbl_voteDTO();
			dto.setV_jumin(v_jumin);
			dto.setV_name(request.getParameter("v_name"));
			dto.setM_no(request.getParameter("m_no"));
			dto.setV_time(request.getParameter("v_time"));
			dto.setV_area(request.getParameter("v_area"));
			dto.setV_confirm(request.getParameter("v_confirm"));

			dao.voteWrite(dto);
			request.setAttribute("dao",dao);
				
		

		List<tbl_memberDTO> list = dao.memberList();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("Vote.jsp");
		rd.forward(request, response);
	}
}
