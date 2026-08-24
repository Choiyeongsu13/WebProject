package com.mnu.sample.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mnu.sample.util.DBManager;
public class UserDAO {
	private UserDAO() {}
	public static UserDAO board = new UserDAO();
	public static UserDAO getInstance() {
		return board;
	}
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs= null;

	
	//id 중복검사 
	public int userIdCheck(String userid){
		int count = 0;
		String sql="select count(*) from tbl_user where userid=?";
		
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
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

	//회원등록 메소드
	public int userWrite(AdminUserDTO udto){
		int row = 0;
		String sql="insert into tbl_user (userid,name,passwd,tel) values(?,?,?,?)";
		
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, udto.getUserid());
			pstmt.setString(2, udto.getName());
			pstmt.setString(3, udto.getPasswd());
			pstmt.setString(4, udto.getTel());
			
			row=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		DBManager.close(conn	, pstmt, rs);
		}return row;
	}
	//로그인 메소드(로그인 성공시 dto , 실패시  null 반환)
	public AdminUserDTO userLogin(AdminUserDTO dto) {
		AdminUserDTO uDTO = null;
		String sql="select userid, name, passwd, tel from tbl_user where userid = ? and passwd = ?";

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPasswd());
			rs=pstmt.executeQuery();

			if(rs.next()) {
				uDTO = new AdminUserDTO();
				uDTO.setUserid(rs.getString("userid"));
				uDTO.setName(rs.getString("name"));
				uDTO.setPasswd(rs.getString("passwd"));
				uDTO.setTel(rs.getString("tel"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		DBManager.close(conn	, pstmt, rs);
		}return uDTO;
	}
	
	//회원 정보 조회(수정폼 채우기용)
	public AdminUserDTO userSelectOne(String userid) {
		AdminUserDTO dto = null;
		String sql="select userid, name, passwd, tel, email from tbl_user where userid = ?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				dto = new AdminUserDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setName(rs.getString("name"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return dto;
	}

	//회원 수정
	public int userModify(AdminUserDTO dto) {
		int row=0;
		String sql="update tbl_user set name =? ,tel=?, email=? where userid=?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getUserid()); 

			row=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	
	
	}

}
	
	


