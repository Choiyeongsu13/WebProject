package com.mnu.ElectionMVC.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.ElectionMVC.util.DBManager;


public class EltDAO {
	private EltDAO() {}
	public static EltDAO instance = new EltDAO();
	public static EltDAO getInstance() {
		return instance;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;


	public List<searchDTO> searchList() {
		List<searchDTO> list = new ArrayList<searchDTO>();
		String sql = "SELECT m.m_no, m.m_name, p.p_name, "
				+ "       DECODE(m.p_school,'1','고졸','2','학사','3','석사','4','박사') p_school, "
				+ "       SUBSTR(m.m_jumin,1,6)||'-'||SUBSTR(m.m_jumin,7,7) m_jumin, "
				+ "       m.m_city, p.p_tel1, p.p_tel2, p.p_tel3 "
				+ "FROM TBL_MEMBER_202005 m, TBL_PARTY_202005 p "
				+ "WHERE m.p_code = p.p_code "
				+ "ORDER BY m.m_no";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				searchDTO dto = new searchDTO();
				dto.setM_no(rs.getString("m_no"));
				dto.setM_name(rs.getString("m_name"));
				dto.setP_name(rs.getString("p_name"));
				dto.setP_school(rs.getString("p_school"));
				dto.setM_jumin(rs.getString("m_jumin"));
				dto.setM_city(rs.getString("m_city"));
				dto.setP_tel1(rs.getString("p_tel1"));
				dto.setP_tel2(rs.getString("p_tel2"));
				dto.setP_tel3(rs.getString("p_tel3"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}


	public List<tbl_memberDTO> memberList() {
		List<tbl_memberDTO> list = new ArrayList<tbl_memberDTO>();
		String sql = "SELECT m_no, m_name FROM TBL_MEMBER_202005 ORDER BY m_no";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tbl_memberDTO dto = new tbl_memberDTO();
				dto.setM_no(rs.getString("m_no"));
				dto.setM_name(rs.getString("m_name"));

				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}


	public int voteWrite(tbl_voteDTO dto) {
		
		int row = 0;
		String sql = "INSERT INTO TBL_VOTE_202005 (v_jumin, v_name, m_no, v_time, v_area, v_confirm) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getV_jumin());
			pstmt.setString(2, dto.getV_name());
			pstmt.setString(3, dto.getM_no());
			pstmt.setString(4, dto.getV_time());
			pstmt.setString(5, dto.getV_area());
			pstmt.setString(6, dto.getV_confirm());

			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}


	public List<voteListDTO> voteCheckList() {
		List<voteListDTO> list = new ArrayList<voteListDTO>();
		String sql = "SELECT v.v_name, "
				+ "'19'||SUBSTR(v.v_jumin,1,2)||'년'||SUBSTR(v.v_jumin,3,2)||'월'||SUBSTR(v.v_jumin,5,2)||'일생' v_birth, "
				+ "'만'||(2020-TO_NUMBER('19'||SUBSTR(v.v_jumin,1,2)))||'세' v_age, "
				+ "DECODE(SUBSTR(v.v_jumin,7,1),'1','남','2','여') v_gender, "
				+ "v.m_no, "
				+ "SUBSTR(v.v_time,1,2)||':'||SUBSTR(v.v_time,3,2) v_time, "
				+ "DECODE(v.v_confirm,'Y','확인','N','미확인') v_confirm "
				+ "FROM TBL_VOTE_202005 v "
				+ "WHERE v.v_area = '제1투표장' "
				+ "ORDER BY v.v_time, v.v_jumin";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				voteListDTO dto = new voteListDTO();
				dto.setV_name(rs.getString("v_name"));
				dto.setV_birth(rs.getString("v_birth"));
				dto.setV_age(rs.getString("v_age"));
				dto.setV_gender(rs.getString("v_gender"));
				dto.setM_no(rs.getString("m_no"));
				dto.setV_time(rs.getString("v_time"));
				dto.setV_confirm(rs.getString("v_confirm"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<scoreDTO> scoreList() {
		List<scoreDTO> list = new ArrayList<scoreDTO>();
		String sql = "SELECT m.m_no, m.m_name, COUNT(v.v_jumin) cnt "
				+ "FROM TBL_MEMBER_202005 m, TBL_VOTE_202005 v "
				+ "WHERE m.m_no = v.m_no AND v.v_confirm = 'Y' "
				+ "GROUP BY m.m_no, m.m_name "
				+ "ORDER BY COUNT(v.v_jumin) DESC";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				scoreDTO dto = new scoreDTO();
				dto.setM_no(rs.getString("m_no"));
				dto.setM_name(rs.getString("m_name"));
				dto.setCnt(rs.getInt("cnt"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
			