package com.mnu.exArtist.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exArtist.model.ArtDAO;
import com.mnu.exArtist.model.mentoScoreDTO;

@WebServlet("/mento_score_list")
public class MentoScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArtDAO dao = ArtDAO.getInstance();
		List<mentoScoreDTO> mlist = dao.mentoScoreList();

		request.setAttribute("mlist", mlist);

		RequestDispatcher rd = request.getRequestDispatcher("/mentoScore.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}