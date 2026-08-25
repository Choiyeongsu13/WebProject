package com.profill.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.profill.util.DBManager;

public class ProfillDAO {
	private ProfillDAO() {}
	public static ProfillDAO profill = new ProfillDAO();
	public static ProfillDAO getInstance() {
		return profill;
	}
	
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//home 페이지 대표 프로젝트메소드
	public List<ProjectDTO> projectFeatured(int limit) {

		List<ProjectDTO> list = new ArrayList<ProjectDTO>();

		String sql = "SELECT * FROM ( "
		           + "  SELECT project_id, title, subtitle, description, category_code, thumbnail, github_url, demo_url, team_size, my_role, "
		           + " is_featured, sort_order,TO_CHAR(started_on,'YYYY.MM') AS started_on,TO_CHAR(ended_on,'YYYY.MM') AS ended_on FROM project WHERE is_featured = 'Y' "
		           + " ORDER BY sort_order, project_id "
		           + ") WHERE ROWNUM <= ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, limit);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProjectDTO dto = new ProjectDTO();

				dto.setProject_id(rs.getInt("project_id"));
				dto.setTitle(rs.getString("title"));
				dto.setSubtitle(rs.getString("subtitle"));
				dto.setDescription(rs.getString("description"));
				dto.setCategory_code(rs.getString("category_code"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setGithub_url(rs.getString("github_url"));
				dto.setDemo_url(rs.getString("demo_url"));
				dto.setTeam_size(rs.getInt("team_size"));
				dto.setMy_role(rs.getString("my_role"));
				dto.setSort_order(rs.getInt("sort_order"));
				dto.setStarted_on(rs.getString("started_on"));
				dto.setEnded_on(rs.getString("ended_on"));

				dto.setFeatured("Y".equals(rs.getString("is_featured")));

				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//work 페이지 입력 메소드
	public int workwrite() {
		
	}
	
	//work 페이지 리스트 메소드
	
	
	
	
	//

}
