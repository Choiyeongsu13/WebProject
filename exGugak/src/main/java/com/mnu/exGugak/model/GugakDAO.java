package com.mnu.exGugak.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.exGugak.util.DBManager;

public class GugakDAO {
	private GugakDAO() {}
	public static GugakDAO instance = new GugakDAO();
	public static GugakDAO getInstance() {
		return instance;
	}
	
	public int getscorewrite(tbl_recordDTO dto) {
	
		String sql=" insert into tbl_record_202106 values(?,?,?,?,?,?)";
	
	int row=0;
	Connection conn= null;
	PreparedStatement pstmt=null;
	
	try {
		conn=DBManager.getConnection();
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getEntry_no());
		pstmt.setInt(2, dto.getScore1());
		pstmt.setInt(3, dto.getScore2());
		pstmt.setInt(4, dto.getScore3());
		pstmt.setInt(5, dto.getScore4());
		pstmt.setInt(6, dto.getScore5());
		
		row=pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBManager.close(conn, pstmt);
	}return row;


	}

	public int getscorewriteArray(tbl_recordDTO dto) {

		String sql=" insert into tbl_record_202106 values(?,?,?,?,?,?)";

		int row=0;
		Connection conn= null;
		PreparedStatement pstmt=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getEntry_no());

			int[] scores = dto.getScore();
			for (int i = 0; i < scores.length; i++) {
				pstmt.setInt(i + 2, scores[i]);
			}

			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;

	}

	public List<wrapperDTO> getTotalScoreList(){
		List<wrapperDTO> list= new ArrayList();
		String sql="select e.entry_no, entry_name, entry_jumin, entry_type, entry_area,s_tot,s_ave \r\n"
				+ "from tbl_entry_202106 e\r\n"
				+ "join tbl_record_202106  r on e.entry_no = r.entry_no\r\n"
				+ "order by s_ave desc";
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		try {
			conn= DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				wrapperDTO dto = new wrapperDTO();
				dto.getTbl_entryDTO().setEntry_no(rs.getString("entry_no"));
				dto.getTbl_entryDTO().setEntry_name(rs.getString("entry_name"));
				dto.getTbl_entryDTO().setEntry_jumin(rs.getString("entry_jumin"));
				dto.getTbl_entryDTO().setEntry_type(rs.getString("entry_type"));
				dto.getTbl_entryDTO().setEntry_area(rs.getString("entry_area"));			
				
				dto.getTbl_recordDTO().setS_tot(rs.getInt("s_tot"));
				dto.getTbl_recordDTO().setS_ave(rs.getDouble("s_ave"));
				list.add(dto);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
		
	}
	
	public wrapperDTO getResult(String entry_no) {
		wrapperDTO dto = null;
		String sql = "select e.entry_no, e.entry_name, e.entry_jumin, e.entry_type, e.entry_area,\r\n"
				+ "r.score1, r.score2, r.score3, r.score4, r.score5, r.s_max, r.s_min, r.s_tot, r.s_ave\r\n"
				+ "from tbl_entry_202106 e\r\n"
				+ "join tbl_record_202106 r on e.entry_no = r.entry_no\r\n"
				+ "where e.entry_no = ?";
 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entry_no);
			rs = pstmt.executeQuery();
 
			if (rs.next()) {
				dto = new wrapperDTO();
				dto.getTbl_entryDTO().setEntry_no(rs.getString("entry_no"));
				dto.getTbl_entryDTO().setEntry_name(rs.getString("entry_name"));
				dto.getTbl_entryDTO().setEntry_jumin(rs.getString("entry_jumin"));
				dto.getTbl_entryDTO().setEntry_type(rs.getString("entry_type"));
				dto.getTbl_entryDTO().setEntry_area(rs.getString("entry_area"));
 
				dto.getTbl_recordDTO().setScore1(rs.getInt("score1"));
				dto.getTbl_recordDTO().setScore2(rs.getInt("score2"));
				dto.getTbl_recordDTO().setScore3(rs.getInt("score3"));
				dto.getTbl_recordDTO().setScore4(rs.getInt("score4"));
				dto.getTbl_recordDTO().setScore5(rs.getInt("score5"));
				dto.getTbl_recordDTO().setS_max(rs.getInt("s_max"));
				dto.getTbl_recordDTO().setS_min(rs.getInt("s_min"));
				dto.getTbl_recordDTO().setS_tot(rs.getInt("s_tot"));
				dto.getTbl_recordDTO().setS_ave(rs.getDouble("s_ave"));
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
 
		return dto;
	}
 
	
	public List<tbl_refereeDTO> getRefereeList() {
		List<tbl_refereeDTO> list = new ArrayList<tbl_refereeDTO>();
		String sql = "select rname1, rname2, rname3, rname4, rname5 from tbl_referee_202106";
 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
 
			while (rs.next()) {
				tbl_refereeDTO referee = new tbl_refereeDTO();
				referee.setRname1(rs.getString("rname1"));
				referee.setRname2(rs.getString("rname2"));
				referee.setRname3(rs.getString("rname3"));
				referee.setRname4(rs.getString("rname4"));
				referee.setRname5(rs.getString("rname5"));
				list.add(referee);
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
 
		return list;
	}
}
