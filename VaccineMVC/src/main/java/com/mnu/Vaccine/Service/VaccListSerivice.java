package com.mnu.Vaccine.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.Vaccine.model.VacDAO;
import com.mnu.Vaccine.model.VaccListDTO;

public class VaccListSerivice implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		VacDAO dao = VacDAO.getInstance();

		List<VaccListDTO> list = dao.vacclist();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("VaccList.jsp");
		rd.forward(request, response);
	}
}
