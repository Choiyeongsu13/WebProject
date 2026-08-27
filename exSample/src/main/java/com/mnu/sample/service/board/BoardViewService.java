package com.mnu.sample.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.BoardDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

//게시글 등록 폼
public class BoardViewService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDAO bDAO = BoardDAO.getInstance();
		// 쿠키 존재 유무 검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		//쿠키 존재 유무
		for(int i=0; i<cookies.length;i++) {
			info = cookies[i];
			if(info.getName().equals("Board"+idx)) {
				bool = true;
				break;
			}
		}
		
		String newValue=""+System.currentTimeMillis();
		if(!bool) {//쿠키가 없으면
			//idx를 이용한 조회수 증가
			bDAO.boardHits(idx);
			//쿠키생성
			info = new Cookie("Board"+idx, newValue);
			//쿠키유효기간(시간)
			info.setMaxAge(60*60);//(초단위지정)1시간
			response.addCookie(info);
		}
		
		//idx에 해당하는 글 검색
		BoardDTO bDTO = bDAO.boardSearch(idx);
		bDTO.setContents(bDTO.getContents().replace("\n", "<br>"));
		
		request.setAttribute("bDTO", bDTO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Board/board_view.jsp");
		rd.forward(request, response);

	}

}
