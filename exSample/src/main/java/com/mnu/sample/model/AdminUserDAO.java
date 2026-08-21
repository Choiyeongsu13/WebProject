package com.mnu.sample.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.sample.util.DBManager;

public class AdminUserDAO {
	private AdminUserDAO() {}
	public static AdminUserDAO user = new AdminUserDAO();
	public static AdminUserDAO getInstance() {
		return user;
	}
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs= null;

	//전체 회원 목록(list)
	public List<AdminUserDTO> AdminUserList(){
		List<AdminUserDTO> Ulist = new ArrayList();
		String sql="select * from tbl_user ORDER by first_time desc";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				AdminUserDTO Udto = new AdminUserDTO();
				Udto.setUserid(rs.getString("userid"));
				Udto.setName(rs.getString("name"));
				Udto.setTel(rs.getString("tel"));
				Udto.setEmail(rs.getString("email"));
				Udto.setFirstTime(rs.getString("first_time"));
				Ulist.add(Udto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		DBManager.close(conn	, pstmt, rs);
		}return Ulist;
	}

	//총 회원 수 카운트
	public int AdminUsercountList(){
		int count = 0;
		String sql="select count(*) from tbl_user";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		DBManager.close(conn	, pstmt, rs);
		}return count;
	}

	public int Userwrite(AdminUserDTO dto){
		int row=0;
		String sql = "insert into tbl_user(userid,name,passwd,tel,email)\r\n"
				+ "values(?,?,?,?,?)";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPasswd());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getEmail());
			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	//수정 사항
	public int AdminUserModify(AdminUserDTO dto){
		int row = 0;
		String sql = "update tbl_user set name=?, passwd=?, tel=?, email=? where userid=?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getUserid());

			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	// 회원 삭제
	public int AdminUserDelete(String userid){
		int row = 0;
		String sql = "delete from tbl_user where userid = ?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	// 회원 1명 상세조회
	public AdminUserDTO AdminUserSearch(String userid){
		AdminUserDTO dto = new AdminUserDTO();
		String sql = "select * from tbl_user where userid = ?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setUserid(rs.getString("userid"));
				dto.setName(rs.getString("name"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setFirstTime(rs.getString("first_time"));
				dto.setLastTime(rs.getString("last_time"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return dto;
	}

}
