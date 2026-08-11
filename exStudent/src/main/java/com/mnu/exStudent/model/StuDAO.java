package com.mnu.exStudent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.exStudent.util.DBManager;

public class StuDAO {
	private StuDAO() {}
	public static StuDAO instance = new StuDAO();
	public static StuDAO getInstance() {
		return instance;
	}
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int insertStudent(StuWriteDTO dto) {
		
		String sql = "INSERT INTO tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3)" 
				+ "VALUES(?,?,?,?,?,?,?,?,?)" ;
		int row = 0;
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
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
}
	
