package com.mnu.Vaccine.Service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.Vaccine.model.VacDAO;
import com.mnu.Vaccine.model.VaccresvDTO;

public class VaccresvService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		VacDAO dao = VacDAO.getInstance();
		
		
		
		VaccresvDTO dto = new VaccresvDTO();
		
		dto.setResvno(request.getParameter("resvno"));
		dto.setJumin(request.getParameter("jumin"));
		dto.setVcode(request.getParameter("vcode"));
		dto.setHospcode(request.getParameter("hospcode"));
		dto.setResvdate(request.getParameter("resvdate"));
		dto.setResvyime(request.getParameter("resvyime"));
		
		dao.vacwrite(dto);
		request.setAttribute("dao", dao);
		
		RequestDispatcher rd= request.getRequestDispatcher("Vaccresv.jsp");
		rd.forward(request, response);
	}

}
