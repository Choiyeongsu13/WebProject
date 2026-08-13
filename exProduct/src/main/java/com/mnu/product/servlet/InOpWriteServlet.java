package com.mnu.product.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.product.model.ProductDAO;
import com.mnu.product.model.wrapperDTO;


/**
 * Servlet implementation class InOpWriteServlet
 */
@WebServlet("/InOpWrite")
public class InOpWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InOpWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼 최초 진입: 다음 입출고번호를 조회해서 자동으로 채워준다
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		ProductDAO dao = ProductDAO.getInstance();
		wrapperDTO dto = new wrapperDTO();

		dto.getTbl_inout().setT_no(dao.getNextInOpNo());
		request.setAttribute("dto", dto);

		RequestDispatcher rd = request.getRequestDispatcher("InOpWrite.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼 제출: 입력된 값을 저장한다
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		ProductDAO dao = ProductDAO.getInstance();
		wrapperDTO dto = new wrapperDTO();

		String t_no = request.getParameter("t_no");
		String p_code = request.getParameter("p_code");
		String t_type = request.getParameter("t_type");
		String t_cnt = request.getParameter("t_cnt");
		String t_date = request.getParameter("t_date");
		String c_code = request.getParameter("c_code");

		dto.getTbl_inout().setT_no(t_no);
		dto.getTbl_inout().setP_code(p_code);
		dto.getTbl_inout().setT_type(t_type);
		dto.getTbl_inout().setT_cnt(Integer.parseInt(t_cnt));
		dto.getTbl_inout().setT_date(t_date);
		dto.getTbl_inout().setC_code(c_code);

		int row = dao.insertProduct(dto);
		request.setAttribute("row", row);

		dto.getTbl_inout().setT_no(dao.getNextInOpNo());
		request.setAttribute("dto", dto);

		RequestDispatcher rd = request.getRequestDispatcher("InOpWrite.jsp");
		rd.forward(request, response);
	}

}
