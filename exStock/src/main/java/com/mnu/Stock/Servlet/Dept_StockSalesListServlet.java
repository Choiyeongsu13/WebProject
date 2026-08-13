package com.mnu.Stock.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.Stock.model.DeptSalesDTO;
import com.mnu.Stock.model.StockDAO;

/**
 * Servlet implementation class Dept_StockSalesListServlet
 */
@WebServlet({"/Dept_StockSalesListServlet", "/Dept_StockSalesList"})
public class Dept_StockSalesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dept_StockSalesListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDAO dao = StockDAO.getInstance();
		List<DeptSalesDTO> list = dao.deptsaleslist();
		request.setAttribute("list", list);

		RequestDispatcher rd= request.getRequestDispatcher("Dept_StockSalesList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
