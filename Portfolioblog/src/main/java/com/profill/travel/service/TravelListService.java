package com.profill.travel.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.AlbumDTO;
import com.profill.model.PhotoDTO;
import com.profill.model.PostDTO;
import com.profill.model.ProfillDAO;
import com.profill.service.Action;

public class TravelListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProfillDAO dao = ProfillDAO.getInstance();

		List<AlbumDTO> albums = dao.albumList();

	
		Map<Integer, List<PhotoDTO>> photos = new LinkedHashMap<Integer, List<PhotoDTO>>();
		for (int i = 0; i < albums.size(); i++) {
			int albumId = albums.get(i).getAlbumid();
			photos.put(Integer.valueOf(albumId), dao.photoList(albumId));
		}

		request.setAttribute("albums", albums);
		request.setAttribute("photos", photos);

	
		List<PostDTO> travelPosts = dao.postList("TRAVEL");
		List<PostDTO> relatedPosts = new ArrayList<PostDTO>();
		for (int i = 0; i < travelPosts.size(); i++) {
			PostDTO p = travelPosts.get(i);
			boolean linked = false;
			for (int j = 0; j < albums.size(); j++) {
				if (albums.get(j).getPostid() == p.getPostid()) {
					linked = true;
					break;
				}
			}
			if (!linked) {
				relatedPosts.add(p);
			}
		}
		request.setAttribute("relatedPosts", relatedPosts);

		RequestDispatcher rd = request.getRequestDispatcher("/travel.jsp");
		rd.forward(request, response);
	}
}