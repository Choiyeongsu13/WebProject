package com.mun.exshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberWriteServlet
 */
@WebServlet("/member_write")
public class MemberWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
	    rd.forward(request, response);


	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	    String custno = request.getParameter("custno");
	    String custname = request.getParameter("custname");
	    String phones []= request.getParameterValues("phone");
	    String phone="";
	    if(phones !=null && phones.length ==3) {
	    	phone = phones[0] + "-" + phones[1] + "-" +  phones[2];
	    }
	    
	    String gender = request.getParameter("gender");
	    String joindate = request.getParameter("joindate");
	    String grade = request.getParameter("grade");
	    String city = request.getParameter("city");
	    
	    
	    int result =1;
	    
	    System.out.println("회원번호 : " + custno);
	    System.out.println("회원성명 : " + custname);
	    System.out.println("회원전화 : " + phone);
	    System.out.println("회원성별 : " +  gender);
	    System.out.println("가입일자 : " + joindate);
	    System.out.println("고객등급 : " + grade);
	    System.out.println("도시코드 : " + city);
	    
	    
	}

}
