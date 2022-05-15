package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.siat.boardservice.feedbackBoardAnswerServiceImpl;
import kr.siat.dbcp.JdbcUtil;

public class FeedbackAnswerDAO {

	final String SQL_INSERT = "insert into feedbackanswer values (feedbackanswer_seq.nextval, ?, ?, ?)";
	final String SQL_SELECT = "select * from feedbackanswer where boardnum=?";
	
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;
	
	public void insert(FeedbackAnswerDTO dto) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_INSERT);
			ptmt.setInt(1, dto.getBoardnum());
			ptmt.setString(2, dto.getAuthor());
			ptmt.setString(3, dto.getAnswer());
			
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
