package com.mnu.Stock.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.Stock.model.StockDAO;
import com.mnu.Stock.model.TBL_DEPT_DTO;
import com.mnu.Stock.model.TBL_STOCK_ITEM_DTO;
import com.mnu.Stock.model.uploadDTO;

/**
 * Servlet implementation class StockUproadServlet
 */
@WebServlet("/StockUpload")
public class StockUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StockDAO dao = StockDAO.getInstance();
		List<TBL_STOCK_ITEM_DTO> sList= dao.stockitemlist();
		List<TBL_DEPT_DTO> dList= dao.deptlist();

		request.setAttribute("slist", sList);
		request.setAttribute("dlist", dList);
		
		RequestDispatcher rd = request.getRequestDispatcher("StockUpload.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		uploadDTO dto = new uploadDTO();
		dto.setBuy_date(request.getParameter("BUY_DATE"));
		dto.setStock_item_code(request.getParameter("STOCK_ITEM_CODE"));
		dto.setBuy_number(Integer.parseInt(request.getParameter("BUY_NUMBER")));
		dto.setBuy_price(Integer.parseInt(request.getParameter("BUY_PRICE")));
		dto.setDept_code(request.getParameter("DEPT_CODE"));

		StockDAO dao = StockDAO.getInstance();
		dao.StockUpload(dto);

		response.sendRedirect(request.getContextPath() + "/StockUpload");
	}

}
