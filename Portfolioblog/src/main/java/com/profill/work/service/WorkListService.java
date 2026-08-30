package com.profill.work.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profill.model.ProfillDAO;
import com.profill.service.Action;

public class WorkListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProfillDAO dao = ProfillDAO.getInstance();

		Map<Integer, String> langs = dao.projectTagMap();

		request.setAttribute("projects", dao.projectList());
		request.setAttribute("langs", langs);
		request.setAttribute("filterLangs", filterLangs(langs));

		// 기술(TECH) 태그로 쓴 글도 같이 보여준다
		request.setAttribute("relatedPosts", dao.postList("TECH"));

		RequestDispatcher rd = request.getRequestDispatcher("/projects.jsp");
		rd.forward(request, response);
	}

	// 작업물에 실제로 붙어 있는 태그 이름만 모아서 필터 버튼을 만든다
	private List<String> filterLangs(Map<Integer, String> langs) {
		List<String> list = new ArrayList<String>();

		Iterator<String> it = langs.values().iterator();
		while (it.hasNext()) {
			String line = it.next();
			if (line == null) {
				continue;
			}
			String[] names = line.split(" ");
			for (int i = 0; i < names.length; i++) {
				String name = names[i].trim();
				if (name.length() > 0 && !list.contains(name)) {
					list.add(name);
				}
			}
		}

		Collections.sort(list);
		return list;
	}
}
