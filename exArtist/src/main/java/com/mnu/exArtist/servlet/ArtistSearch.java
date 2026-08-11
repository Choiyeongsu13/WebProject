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
import com.mnu.exArtist.model.ArtistSearchDTO;

@WebServlet("/artist_Search")
public class ArtistSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArtistSearch() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("/artistSearch.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String artist_id = request.getParameter("artist_id").toUpperCase();

		if (artist_id != null) {
			ArtDAO dao = ArtDAO.getInstance();
			List<ArtistSearchDTO> list = dao.searchArtist(artist_id);

			request.setAttribute("list", list);
			request.setAttribute("artist_id", artist_id);
			request.setAttribute("searched", true);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/artistSearch.jsp");
		rd.forward(request, response);
	}
}