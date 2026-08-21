package com.mnu.sample.AdminNotice.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminNoticeDAO;
import com.mnu.sample.model.AdminNoticeDTO;
import com.mnu.sample.service.Action;

public class admin_notice_viewService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));

		AdminNoticeDAO Andao = AdminNoticeDAO.getInstance();
		
		//쿠키 존재 유무 검사
		boolean bool = false;
		Cookie info =null;
		Cookie[] cookies = request.getCookies(); //300개까지만
		//쿠키 존재 유무
		for(int i=0; i<cookies.length;i++){
			info = cookies[i];
			if(info.getName().equals("Notice_milk"+idx)) {
				bool = true;
				break;
			}
		}
		String newValue=""+System.currentTimeMillis();
		if(!bool) { //쿠키가 없으면 경우
			Andao.AdminNoticeCount(idx); //조회수 +1
			
			//쿠키 생성
			info = new Cookie("Notice_milk"+idx, newValue); //이름과 값
			//쿠키 유효기간(시간)
			info.setMaxAge(60*60); //(초단위지정)1시간
			response.addCookie(info);
		}
		
		
		AdminNoticeDTO Andto = Andao.AdminNoticeSearch(idx); 
		
		
		//\n -> <br> 변환
		Andto.setContents(Andto.getContents().replace("\n","<br>"));
		request.setAttribute("dto", Andto);
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_view.jsp");
		rd.forward(request, response);

	}

}
