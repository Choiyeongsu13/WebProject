package com.mun.join.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinWriteServlet
 */
@WebServlet("/join_write.do")
public class JoinWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    String irum = request.getParameter("irum");
	    String gender = "남자";
	    if(request.getParameter("gender").equals("F"))
	    		gender="여자";
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
	    
	    Map<String,String> map = new HashMap();
	    map.put("irum", irum);   map.put("gender", gender);
	    map.put("fa", strFa);   map.put("job", job);
	    map.put("tel", tel);
	    
	    request.setAttribute("map", map);
	    
//	    회원가입 폼 이동
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/Join/join_write2.jsp");
	    rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	    request.setAttribute("name", "집");
	    RequestDispatcher rd = request.getRequestDispatcher("/Join/join_write_ok.jsp");
	    rd.forward(request, response);
	    
	    //변수에 값을 저장하여 다른 jsp 파일로 보내기
	    response.sendRedirect("/index.jsp");
	    
	}

}
