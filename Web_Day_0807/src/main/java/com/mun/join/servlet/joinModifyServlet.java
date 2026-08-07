package com.mun.join.servlet;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class joinModifyServlet
 */
@WebServlet("/join_modify.do")
public class joinModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db에서 사용자 정보 검색
		String name = "name";
		String gender = "gender";
		String fa ="fa";
		String job = "job";
		String tel = "tel";
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("fa", fa);
		request.setAttribute("job", job);
		request.setAttribute("tel", tel);
		RequestDispatcher rd = request.getRequestDispatcher("/Join/join_modify.jsp");
	    rd.forward(request, response);
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정처리 
		request.setCharacterEncoding("utf-8");
	    
	    String name = request.getParameter("name");
	    String gender = request.getParameter("gender");
	    String fa[] = request.getParameterValues("fa"); //배열
	    
	    String strFa="";
	    for(String s : fa){
	   	strFa += s + " ";
	   	}
	   	
	   	String job = request.getParameter("job");
	   	String tel1 = request.getParameter("tel1"); 
	   	String tel2 = request.getParameter("tel2"); 
	   	String tel3 = request.getParameter("tel3"); 
	    String tel = tel1 + "-" + tel2 + "-" +tel3;
	    
	   //db저장
	    int row=1;
	    
	    //request 객체에 값 저장
	    request.setAttribute("row", row);
	    request.setAttribute("name", name);
	    request.setAttribute("name", fa);
	    request.setAttribute("name", job);
	    request.setAttribute("name", tel);
	    RequestDispatcher rd = request.getRequestDispatcher("/Join/join_write_ok2.jsp");
	    rd.forward(request, response);
	}

}
