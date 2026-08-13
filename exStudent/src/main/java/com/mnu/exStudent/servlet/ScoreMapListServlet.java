package com.mnu.exStudent.servlet;


import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exStudent.model.StuDAO;
import com.mnu.exStudent.model.tbl_scoreDTO;
import com.mnu.exStudent.model.tbl_sutdentDTO;

/**
 * Servlet implementation class ScoreListServlet
 */
@WebServlet("/scoreMapList.do")
public class ScoreMapListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreMapListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StuDAO stuDAO = StuDAO.getInstance();
		
		Map<tbl_sutdentDTO,tbl_scoreDTO> map = stuDAO.scoreList();
		
		request.setAttribute("map", map);
		
		RequestDispatcher rd = request.getRequestDispatcher("scoreMapList.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}