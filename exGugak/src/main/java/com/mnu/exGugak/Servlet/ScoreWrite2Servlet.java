package com.mnu.exGugak.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exGugak.model.GugakDAO;
import com.mnu.exGugak.model.tbl_recordDTO;

/**
 * Servlet implementation class ScoreWrite2Servlet
 */
@WebServlet("/ScoreWrite2")
public class ScoreWrite2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreWrite2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rd = request.getRequestDispatcher("ScoreWrite2.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		GugakDAO dao = GugakDAO.getInstance();
		tbl_recordDTO dto = new tbl_recordDTO();

		
		
		
		
		
		String entry_no = request.getParameter("entry_no");
		String[] scoreParams = request.getParameterValues("score");

		int[] scores = new int[scoreParams.length];
		for (int i = 0; i < scoreParams.length; i++) {
			scores[i] = Integer.parseInt(scoreParams[i]);
		}

		dto.setEntry_no(entry_no);
		dto.setScore(scores);

		dao.getscorewriteArray(dto);

		request.setAttribute("dto", dto);

		RequestDispatcher rd = request.getRequestDispatcher("ScoreWrite2.jsp");
		rd.forward(request, response);
	}

}
