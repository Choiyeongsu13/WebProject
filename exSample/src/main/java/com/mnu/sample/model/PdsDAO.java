package com.mnu.sample.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mnu.sample.util.DBManager;
public class PdsDAO {
	private PdsDAO() {}
	public static PdsDAO Pds = new PdsDAO();
	public static PdsDAO getInstance() {
		return Pds;
	}
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs= null;
	//전체 게시글 목록(list)
	public List<PdsDTO> PdsList(){
		List<PdsDTO> Blist = new ArrayList();
		String sql="select * from tbl_pds ORDER by regdate desc";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				PdsDTO Bdto = new PdsDTO();
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
	
	//총 게시글 수 카운트(검색기능  추가
	public int PdscountList(String search, String key){
		int count = 0;
		String sql="select count(*) from tbl_pds where " + search + " like ?";

//		if(search.equals("name")){
//			sql="select count(*) from tbl_Pds where name like ?";	
//		}else if(search.equals("subject")) {
//			sql="select count(*) from tbl_Pds where subjcet like ?";	
//		}else {
//			sql="select count(*) from tbl_Pds where contents like ?";	
//		}
//		

		
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+key+"%");
			
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
	
	//총 게시글 수 카운트
	public int PdscountList(){
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
	
	//전체 게시글 목록(list) 검색조건 추가
	public List<PdsDTO> PdsList(String search, String key){
		List<PdsDTO> Blist = new ArrayList();
		String sql="select * from tbl_pds where " + search + " like ? order by regdate desc";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+key+"%");
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				PdsDTO Bdto = new PdsDTO();
				Bdto.setIdx(rs.getInt("idx"));
				Bdto.setName(rs.getString("name"));
				Bdto.setRegdate(rs.getString("regdate"));
				Bdto.setFilename(rs.getString("filename"));
				
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
	
	public int Pdswrite(PdsDTO dto){
		int row=0;
		String sql = "insert into tbl_pds(idx,name,email,subject,contents,pass,filename)\r\n"
				+ "values((select nvl(max(idx),0)+1 from tbl_Pds),?,?,?,?,?,?)";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContents());
			pstmt.setString(5, dto.getPass());
			pstmt.setString(6, dto.getFilename());
			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	// 조회수 1 증가
	public void PdsCount(int idx){
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
	public int PdsModify(PdsDTO dto){
		int row = 0;
		String sql = "update tbl_pds set name=?, email=?, subject=?, contents=? ,Filename=?where idx=? and pass=?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContents());
			pstmt.setString(5, dto.getFilename());
			pstmt.setInt(6, dto.getIdx());
			pstmt.setString(7, dto.getPass());
			

			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;
	}

	
	// 글 1개 상세조회
	public PdsDTO PdsSearch(int idx){
		PdsDTO dto = new PdsDTO();
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
				dto.setFilename(rs.getString("filename"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return dto;
	}
	// 글 삭제
	
	public int PdsDelete(int idx , String pass) {
		int row=0;
		String sql="delete from tbl_pds where idx=? and pass=?";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
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