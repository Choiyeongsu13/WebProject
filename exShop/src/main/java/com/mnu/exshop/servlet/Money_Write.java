package com.mnu.exshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exshop.model.MoneyDTO;
import com.mnu.exshop.model.ShopDAO;

/**
 * Servlet implementation class Money_Write
 */
@WebServlet("/money_write")
public class Money_Write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Money_Write() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopDAO dao = ShopDAO.getInstance();
		int saleno = dao.saleMAX();

		request.setAttribute("saleno", saleno);

		RequestDispatcher rd = request.getRequestDispatcher("/money_write.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ShopDAO dao = ShopDAO.getInstance();
		MoneyDTO dto = new MoneyDTO();
		dto.setSaleno(Integer.parseInt(request.getParameter("saleno")));
		dto.setCustno(Integer.parseInt(request.getParameter("custno")));
		dto.setPcode(request.getParameter("pcode"));
		dto.setAmount(Integer.parseInt(request.getParameter("amount")));
		dto.setSdate(request.getParameter("sdate"));

		
		int row = dao.moneyWrite(dto);

		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("/index_pro.jsp");
		rd.forward(request, response);
	}
}