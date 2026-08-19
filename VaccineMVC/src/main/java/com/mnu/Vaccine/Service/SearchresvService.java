package com.mnu.Vaccine.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.Vaccine.model.SearchresvDTO;
import com.mnu.Vaccine.model.VacDAO;

public class SearchresvService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VacDAO dao = VacDAO.getInstance();

		String resvno = request.getParameter("resvno");
		List<SearchresvDTO> list = dao.searchlist(resvno);

		String page;
		if(list == null || list.isEmpty()) {
			page = "NoSearchresv.jsp";
		} else {
			request.setAttribute("list", list);
			page = "Searchresv.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}

}
