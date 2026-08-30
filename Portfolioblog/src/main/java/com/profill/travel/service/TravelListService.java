package com.profill.travel.service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.AlbumDTO;
import com.profill.model.PhotoDTO;
import com.profill.model.ProfillDAO;
import com.profill.service.Action;

public class TravelListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProfillDAO dao = ProfillDAO.getInstance();

		List<AlbumDTO> albums = dao.albumList();

		// 앨범마다 사진을 따로 담는다. album_id -> 사진 목록
		Map<Integer, List<PhotoDTO>> photos = new LinkedHashMap<Integer, List<PhotoDTO>>();
		for (int i = 0; i < albums.size(); i++) {
			int albumId = albums.get(i).getAlbumid();
			photos.put(Integer.valueOf(albumId), dao.photoList(albumId));
		}

		request.setAttribute("albums", albums);
		request.setAttribute("photos", photos);

		// 여행(TRAVEL) 태그로 쓴 글도 같이 보여준다
		request.setAttribute("relatedPosts", dao.postList("TRAVEL"));

		RequestDispatcher rd = request.getRequestDispatcher("/travel.jsp");
		rd.forward(request, response);
	}
}
