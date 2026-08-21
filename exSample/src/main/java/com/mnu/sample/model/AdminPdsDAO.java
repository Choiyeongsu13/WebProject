package com.mnu.sample.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mnu.sample.util.DBManager;
public class AdminPdsDAO {
	private AdminPdsDAO() {}
	public static AdminPdsDAO Adminpds = new AdminPdsDAO();
	public static AdminPdsDAO getInstance() {
		return Adminpds;
	}
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs= null;
	//전체 자료 목록(list)
	public List<BoardDTO> AdminpdsList(){
		List<BoardDTO> Blist = new ArrayList();
		String sql="select * from tbl_pds ORDER by regdate desc";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO Bdto = new BoardDTO();
				Bdto.setIdx(rs.getInt("idx"));
				Bdto.setName(rs.getString("name"));
				Bdto.setRegdate(rs.getString("regdate"));
				Bdto.setSubject(rs.getString("subject"));
				Bdto.setReadcnt(rs.getInt("readcnt"));
				Blist.add(Bdto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		DBManager.close(conn	, pstmt, rs);
		}return Blist;
	}
	//총 자료 수 카운트
	public int AdminpdscountList(){
		int count = 0;
		String sql="select count(*) from tbl_pds";
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
	//tbl_pds.idx 는 시퀀스/트리거가 없어 MAX(idx)+1 로 직접 채번한다
	public int pdswrite(BoardDTO dto){
		int row=0;
		String sql = "insert into tbl_pds(idx,name,email,subject,contents,pass)\r\n"
				+ "values((select nvl(max(idx),0)+1 from tbl_pds),?,?,?,?,?)";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContents());
			pstmt.setString(5, dto.getPass());
			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	// 조회수 1 증가
	public void AdminpdsCount(int idx){
		String sql = "update tbl_pds set readcnt = readcnt + 1 where idx = ?";
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

	//수정 사항 (비밀번호가 일치할 때만 수정됨 - 일치하지 않으면 0행 반환)
	public int AdminpdsModify(BoardDTO dto){
		int row = 0;
		String sql = "update tbl_pds set name=?, email=?, subject=?, contents=? where idx=? and pass=?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContents());
			pstmt.setInt(5, dto.getIdx());
			pstmt.setString(6, dto.getPass());

			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}


	// 자료 1개 상세조회
	public BoardDTO AdminpdsSearch(int idx){
		BoardDTO dto = new BoardDTO();
		String sql = "select * from tbl_pds where idx = ?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setSubject(rs.getString("subject"));
				dto.setContents(rs.getString("contents"));
				dto.setPass(rs.getString("pass"));
				dto.setReadcnt(rs.getInt("readcnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return dto;
	}
	// 자료 삭제(관리자용, 비밀번호 확인 없이 삭제)
	public int AdminpdsDelete(int idx) {
		int row=0;
		String sql="delete from tbl_pds where idx=?";

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			row =pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}return row;

	}

	// 자료 삭제

	public int AdminpdsDelete(int idx , String pass) {
		int row=0;
		String sql="delete from tbl_pds where idx=? and pass=?";

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			row =pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}return row;

	}

}
