package com.mnu.exArtist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exArtist.model.ArtDAO;
import com.mnu.exArtist.model.artistDTO;

@WebServlet("/artist_write")
public class ArtistWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArtistWriteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ArtDAO dao = ArtDAO.getInstance();
		artistDTO dto = new artistDTO();
		
		String artist_id = request.getParameter("artist_id");
		String artist_name = request.getParameter("artist_name");
		String artist_gender = request.getParameter("artist_gender");
		String talent = request.getParameter("talent");
		String agency = request.getParameter("agency");

		String y = request.getParameter("artist_birth1");
		String m = request.getParameter("artist_birth2");
		String d = request.getParameter("artist_birth3");

		
		String artist_birth = (y != null ? y : "") + (m != null ? m : "") + (d != null ? d : "");
		

		
		
		dto.setArtist_id(artist_id);
		dto.setArtist_name(artist_name);
		dto.setArtist_gender(artist_gender);
		dto.setArtist_birth(artist_birth);
		dto.setTalent(talent);
		dto.setAgency(agency);

		
		
		int row = dao.insertArtist(dto);

		if (row > 0) {
		    response.sendRedirect("artist_list");
		}
	}
}