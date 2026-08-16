package com.mnu.exGas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.exGas.util.DBManager;

public class GasDAO {
	private GasDAO() {}
	public static GasDAO instance = new GasDAO();
	public static GasDAO getInstancec() {
		return instance;
	}

	public int GasWrite(SaleInfoDTO dto) {
		String sql="insert into tbl_saleinfo_202010 values(?,?,?,?,?,?,?,?)";

		int row=0;
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getSaleno());
			pstmt.setString(2, dto.getOildate());
			pstmt.setString(3, dto.getOiltype());
			pstmt.setInt(4, dto.getAmount());
			pstmt.setString(5, dto.getPaytype());
			pstmt.setString(6, dto.getCustno());
			pstmt.setString(7, dto.getCreditcart());
			pstmt.setInt(8, dto.getOilcost());
			row=pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}return row;


	}

	public List<OilInfoDTO> getOilList() {
		List<OilInfoDTO> list = new ArrayList<OilInfoDTO>();
		String sql = "select oiltype, oilname from tbl_oilinfo_202010 order by oiltype";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OilInfoDTO oil = new OilInfoDTO();
				oil.setOiltype(rs.getString("oiltype"));
				oil.setOilname(rs.getString("oilname"));
				list.add(oil);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
		DBManager.close(conn, pstmt);
		}

		return list;
	}
	public List<SaleInfoDTO> gassalelist(){
		List<SaleInfoDTO> list = new ArrayList();
		String sql = "select s.saleno,s.oildate, s.oiltype, s.amount, s.paytype, c.custname,c.custno,\r\n"
				+ "c.custtel1,c.custtel2,c.custtel3,s.creditcart,s.oilcost from tbl_saleinfo_202010 s\r\n"
				+ "left join tbl_custinfo_202010 c on s.custno=c.custno";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SaleInfoDTO dto = new SaleInfoDTO();
				
				dto.setSaleno(rs.getString("saleno"));
				dto.setOildate(rs.getString("oildate"));
				dto.setOiltype(rs.getString("oiltype"));
				dto.setAmount(rs.getInt("amount"));
				dto.setPaytype(rs.getString("paytype"));
				dto.setCustname(rs.getString("custname"));
				dto.setCustno(rs.getString("custno"));
				dto.setCusttel1(rs.getString("custtel1"));
				dto.setCusttel2(rs.getString("custtel2"));
				dto.setCusttel3(rs.getString("custtel3"));
				dto.setCreditcart(rs.getString("creditcart"));
				dto.setOilcost(rs.getInt("oilcost"));
				list.add(dto);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
		
		
	}
	
	public List<DaysalesDTO> getDaysalesList(){
		List<DaysalesDTO> list = new ArrayList();
		String sql = "select s.oildate, o.oilname, count(*) as cnt, sum(s.oilcost) as total_cost\r\n"
				+ "from tbl_saleinfo_202010 s\r\n"
				+ "left join tbl_oilinfo_202010 o on s.oiltype=o.oiltype\r\n"
				+ "group by s.oildate, o.oilname\r\n"
				+ "order by s.oildate, o.oilname";
 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
 
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DaysalesDTO dto = new DaysalesDTO();
 
				dto.setOildate(rs.getString("oildate"));
				dto.setOilname(rs.getString("oilname"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setTotalCost(rs.getInt("total_cost"));
 
				list.add(dto);
			}
 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
 
	}
}