package com.profill.post.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.PostcommentDTO;
import com.profill.model.ProfillDAO;
import com.profill.service.Action;


public class CommentWriteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int postId = toInt(request.getParameter("postId"));
		if (postId <= 0) {
			response.sendRedirect(request.getContextPath() + "/Post?cmd=post_list");
			return;
		}

		PostcommentDTO dto = new PostcommentDTO();
		dto.setPostid(postId);
		dto.setNickname(request.getParameter("nickname"));
		dto.setPassword(request.getParameter("password"));   
		dto.setContent(request.getParameter("content"));
		dto.setSecret("on".equals(request.getParameter("secret")));

		
		dto.setParentid(toInt(request.getParameter("parentId")));

		ProfillDAO dao = ProfillDAO.getInstance();
		int result = dao.commentInsert(dto);

		if (result == 0) {
			
			request.getSession().setAttribute("commentError", "댓글을 저장하지 못했습니다.");
		}


		response.sendRedirect(request.getContextPath()
				+ "/Post?cmd=post_view&id=" + postId + "#comments");
	}

	private int toInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception e) {
			return 0;
		}
	}
}
