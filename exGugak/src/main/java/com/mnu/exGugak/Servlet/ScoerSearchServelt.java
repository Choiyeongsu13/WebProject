package com.mnu.exGugak.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exGugak.model.GugakDAO;
import com.mnu.exGugak.model.tbl_refereeDTO;
import com.mnu.exGugak.model.wrapperDTO;

/**
 * Servlet implementation class ScoerSearchServelt
 */
@WebServlet("/ScoreSearch")
public class ScoerSearchServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoerSearchServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
 
		RequestDispatcher rd = request.getRequestDispatcher("ScoreSearch.jsp");
		rd.forward(request, response);
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
 
		String entry_no = request.getParameter("entry_no");
 
		GugakDAO dao = GugakDAO.getInstance();
		wrapperDTO dto = dao.getResult(entry_no);
 
		if (dto != null) {
			List<tbl_refereeDTO> refereeList = dao.getRefereeList();
			if (!refereeList.isEmpty()) {
				dto.setTbl_refereeDTO(refereeList.get(0));
			}
		}
 
		request.setAttribute("entry_no", entry_no);
		request.setAttribute("dto", dto);
 
		RequestDispatcher rd = request.getRequestDispatcher("ScoreSearch.jsp");
		rd.forward(request, response);
	}

}
