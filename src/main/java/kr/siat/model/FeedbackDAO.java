package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.siat.dbcp.JdbcUtil;

public class FeedbackDAO {

	
	final String SQL_LIST = "select * from feedbackboard order by num desc";
	final String SQL_DETAIL = "select * from feedbackboard where num=?";
	final String SQL_CHANGE = "update feedbackboard set answercheck=feedback_seq.nextval where num=?";
	final String SQL_INSERT = "insert into feedbackboard values (feedbackboard_seq.nextval, ?, ?, ?, ?, sysdate, 0, 1)";
	final String SQL_UPDATE_VIEWCOUNT = "update feedbackboard set viewcnt=? where num=?";
	final String SQL_GET_COMMENTCOUNT = "select count(num) from feedbackanswer where boardnum=?";
	final String SQL_DELETE = "delete from feedbackboard where num=?";
	
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;
	
	public ArrayList<FeedbackDTO> list() {
		
		ArrayList<FeedbackDTO> list = new ArrayList<FeedbackDTO>();
		
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_LIST);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String type = rs.getString("querytype");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regidate = rs.getString("regidate");
				int viewcnt = rs.getInt("viewcnt");
				int answerCheck = rs.getInt("answercheck");
				
				list.add(new FeedbackDTO(num, author, type, title, content, regidate, viewcnt, answerCheck));
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
				String type = rs.getString("querytype");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regidate = rs.getString("regidate");
				int viewcnt = rs.getInt("viewcnt");
				int answerCheck = rs.getInt("answercheck");
				
				FeedbackDTO dto = new FeedbackDTO(num, author, type, title, content, regidate, viewcnt, answerCheck);
				
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
	
	public void changeProcess(int feedbackboardNum) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_CHANGE);
			ptmt.setInt(1, feedbackboardNum);
			
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
	
	public void insert(FeedbackDTO dto) {
		conn = JdbcUtil.getConnection();
		System.out.println("문의게시판에서의 영화이름 : " + dto.getType());
		try {
			ptmt = conn.prepareStatement(SQL_INSERT);
			ptmt.setString(1, dto.getAuthor());
			ptmt.setString(2,  dto.getType());
			ptmt.setString(3, dto.getTitle());
			ptmt.setString(4, dto.getContent());
			
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
	
	public int ExtractViewCount(int num) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_DETAIL);
			ptmt.setInt(1, num);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				int saveViewCount = rs.getInt("viewcnt");
				JdbcUtil.close(conn, ptmt, rs);
				return saveViewCount;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, ptmt, rs);
		return 0;
	}
	
	public void viewCountUpdate(int saveViewCount, int num) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_UPDATE_VIEWCOUNT);
			ptmt.setInt(1, saveViewCount+1);
			ptmt.setInt(2, num);
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
	
	public void delete(int feedbackBoardNum) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_DELETE);
			ptmt.setInt(1, feedbackBoardNum);
			
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
