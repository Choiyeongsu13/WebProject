package com.mnu.exStudent.util;

import java.sql.*;

public class DBManager {
	
	public static Connection getConnection() {
		
			Connection conn = null;
			String myDriver="oracle.jdbc.OracleDriver";
			String myURL="jdbc:oracle:thin:@localhost:1521:xe";
			String myID="c##test";
			String myPass="1234";
		
		
		try {//1 드라이버 로딩
			
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myURL, myID, myPass);
		}catch(Exception e) {
			e.printStackTrace();
		}
			try {
				
			}catch(Exception e) {
			e.printStackTrace();
			}
			
		
	return conn;	
	}
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
	try {
		
		pstmt.close();
		conn.close();
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}
	}

}
