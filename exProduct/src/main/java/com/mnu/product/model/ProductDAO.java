package com.mnu.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.product.util.DBManager;



public class ProductDAO {
	private ProductDAO() {}
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
	public List<wrapperDTO> productList(){
		List<wrapperDTO> list = new ArrayList();
		String sql="select * from tbl_product_202002";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				wrapperDTO dto = new wrapperDTO();
				dto.getTbl_product().setP_code(rs.getString("p_code"));
				dto.getTbl_product().setP_name(rs.getString("p_name"));
				dto.getTbl_product().setP_size(rs.getString("p_size"));
				dto.getTbl_product().setP_incost(rs.getString("p_incost"));
				dto.getTbl_product().setP_outcost(rs.getString("p_outcost"));
				
				list.add(dto);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
		
	}

	public String getNextInOpNo() {
		String sql = "select to_char(nvl(max(to_number(t_no)),2020000)+1) from tbl_inout_202002";
		String nextNo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				nextNo = rs.getString(1);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return nextNo;
	}

	public List<wrapperDTO> inOpList(){
		List<wrapperDTO> list = new ArrayList();
		String sql="select i.t_no, i.p_code, p.p_name, i.t_type, i.t_cnt, i.c_code,"
				+ " to_char(i.t_date,'YYYY-MM-DD') t_date"
				+ " from tbl_inout_202002 i join tbl_product_202002 p on i.p_code = p.p_code"
				+ " order by i.t_no";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs=pstmt.executeQuery();

			while(rs.next()) {
				wrapperDTO dto = new wrapperDTO();
				dto.getTbl_inout().setT_no(rs.getString("t_no"));
				dto.getTbl_inout().setP_code(rs.getString("p_code"));
				dto.getTbl_inout().setT_type(rs.getString("t_type"));
				dto.getTbl_inout().setT_cnt(rs.getInt("t_cnt"));
				dto.getTbl_inout().setC_code(rs.getString("c_code"));
				dto.getTbl_inout().setT_date(rs.getString("t_date"));
				dto.getTbl_product().setP_name(rs.getString("p_name"));

				list.add(dto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;

	}

	public int insertProduct(wrapperDTO dto) {
		String sql=" insert into tbl_inout_202002 values(?,?,?,?,to_date(?,'YYYYMMDD'),?)";
		int row=0;
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getTbl_inout().getT_no());
			pstmt.setString(2,dto.getTbl_inout().getP_code());
			pstmt.setString(3,dto.getTbl_inout().getT_type());
			pstmt.setInt(4,dto.getTbl_inout().getT_cnt());
			pstmt.setString(5,dto.getTbl_inout().getT_date());
			pstmt.setString(6,dto.getTbl_inout().getC_code());
			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,null);
		}return row;


	}
	
	public List<wrapperDTO> opSalesList(){
		List<wrapperDTO> list = new ArrayList();
		String sql="select p.p_code, p.p_name,"
				+ " nvl(sum(i.t_cnt),0) out_cnt,"
				+ " nvl(sum(i.t_cnt),0) * (p.p_outcost - p.p_incost) profit"
				+ " from tbl_product_202002 p"
				+ " left join tbl_inout_202002 i on p.p_code = i.p_code and i.t_type = 'O'"
				+ " group by p.p_code, p.p_name, p.p_outcost, p.p_incost"
				+ " order by p.p_code";

		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				wrapperDTO dto = new wrapperDTO();
				dto.getTbl_product().setP_code(rs.getString("p_code"));
				dto.getTbl_product().setP_name(rs.getString("p_name"));
				dto.getTbl_product().setProfit(rs.getString("profit"));
				dto.getTbl_inout().setT_cnt(rs.getInt("out_cnt"));

				list.add(dto);
			}


		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;

	}

}
