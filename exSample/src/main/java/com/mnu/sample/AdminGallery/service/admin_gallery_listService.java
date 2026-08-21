package com.mnu.sample.AdminGallery.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminGalleryDAO;
import com.mnu.sample.model.AdminGalleryDTO;
import com.mnu.sample.service.Action;

public class admin_gallery_listService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminGalleryDAO Agdao = AdminGalleryDAO.getInstance();

		int totcount = Agdao.AdminGallerycountList(); //총 게시글수
		List<AdminGalleryDTO> AnList = Agdao.AdminGalleryList(); //전체 글 목록

		request.setAttribute("AnList", AnList);
		request.setAttribute("totcount", totcount);

		RequestDispatcher rd = request.getRequestDispatcher("/Admin/gallery_list.jsp");
		rd.forward(request, response);
	}

}
