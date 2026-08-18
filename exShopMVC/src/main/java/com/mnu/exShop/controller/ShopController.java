package com.mnu.exShop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exShop.service.Action;
import com.mnu.exShop.service.ShopListService;
import com.mnu.exShop.service.ShopSaleService;
import com.mnu.exShop.service.ShopWriteProService;
import com.mnu.exShop.service.ShopWriteService;
import com.mnu.exShop.service.ShopsearchService;

/**
 * Servlet implementation class shopController
 */
@WebServlet("/Shop")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");

		System.out.println("사용자의 요청: " + cmd);
		Action action = null;

	

		if(cmd.equals("ShopWrite")) {
			action= new ShopWriteService();
			
		}else if(cmd.equals("ShopList")) {
			action= new ShopListService();
		}else if(cmd.equals("ShopSearch")) {
			action= new ShopsearchService();
		}
		else if(cmd.equals("ShopSaleList")) {
			action= new ShopSaleService();
		}
		else if(cmd.equals("ShopWritePro")) {
		    action = new ShopWriteProService();
		}



		action.process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
