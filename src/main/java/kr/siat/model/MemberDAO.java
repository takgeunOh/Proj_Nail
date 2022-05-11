package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.siat.dbcp.JdbcUtil;

public class MemberDAO {

	final String SQL_EXIST_BY_EMAIL = "select * from member where useremail=?";
	final String SQL_REGISTER = "insert into member values (member_seq.nextval, ?, ?, ?, ?, sysdate, ?)";
	
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;
	
	public boolean existUserEmail(String userEmail) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_EXIST_BY_EMAIL);
			ptmt.setString(1, userEmail);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				JdbcUtil.close(conn, ptmt, rs);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void register(MemberDTO dto) {
		System.out.printf("DAO에서의 dto값들 : %s, %s, %s, %s, %d\n", dto.getUserName(), dto.getUserEmail(), dto.getUserPhone(), dto.getUserPassword(), dto.getUserType());
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_REGISTER);
			ptmt.setString(1, dto.getUserName());
			ptmt.setString(2, dto.getUserEmail());
			ptmt.setString(3, dto.getUserPhone());
			ptmt.setString(4, dto.getUserPassword());
			ptmt.setInt(5, dto.getUserType());
			
			int cnt = ptmt.executeUpdate();
			
			if(cnt>0)
				conn.commit();
			else
				conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt);
	}
}
