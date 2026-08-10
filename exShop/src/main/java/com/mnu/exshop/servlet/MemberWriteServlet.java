package com.mnu.exshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exshop.model.CityDTO;
import com.mnu.exshop.model.MemberDTO;
import com.mnu.exshop.model.ShopDAO;

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
		ShopDAO dao = ShopDAO.getInstance();
		int custno = dao.custMAX();
		List<CityDTO> list = dao.cityList();
		
		request.setAttribute("custno", custno);
		request.setAttribute("list", list);
		
	    RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
	    rd.forward(request, response);
	    
	    


	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

	    MemberDTO dto = new MemberDTO();
	    dto.setCustno(Integer.parseInt(request.getParameter("custno")));
	    dto.setCustname(request.getParameter("custname"));
	    
	    // phone1, phone2, phone3을 개별로 수신
	    String p1 = request.getParameter("phone1");
	    String p2 = request.getParameter("phone2");
	    String p3 = request.getParameter("phone3");
	    dto.setPhone(p1 + "-" + p2 + "-" + p3);
	    
	    dto.setGender(request.getParameter("gender"));
	    dto.setJoindate(request.getParameter("joindate"));
	    dto.setGrade(request.getParameter("grade"));
	    dto.setCity(request.getParameter("city"));

	    ShopDAO dao = ShopDAO.getInstance();
	    int row = dao.memberWrite(dto);

	    request.setAttribute("row", row);

	    RequestDispatcher rd = request.getRequestDispatcher("/index_pro.jsp");
	    rd.forward(request, response);
	}
}