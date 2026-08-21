package com.mnu.sample.AdminGallery.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminGalleryDAO;
import com.mnu.sample.model.AdminGalleryDTO;
import com.mnu.sample.service.Action;

public class admin_gallery_modifyproService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		AdminGalleryDAO Agdao = AdminGalleryDAO.getInstance();
		AdminGalleryDTO Agdto = new AdminGalleryDTO();

		int idx = Integer.parseInt(request.getParameter("idx"));

		Agdto.setIdx(idx);
		Agdto.setGubun(request.getParameter("gubun"));
		Agdto.setSubject(request.getParameter("subject"));
		Agdto.setContents(request.getParameter("contents"));

		Agdao.AdminGalleryModify(Agdto);

		response.sendRedirect("/Admin/Gallery?cmd=galleryView&idx=" + idx);

	}

}
