package com.mnu.exGas.Servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mnu.exGas.model.GasDAO;
import com.mnu.exGas.model.OilInfoDTO;
import com.mnu.exGas.model.SaleInfoDTO;
/**
 * Servlet implementation class GasWriteServlet
 */
@WebServlet("/GasSale")
public class GasSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GasSaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GasDAO dao = GasDAO.getInstancec();

		List<OilInfoDTO> list = dao.getOilList();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("GasSale.jsp");
		rd.forward(request, response);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		GasDAO dao = GasDAO.getInstancec();
		SaleInfoDTO dto = new SaleInfoDTO();

		String saleno = request.getParameter("saleno");
		String oildate = request.getParameter("oildate");
		String oiltype = request.getParameter("oiltype");
		String amount = request.getParameter("amount");
		String paytype = request.getParameter("paytype");
		String custno = request.getParameter("custno");
		String creditcart = request.getParameter("creditcart");
		String oilcost = request.getParameter("oilcost");



		dto.setSaleno(saleno);
		dto.setOildate(oildate);
		dto.setOiltype(oiltype);
		dto.setAmount(Integer.parseInt(amount));
		dto.setPaytype(paytype);
		dto.setCustno(custno);
		dto.setCreditcart(creditcart);
		dto.setOilcost(Integer.parseInt(oilcost));
		 
		request.setAttribute("dto", dto);

		List<OilInfoDTO> list = dao.getOilList();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("GasSale.jsp");
		rd.forward(request, response);
	}
}