package com.mnu.sample.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.sample.util.DBManager;

public class AdminNoticeDAO {
	private AdminNoticeDAO() {}
	public static AdminNoticeDAO notice = new AdminNoticeDAO();
	public static AdminNoticeDAO getInstance() {
		return notice;
	}
	
	//관리자 전용 공지 글 목록
	public List<AdminNoticeDTO> AdminNoticeList(){
		List<AdminNoticeDTO> ANlist = new ArrayList<AdminNoticeDTO>();
		String sql="select idx, adid, subject, contents, regdate, readcnt from tbl_notice order by regdate desc";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	try {
		conn=DBManager.getConnection();
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();

		while(rs.next()) {
			AdminNoticeDTO Andto = new AdminNoticeDTO();
			Andto.setIdx(rs.getInt("idx"));
			Andto.setAdid(rs.getString("adid"));
			Andto.setSubject(rs.getString("subject"));
			Andto.setContents(rs.getString("contents"));
			Andto.setRegdate(rs.getString("regdate"));
			Andto.setReadcnt(rs.getString("readcnt"));
			ANlist.add(Andto);
		}
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBManager.close(conn, pstmt, rs);
	}return ANlist;
	}
	
	//총 게시글 수 카운트
	
	public int AdminNoticecountList() {
		int count=0;
		String sql="select count(*) from tbl_notice";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count =rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return count;
	}
	public void AdminNoticeCount(int idx){
		String sql = "update tbl_notice set readcnt = readcnt + 1 where idx = ?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//tbl_notice.idx 는 시퀀스/트리거가 없어 MAX(idx)+1 로 직접 채번한다
	public int AdminNoticeWrite(AdminNoticeDTO dto) {
		int row=0;
		String sql= "insert into tbl_notice(idx, subject, contents) "
				+ "values((select nvl(max(idx),0)+1 from tbl_notice), ?, ?)";
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContents());

			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	//글 수정
	public int AdminNoticeModify(AdminNoticeDTO dto) {
		int row=0;
		String sql= "update tbl_notice set subject=?, contents=? where idx=?";
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContents());
			pstmt.setInt(3, dto.getIdx());

			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	//글 삭제
	public int AdminNoticeDelete(int idx) {
		int row=0;
		String sql="delete from tbl_notice where idx=?";
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	//글 1개 상세조회
	public AdminNoticeDTO AdminNoticeSearch(int idx) {
		AdminNoticeDTO Andto = new AdminNoticeDTO();
		String sql="select idx, adid, subject, contents, regdate, readcnt from tbl_notice where idx = ?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				Andto.setIdx(rs.getInt("idx"));
				Andto.setAdid(rs.getString("adid"));
				Andto.setSubject(rs.getString("subject"));
				Andto.setContents(rs.getString("contents"));
				Andto.setRegdate(rs.getString("regdate"));
				Andto.setReadcnt(rs.getString("readcnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return Andto;
	}

}
