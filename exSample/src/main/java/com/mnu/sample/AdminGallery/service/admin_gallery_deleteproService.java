package com.mnu.sample.AdminGallery.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.AdminGalleryDAO;
import com.mnu.sample.service.Action;

public class admin_gallery_deleteproService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));

		AdminGalleryDAO Agdao = AdminGalleryDAO.getInstance();
		Agdao.AdminGalleryDelete(idx);

		response.sendRedirect("/Admin/Gallery?cmd=galleryList");
	}

}
