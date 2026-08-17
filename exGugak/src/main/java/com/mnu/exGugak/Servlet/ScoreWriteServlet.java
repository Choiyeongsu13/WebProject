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
 * Servlet implementation class ScoreWrite
 */
@WebServlet("/ScoreWrite")
public class ScoreWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rd = request.getRequestDispatcher("ScoreWrite.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		GugakDAO dao = GugakDAO.getInstance();
		tbl_recordDTO dto = new tbl_recordDTO();

		String entry_no = request.getParameter("entry_no");
		int score1 = Integer.parseInt(request.getParameter("score1"));
		int score2 = Integer.parseInt(request.getParameter("score2"));
		int score3 = Integer.parseInt(request.getParameter("score3"));
		int score4 = Integer.parseInt(request.getParameter("score4"));
		int score5 = Integer.parseInt(request.getParameter("score5"));

		dto.setEntry_no(entry_no);
		dto.setScore1(score1);
		dto.setScore2(score2);
		dto.setScore3(score3);
		dto.setScore4(score4);
		dto.setScore5(score5);

		request.setAttribute("dto", dto);

		RequestDispatcher rd = request.getRequestDispatcher("ScoreWrite.jsp");
		rd.forward(request, response);
	}

}