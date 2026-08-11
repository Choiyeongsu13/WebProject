package com.mnu.exStudent.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exStudent.model.StuDAO;
import com.mnu.exStudent.model.StuWriteDTO;

/**
 * Servlet implementation class StudentWriteServlet
 */
@WebServlet("/StudentWrite")
public class StudentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		StuDAO dao = StuDAO.getInstance();
		StuWriteDTO dto = new StuWriteDTO();
		
		String syear = request.getParameter("syear");
		String sclass = request.getParameter("sclass");
		String sname = request.getParameter("sname");
		String sno = request.getParameter("sno");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");


		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");

		
		 
		

		
		
		dto.setSyear(syear);
		dto.setSclass(sclass);
		dto.setSno(sno);
		dto.setBirth(birth);
		dto.setSname(sname); 
		dto.setGender(gender);
		dto.setTel1(tel1);
		dto.setTel2(tel2);
		dto.setTel3(tel3);

		
		
		int row = dao.insertStudent(dto);
		
		

		if (row > 0) {
		    response.sendRedirect("index.jsp");
		} else {
		    response.getWriter().println("<script>alert('등록 실패: 입력값을 확인하세요.'); history.back();</script>");
		}
	}

}
