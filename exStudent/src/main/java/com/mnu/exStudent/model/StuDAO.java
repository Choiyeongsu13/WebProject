package com.mnu.exStudent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.exStudent.util.DBManager;

public class StuDAO {
	private StuDAO() {}
	private static final StuDAO instance = new StuDAO();
	public static StuDAO getInstance() {
		return instance;
	}

	public int insertStudent(tbl_sutdentDTO dto) {

		String sql = "INSERT INTO tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)" ;
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getSyear());
			pstmt.setString(2, dto.getSclass());
			pstmt.setString(3, dto.getSno());
			pstmt.setString(4, dto.getSname());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getTel1());
			pstmt.setString(8, dto.getTel2());
			pstmt.setString(9, dto.getTel3());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, null);
		}
		return row;
	}

	public int insertScore(tbl_scoreDTO dto) {
		String sql = "INSERT INTO tbl_score_201905 (syear, sclass, sno, kor, eng, mat) VALUES (?,?,?,?,?,?)";
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getSyear());
			pstmt.setString(2, dto.getSclass());
			pstmt.setString(3, dto.getSno());
			pstmt.setInt(4, dto.getKor());
			pstmt.setInt(5, dto.getEng());
			pstmt.setInt(6, dto.getMat());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, null);
		}
		return row;
	}

	public List<studentscoreDTO> scoreList() {
		List<studentscoreDTO> list = new ArrayList();
		String sql="select t1.syear,t1.sclass,t1.sno,sname,gender,kor,eng,mat \r\n"
				+ "        from tbl_student_201905 t1 join tbl_score_201905 t2\r\n"
				+ "                on t1.syear=t2.syear and t1.sclass=t2.sclass and t1.sno=t2.sno";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				studentscoreDTO dto = new studentscoreDTO();
				dto.setSyear(rs.getString("syear"));
				dto.setSclass(rs.getString("sclass"));
				dto.setSno(rs.getString("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setGender(rs.getString("gender"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));

				list.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);//select
		}
		return list;
	}
}

