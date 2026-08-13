package com.mnu.Stock.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.Stock.util.DBManager;

public class StockDAO {
	private  StockDAO() {}
	private static StockDAO instance = new StockDAO();
	public static StockDAO getInstance(){
		return instance;
	}
	
	public List<TBL_STOCK_ITEM_DTO> stockitemlist(){
		List<TBL_STOCK_ITEM_DTO> list = new ArrayList();
		String sql = "select * from TBL_STOCK_ITEM_202201";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TBL_STOCK_ITEM_DTO dto = new TBL_STOCK_ITEM_DTO();
				
				dto.setStock_item_code(rs.getString("STOCK_ITEM_CODE"));
				dto.setStock_item_name(rs.getString("STOCK_ITEM_NAME"));
				dto.setStock_item_market(rs.getString("STOCK_ITEM_MARKET"));
				dto.setStock_item_category(rs.getString("STOCK_ITEM_CATEGORY"));
				dto.setStock_item_listed_date(rs.getString("STOCK_ITEM_LISTED_DATE"));
			
				list.add(dto);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
		
	}
	
	public List<TBL_DEPT_DTO> deptlist(){
		List<TBL_DEPT_DTO> list = new ArrayList();
		String sql = "select * from TBL_DEPT_202201";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TBL_DEPT_DTO dto = new TBL_DEPT_DTO();

				dto.setDept_code(rs.getString("DEPT_CODE"));
				dto.setDept_name(rs.getString("DEPT_NAME"));
				dto.setDept_offr(rs.getString("DEPT_OFFR"));

				list.add(dto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;

	}

	public int StockUpload(uploadDTO dto) {
		String sql="insert into TBL_BUY_STOCK_202201 (BUY_DATE, STOCK_ITEM_CODE, BUY_NUMBER, BUY_PRICE, DEPT_CODE) values (?,?,?,?,?)";
		int row=0;
		Connection conn=null;
		PreparedStatement pstmt= null;

		try {
			conn=DBManager.getConnection();
			pstmt= conn.prepareStatement(sql);

			pstmt.setString(1, dto.getBuy_date());
			pstmt.setString(2, dto.getStock_item_code());
			pstmt.setInt(3, dto.getBuy_number());
			pstmt.setInt(4, dto.getBuy_price());
			pstmt.setString(5, dto.getDept_code());

			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			DBManager.close(conn, pstmt, null);
		}return row;
		
	}

	public List<TradeListDTO> tradelist(){
		List<TradeListDTO> list = new ArrayList();
		String sql = "select b.buy_date, b.stock_item_code, s.stock_item_name, b.buy_number, b.buy_price, d.dept_name "
				+ "from tbl_buy_stock_202201 b "
				+ "join tbl_stock_item_202201 s on b.stock_item_code = s.stock_item_code "
				+ "join tbl_dept_202201 d on b.dept_code = d.dept_code "
				+ "order by b.buy_date desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TradeListDTO dto = new TradeListDTO();

				dto.setBuy_date(rs.getString("BUY_DATE"));
				dto.setStock_item_code(rs.getString("STOCK_ITEM_CODE"));
				dto.setStock_item_name(rs.getString("STOCK_ITEM_NAME"));
				dto.setBuy_number(rs.getInt("BUY_NUMBER"));
				dto.setBuy_price(rs.getInt("BUY_PRICE"));
				dto.setDept_name(rs.getString("DEPT_NAME"));

				list.add(dto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;

	}

	public List<DeptSalesDTO> deptsaleslist(){
		List<DeptSalesDTO> list = new ArrayList();
		String sql = "select d.dept_code, d.dept_name, sum(b.buy_number) total_number, sum(b.buy_number*b.buy_price) total_amount "
				+ "from tbl_buy_stock_202201 b "
				+ "join tbl_dept_202201 d on b.dept_code = d.dept_code "
				+ "group by d.dept_code, d.dept_name "
				+ "order by d.dept_code asc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DeptSalesDTO dto = new DeptSalesDTO();

				dto.setDept_code(rs.getString("DEPT_CODE"));
				dto.setDept_name(rs.getString("DEPT_NAME"));
				dto.setTotal_number(rs.getInt("TOTAL_NUMBER"));
				dto.setTotal_amount(rs.getLong("TOTAL_AMOUNT"));

				list.add(dto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;

	}

}
