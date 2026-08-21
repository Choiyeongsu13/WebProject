package com.mnu.sample.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.sample.util.DBManager;

public class AdminGalleryDAO {
	private AdminGalleryDAO() {}
	public static AdminGalleryDAO gallery = new AdminGalleryDAO();
	public static AdminGalleryDAO getInstance() {
		return gallery;
	}

	//관리자 전용 갤러리 글 목록
	public List<AdminGalleryDTO> AdminGalleryList(){
		List<AdminGalleryDTO> AGlist = new ArrayList<AdminGalleryDTO>();
		String sql="select idx, gubun, subject, contents, regdate, readcnt from tbl_gallery order by regdate desc";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				AdminGalleryDTO Agdto = new AdminGalleryDTO();
				Agdto.setIdx(rs.getInt("idx"));
				Agdto.setGubun(rs.getString("gubun"));
				Agdto.setSubject(rs.getString("subject"));
				Agdto.setContents(rs.getString("contents"));
				Agdto.setRegdate(rs.getString("regdate"));
				Agdto.setReadcnt(rs.getString("readcnt"));
				AGlist.add(Agdto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return AGlist;
	}

	//총 게시글 수 카운트
	public int AdminGallerycountList() {
		int count=0;
		String sql="select count(*) from tbl_gallery";
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

	// 조회수 1 증가
	public void AdminGalleryCount(int idx){
		String sql = "update tbl_gallery set readcnt = readcnt + 1 where idx = ?";
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

	//tbl_gallery.idx 는 시퀀스/트리거가 없어 MAX(idx)+1 로 직접 채번한다
	public int AdminGalleryWrite(AdminGalleryDTO dto) {
		int row=0;
		String sql= "insert into tbl_gallery(idx, gubun, subject, contents) "
				+ "values((select nvl(max(idx),0)+1 from tbl_gallery), ?, ?, ?)";
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getGubun());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContents());

			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	//글 수정
	public int AdminGalleryModify(AdminGalleryDTO dto) {
		int row=0;
		String sql = "update tbl_gallery set gubun=?, subject=?, contents=? where idx=?";
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getGubun());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContents());
			pstmt.setInt(4, dto.getIdx());

			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	//글 삭제
	public int AdminGalleryDelete(int idx) {
		int row=0;
		String sql="delete from tbl_gallery where idx=?";
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
	public AdminGalleryDTO AdminGallerySearch(int idx) {
		AdminGalleryDTO Agdto = new AdminGalleryDTO();
		String sql="select idx, gubun, subject, contents, regdate, readcnt from tbl_gallery where idx = ?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				Agdto.setIdx(rs.getInt("idx"));
				Agdto.setGubun(rs.getString("gubun"));
				Agdto.setSubject(rs.getString("subject"));
				Agdto.setContents(rs.getString("contents"));
				Agdto.setRegdate(rs.getString("regdate"));
				Agdto.setReadcnt(rs.getString("readcnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return Agdto;
	}

}
