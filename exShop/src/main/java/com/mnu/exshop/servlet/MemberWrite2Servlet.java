package com.mnu.exshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberWrite2Servlet
 */
@WebServlet("/join_write")
public class MemberWrite2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberWrite2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    RequestDispatcher rd = request.getRequestDispatcher("/join_write02.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		String defaultPhone = request.getParameter("defalt_phone");
		String[] phones = request.getParameterValues("phone");
		String phone = "";
		if (phones != null && phones.length == 2) {
			phone = defaultPhone + "-" + phones[0] + "-" + phones[1];
		}

		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1 + "@" + email2;

		String job = request.getParameter("job");

		String[] interests = request.getParameterValues("interest");
		String interest = "";
		if (interests != null) {
			interest = String.join(",", interests);
		}

		String comment = request.getParameter("comment");

		System.out.println("이름 : " + name);
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + password);
		System.out.println("성별 : " + gender);
		System.out.println("전화번호 : " + phone);
		System.out.println("이메일 : " + email);
		System.out.println("직업 : " + job);
		System.out.println("관심분야 : " + interest);
		System.out.println("한마디 : " + comment);

		RequestDispatcher rd = request.getRequestDispatcher("/join_write02.jsp");
		rd.forward(request, response);
	}

}
