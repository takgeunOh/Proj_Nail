package kr.siat.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcUtil {
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String user = "comstudy22";
	static String password = "comstudy22";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement ptmt) {
		if(ptmt != null) {
			try {
				ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, PreparedStatement ptmt) {
		close(ptmt);
		close(conn);
	}
	
	public static void close(Connection conn, Statement stmt, PreparedStatement ptmt, ResultSet rs) {
		close(rs);
		close(stmt);
		close(ptmt);
		close(conn);
	}
	
	public static void close(Connection conn, PreparedStatement ptmt, ResultSet rs) {
		close(rs);
		close(ptmt);
		close(conn);
	}
}
