package com.mnu.Vaccine.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.Vaccine.util.DBManager;

public class VacDAO {
	private VacDAO() {}
	public static VacDAO instance = new VacDAO();
	public static VacDAO getInstance() {
		return instance;
	}
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	
	
	public int vacwrite(VaccresvDTO dto) {
		int row=0;
		String sql="insert into tbl_vaccresv_202108(resvno,jumin,vcode,hospcode,resvdate,resvyime) values(?,?,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getResvno());
			pstmt.setString(2,dto.getJumin());
			pstmt.setString(3,dto.getVcode());
			pstmt.setString(4,dto.getHospcode());
			pstmt.setString(5,dto.getResvdate());
			pstmt.setString(6,dto.getResvyime());
			
			row = pstmt.executeUpdate();
			
		}catch( Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return row;
		
	}
	
	public List<SearchresvDTO> searchlist(String resvno){
	    List<SearchresvDTO> list= new ArrayList();
	    String sql ="select j.pname,j.jumin,decode(substr(j.jumin,8,1),'1','남','3','남','2','여','4','여') as gender ,j.tel,\r\n"
	            + "substr(v.resvdate,1,4)||'년'|| substr(v.resvdate,5,2)||'월'||substr(v.resvdate,7,2)||'일' resvdate,\r\n"
	            + "substr(v.resvyime,1,2)||':'||substr(v.resvyime,3,2) resvyime,\r\n"
	            + "h.hospname,h.hosptel,h.hospaddr,\r\n"
	            + "decode(v.vcode,'V001','A 백신', 'V002', 'B 백신', 'V003', 'C 백신') vname\r\n"
	            + "from tbl_vaccresv_202108 v  join\r\n"
	            + "tbl_hosp_202108 h on v.hospcode= h.hospcode  join tbl_jumin_202108 j on v.jumin=\r\n"
	            + "j.jumin\r\n"
	            + "where v.resvno = ?";

	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, resvno);
	        rs= pstmt.executeQuery();

	        while(rs.next()) {
	            SearchresvDTO dto = new SearchresvDTO();
	            dto.setPname(rs.getString("pname"));
	            dto.setJumin(rs.getString("jumin"));
	            dto.setGender(rs.getString("gender"));
	            dto.setTel(rs.getString("tel"));
	            dto.setResvdate(rs.getString("resvdate"));
	            dto.setResvyime(rs.getString("resvyime"));
	            dto.setHospname(rs.getString("hospname"));
	            dto.setHosptel(rs.getString("hosptel"));
	            dto.setHospaddr(rs.getString("hospaddr"));
	            dto.setVname(rs.getString("vname"));
	            list.add(dto);
	        }
	    }catch(Exception e) {
	        e.printStackTrace();
	    }finally {
	        DBManager.close(conn, pstmt, rs);
	    }return list;
	}
	
	public List<VaccListDTO> vacclist(){
		List<VaccListDTO> list= new ArrayList();
		String sql= " select h.hospcode,h.hospname,count(v.vcode) cnt from tbl_hosp_202108 h join tbl_vaccresv_202108 v on h.hospcode = v.hospcode\r\n"
				+ " group by h.hospcode, h.hospname order by count(v.vcode) desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				VaccListDTO dto = new VaccListDTO();
				
				dto.setHospcode(rs.getString("hospcode"));
				dto.setHospname(rs.getString("hospname"));
				dto.setcnt(rs.getString("cnt"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
	}
}
