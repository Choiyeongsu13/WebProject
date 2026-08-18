package com.mnu.exShop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.exShopMVC.util.DBManager;

public class ShopDAO {
	private ShopDAO() {}
	public static ShopDAO instance= new ShopDAO();
	public static ShopDAO getInstance() {
		return instance;
	}
	
	Connection conn =null;
	PreparedStatement pstmt = null;
	ResultSet rs= null;
	
	//1 회원번호 최대 값 검색
	public int custMAX() {
		//반환타입
		int row= 0;		//쿼리
		String sql= "select max(custno) from tbl_member";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				row= rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		} return row;
	}
	
	
	//2. 도시코드 검색
	
	public List<CityDTO> cityList(){
		List<CityDTO> list = new ArrayList();
		String sql="select * from tbl_city";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CityDTO dto = new CityDTO();
				dto.setCity(rs.getString("city"));
				dto.setCityname(rs.getString("cityname"));
				
				list.add(dto);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
	}
	
	public int memberWrite(MemberDTO dto) {
		int row=0;
		String sql="insert into tbl_member(custno,custname,phone,gender,"
				+ "joindate , grade , city) values(?,?,?,?,?,?,?)";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getCustno());
			pstmt.setString(2,dto.getCustname());
			pstmt.setString(3,dto.getPhone());
			pstmt.setString(4,dto.getGender());
			pstmt.setString(5,dto.getJoindate());
			pstmt.setString(6,dto.getGrade());
			pstmt.setString(7,dto.getCity());
			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return row;
		
	}


	public int saleMAX() {
		int row = 0;
		String sql = "select max(saleno) from tbl_money";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				row = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	
	public int moneyWrite(MoneyDTO dto) {
		int row = 0;
		String sql = "insert into tbl_money(saleno,custno,pcode,amount,sdate) "
				+ "values(?,?,?,?,?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getSaleno());
			pstmt.setInt(2, dto.getCustno());
			pstmt.setString(3, dto.getPcode());
			pstmt.setInt(4, dto.getAmount());
			pstmt.setString(5, dto.getSdate());

			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	
	//회원목록
	
	public List<MemberDTO> memberList(){
	    List<MemberDTO> list = new ArrayList<MemberDTO>();
	    
	    
	    String sql = "select custno,custname,phone,gender,joindate,grade,cityname \r\n"
	               + "from tbl_member m join tbl_city c on m.city=c.city ";
	    
	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        
	        while(rs.next()) {
	            MemberDTO dto = new MemberDTO();
	            dto.setCustno(rs.getInt("custno"));
	            dto.setCustname(rs.getString("custname"));
	            dto.setPhone(rs.getString("phone"));
	            
	            
	            String gender = rs.getString("gender");
	            if("M".equals(gender)) gender = "남자";
	            else if("F".equals(gender)) gender = "여자";
	            dto.setGender(gender);
	            
	            dto.setJoindate(rs.getString("joindate"));
	            
	            
	            String grade = rs.getString("grade");
	            if("A".equals(grade)) grade = "VIP";
	            else if("B".equals(grade)) grade = "일반";
	            else if("C".equals(grade)) grade = "직원";
	            dto.setGrade(grade);
	            
	            dto.setCityname(rs.getString("cityname"));
	            
	            list.add(dto);
	        }
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	       DBManager.close(conn, pstmt, rs);
	    }
	    return list;
	}
	
	//회원번호를 이용한 검색
	public MemberDTO getMember(int custno) {
		MemberDTO dto = new MemberDTO();
		String sql=" select * from tbl_member where custno = ?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, custno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setCustno(rs.getInt("custno"));
				dto.setCustname(rs.getString("custname"));
				dto.setPhone(rs.getString("phone"));
				dto.setGender(rs.getString("gender"));
				dto.setJoindate(rs.getString("joindate"));
				dto.setGrade(rs.getString("grade"));
				dto.setCity(rs.getString("city"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return dto;
	
	}
	
	public int memberModify(MemberDTO dto) {
		int row=0;
		String sql="update tbl_member set phone=? , gender=?, joindate=?"
				+ " ,grade=?, city=? where custno=?";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			
			pstmt.setString(1, dto.getPhone());
			pstmt.setString(2, dto.getGender());
			pstmt.setString(3, dto.getJoindate());
			pstmt.setString(4, dto.getGrade());
			pstmt.setString(5, dto.getCity());
			pstmt.setInt(6, dto.getCustno());
			
			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}
	
	public int memberDelete(int custno) {
		int row=0;
		String sql="delete from tbl_member where custno=?";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, custno);

			
			row=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}
	
}