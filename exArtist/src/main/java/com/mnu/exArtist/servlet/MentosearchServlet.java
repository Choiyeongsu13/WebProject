package com.mnu.exArtist.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exArtist.model.ArtDAO;
import com.mnu.exArtist.model.mentoScoreDTO;

@WebServlet("/mento_score_search")
public class MentosearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MentosearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String serial_noStr = request.getParameter("serial_no");

		if (serial_noStr != null) {
			List<mentoScoreDTO> mlist;

			if (serial_noStr.trim().length() > 0) {
				try {
					int serial_no = Integer.parseInt(serial_noStr.trim());
					ArtDAO dao = ArtDAO.getInstance();
					mlist = dao.mentoScorelist(serial_no);
				} catch (NumberFormatException e) {
					mlist = new ArrayList<mentoScoreDTO>();
				}
			} else {
				mlist = new ArrayList<mentoScoreDTO>();
			}

			request.setAttribute("mlist", mlist);
			request.setAttribute("serial_no", serial_noStr);
			request.setAttribute("searched", true);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/mentosearch.jsp");
		rd.forward(request, response);
	}
}