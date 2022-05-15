package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.siat.dbcp.JdbcUtil;

public class CommentDAO {

	final String SQL_SELECT = "select * from board_comment where comment_board=? start with comment_parent=0 connect by prior comment_num=comment_parent";
	final String SQL_INSERT = "insert into board_comment values (comment_seq.nextval, ?, ?, sysdate, 0, ?)";
	final String SQL_DELETE = "delete from board_comment where comment_board=? and comment_num=?";
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ptmt;
	private ResultSet rs;
	
	public ArrayList<CommentDTO> getCommentList(int boardNum) {
		// System.out.println(">>> boardNum : " + boardNum);			// 정상 출력
		ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_SELECT);
			ptmt.setInt(1, boardNum);
			rs = ptmt.executeQuery();
			// System.out.println("CommentDAO rs : " + rs.next());		// 정상 작동
			
			while(rs.next()) {
				int commentNum = rs.getInt("comment_num");				// 댓글 시퀀스
				int commentBoard = rs.getInt("comment_board");			// 글 번호
				String commentID = rs.getString("comment_id");
				String commentDate = rs.getString("comment_date");
				int commentParent = rs.getInt("comment_parent");
				String commentContent = rs.getString("comment_content");
				// int commentLevel = rs.getInt("comment_level");
				
				list.add(new CommentDTO(commentNum, commentBoard, commentID, commentDate, commentParent, commentContent));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		return list;
	}
	
	public void commentInsert(CommentDTO dto) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_INSERT);
			ptmt.setInt(1, dto.getComment_board());
			ptmt.setString(2, dto.getComment_id());
			ptmt.setString(3, dto.getComment_content());
			
			int cnt=ptmt.executeUpdate();
			
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
	
	public void deleteComment(int commentNum, int boardNum) {
		System.out.println("CommentDAO 번호들 : " + commentNum + " " + boardNum);
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_DELETE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
