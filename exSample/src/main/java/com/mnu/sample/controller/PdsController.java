package com.mnu.sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
import com.mnu.sample.service.Pds.PdsDeleteProService;
import com.mnu.sample.service.Pds.PdsDeleteService;
import com.mnu.sample.service.Pds.PdsDownService;
import com.mnu.sample.service.Pds.PdsListService;
import com.mnu.sample.service.Pds.PdsModifyProService;
import com.mnu.sample.service.Pds.PdsModifyService;
import com.mnu.sample.service.Pds.PdsViewService;
import com.mnu.sample.service.Pds.PdsWriteProService;
import com.mnu.sample.service.Pds.PdsWriteService;

/**
 * Servlet implementation class PdsController
 */
@WebServlet("/Pds")
public class PdsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		System.out.println("자료실 요청" +  cmd);
		Action action = null;
		
		if(cmd.equals("pds_list")) {
			action =new PdsListService();
		}else if(cmd.equals("pds_Wrtie")) { //등록
			action = new PdsWriteService();
		}else if(cmd.equals("pds_WrtiePro")) { // 등록처리
			action = new PdsWriteProService();
			
		}else if(cmd.equals("pds_View")) { //상세정보
			action = new PdsViewService();
		}else if(cmd.equals("pds_Modify")) { //수정
			action = new PdsModifyService(); 
			
		}else if(cmd.equals("pds_ModfyPro")) { //수정처리
			action = new PdsModifyProService();
		}else if(cmd.equals("pds_Delete")) { //삭제
			action = new PdsDeleteService();
		}else if(cmd.equals("pds_DeletePro")){ //삭제처리
			action = new PdsDeleteProService();
		}else if(cmd.equals("pds_Down")) { //파일다운처리
			action = new PdsDownService();
		}				
		action.process(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
