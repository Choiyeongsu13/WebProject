package com.mnu.exStudent.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exStudent.model.StuDAO;
import com.mnu.exStudent.model.StuScoreDTO;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		StuDAO dao = StuDAO.getInstance();
		StuScoreDTO dto = new StuScoreDTO();
		
		String syear = request.getParameter("syear");
		String sclass = request.getParameter("sclass");
		String sno = request.getParameter("sno");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));

	
		dto.setSyear(syear);
		dto.setSclass(sclass);
		dto.setSno(sno);
		dto.setKor(kor);
		dto.setEng(eng); 
		dto.setMat(mat);

		
		
		int row = dao.insertScore(dto);
		
		

		if (row > 0) {
		    response.sendRedirect("index	.jsp");
		} else {
		    response.getWriter().println("<script>alert('등록 실패: 입력값을 확인하세요.'); history.back();</script>");
		}
	}

}
