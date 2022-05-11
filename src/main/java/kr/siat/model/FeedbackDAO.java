package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.siat.dbcp.JdbcUtil;

public class FeedbackDAO {

	
	final String SQL_LIST = "select * from feedbackboard";
	final String SQL_DETAIL = "select * from feedbackboard where num=?";
	
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;
	
	public ArrayList<FeedbackDTO> list() {
		
		ArrayList<FeedbackDTO> list = new ArrayList<FeedbackDTO>();
		
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_LIST);
			rs = ptmt.executeQuery();
			if(rs.next()) {
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String password = rs.getString("password");
				String regidate = rs.getString("regidate");
				int viewcnt = rs.getInt("viewcnt");
				String repauthor = rs.getString("repauthor");
				String repcontent = rs.getString("repcontent");
				
				list.add(new FeedbackDTO(num, author, title, content, password, regidate, viewcnt, repauthor, repcontent));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return list;
	}
	
	public FeedbackDTO getDTObyNum(int findnum) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_DETAIL);
			ptmt.setInt(1, findnum);
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String password = rs.getString("password");
				String regidate = rs.getString("regidate");
				int viewcnt = rs.getInt("viewcnt");
				String repauthor = rs.getString("repauthor");
				String repcontent = rs.getString("repcontent");
				
				
				FeedbackDTO dto = new FeedbackDTO(num, author, title, content, password, regidate, viewcnt, repauthor,
						repcontent);
				
				JdbcUtil.close(conn, ptmt, rs);
				
				return dto;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return null;
	}
}
