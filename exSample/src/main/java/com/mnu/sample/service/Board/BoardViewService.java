package com.mnu.sample.service.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.BoardDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

public class BoardViewService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = dao.boardSearch(idx); // 상세 내용 조회
		
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		
		for(int i =0; i<cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("Board_milk" + idx)) {
				bool = true;
				break;
			}
		}
		String newValue = ""+ System.currentTimeMillis();
		if(!bool) {
			dao.boardCount(idx);
			
			//쿠키 생성
			info = new Cookie("Board_milk" +idx, newValue);
			
			info.setMaxAge(60*60);
			response.addCookie(info);
		}
		
		dao.boardCount(idx);            // 조회수 +1
		dto.setContents(dto.getContents().replace("\n", "<br>"));
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_view.jsp");
		rd.forward(request, response);
	}

}