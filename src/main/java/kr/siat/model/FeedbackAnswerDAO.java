package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.siat.boardservice.feedbackBoardInsertAnswerServiceImpl;
import kr.siat.dbcp.JdbcUtil;

public class FeedbackAnswerDAO {

	final String SQL_INSERT = "insert into feedbackanswer values (feedbackanswer_seq.nextval, ?, ?, ?)";
	final String SQL_SELECT = "select * from feedbackanswer where boardnum=?";
	final String SQL_DELETE = "delete from feedbackanswer where num=?";
	
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

	public ArrayList<FeedbackAnswerDTO> getAnswerList(int boardNum) {
		// System.out.println(">>> boardNum : " + boardNum);			// 정상 출력
		ArrayList<FeedbackAnswerDTO> list = new ArrayList<FeedbackAnswerDTO>();
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_SELECT);
			ptmt.setInt(1, boardNum);
			rs = ptmt.executeQuery();
			// System.out.println("CommentDAO rs : " + rs.next());		// 정상 작동
			
			while(rs.next()) {
				int answerNum = rs.getInt("num");				// 댓글 시퀀스
				int feedbackBoardNum = rs.getInt("boardnum");			// 글 번호
				String author = rs.getString("author");
				String answer = rs.getString("answer");
				
				list.add(new FeedbackAnswerDTO(answerNum, feedbackBoardNum, author, answer));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		return list;
	}

	public void delete(int answerNum) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_DELETE);
			ptmt.setInt(1, answerNum);
			
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
