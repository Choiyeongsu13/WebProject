package com.mnu.sample.service.Board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.BoardDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;

public class BoardListService implements Action {
//게시판 목록
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bdao = BoardDAO.getInstance();
		String search="", key="";
		int  totcount = 0;
		List<BoardDTO> bList = null;
		
		if(request.getParameter("key")!=null){
		 
	
			//검색이용시
			search=request.getParameter("search");
			key=request.getParameter("key");
			totcount=bdao.boardcountList(search,key);
			bList=bdao.boardList(search,key);
		}
		else {

			//검색없이 모두
			totcount = bdao.boardcountList(); // 총 게시글 수
			 bList = bdao.boardList(); //전체 글 목록
		}

		request.setAttribute("bList", bList);
		request.setAttribute("totcount", totcount);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Board/board_list.jsp");
		rd.forward(request, response);

	}

}