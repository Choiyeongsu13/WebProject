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
import com.mnu.exArtist.model.ArtistRankDTO;

@WebServlet("/Artist_Rank")
public class ArtistRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ArtistRankServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArtDAO dao = ArtDAO.getInstance();
        List<ArtistRankDTO> list = dao.ArtistRankList();

        request.setAttribute("list", list);

        RequestDispatcher rd= request.getRequestDispatcher("/ArtistRank.jsp");
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}