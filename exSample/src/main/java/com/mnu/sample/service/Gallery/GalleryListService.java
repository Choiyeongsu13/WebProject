package com.mnu.sample.service.Gallery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;
//갤러리 목록
public class GalleryListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Gallery/gallery_list.jsp");
		rd.forward(request, response);

	}

}
