package com.mnu.sample.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.BoardDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

//게시글 등록 폼
public class BoardModifyProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDAO = BoardDAO.getInstance();
		BoardDTO bDTO = new BoardDTO();
		
		bDTO.setIdx(Integer.parseInt(request.getParameter("idx")));
		bDTO.setEmail(request.getParameter("email"));
		bDTO.setSubject(request.getParameter("subject"));
		bDTO.setContents(request.getParameter("contents"));
		bDTO.setPass(request.getParameter("pass"));
		
		//수정 메소드 호출
		int row = bDAO.boardModify(bDTO);
		
		request.setAttribute("row", row);
		//수정완료 메시지 출력
		System.out.println("수정 완료 : " + row);
		//RequestDispatcher rd = request.getRequestDispatcher("/Board/board_modify_pro.jsp");
		//rd.forward(request, response);
	}

}
