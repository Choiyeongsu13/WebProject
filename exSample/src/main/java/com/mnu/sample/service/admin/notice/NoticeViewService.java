package com.mnu.sample.service.admin.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.NoticeDAO;
import com.mnu.sample.model.NoticeDTO;
import com.mnu.sample.service.Action;

public class NoticeViewService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO nDAO = NoticeDAO.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 쿠키 존재 유무 검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		//쿠키 존재 유무
		for(int i=0; i<cookies.length;i++) {
			info = cookies[i];
			if(info.getName().equals("Notice"+idx)) {
				bool = true;
				break;
			}
		}
		
		String newValue=""+System.currentTimeMillis();
		if(!bool) {//쿠키가 없으면
			//idx를 이용한 조회수 증가
			nDAO.noticeHits(idx);
			//쿠키생성
			info = new Cookie("Notice"+idx, newValue);
			//쿠키유효기간(시간)
			info.setMaxAge(60*60);//(초단위지정)1시간
			response.addCookie(info);
		}
		
		//idx를 이용한 검색
		NoticeDTO nDTO = nDAO.noticeSearch(idx);
		
		//\n -> <br> 변환
		nDTO.setContents(nDTO.getContents().replace("\n", "<br>"));
		request.setAttribute("nDTO", nDTO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_view.jsp");
		rd.forward(request, response);
	}

}
