package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import kr.siat.dbcp.JdbcUtil;

public class BoardDAO {
	
	final String SQL_SELECT = "select * from movieboard order by boardnum desc";
	// final String SQL_INSERT = "insert into movieboard values(movieboard_seq.nextval, ?, ?, ?, sysdate, 0, 0, 0, 0, 0, ?, ?)";
	final String SQL_INSERT = "insert into movieboard values(movieboard_seq.nextval, ?, ?, ?, ?, sysdate, 0, 0, 0, 0, 0, ?)";
	final String SQL_DETAIL = "select * from movieboard where boardnum=?";
	final String SQL_UPDATE = "update movieboard set boardtitle=?, boardcontent=? WHERE boardnum=?";
	final String SQL_DELETE = "delete movieboard where boardnum=?";
	final String SQL_UPDATE_VIEWCOUNT = "update movieboard set boardviewcnt=? where boardnum=?";
	final String SQL_GET_COMMENTCOUNT = "select count(comment_num) from board_comment where comment_board=?";
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ptmt;
	private ResultSet rs;
	
	public ArrayList<BoardDTO> List() {
		// num, userEmail, author, title, content, regidate, viewcnt, likecnt, reproot, repstep, repindent, videoname 순
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		conn = JdbcUtil.getConnection();
		
		try {
			ptmt = conn.prepareStatement(SQL_SELECT);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("boardnum");
				String userEmail = rs.getString("boardemail");
				String author = rs.getString("boardauthor");
				String title = rs.getString("boardtitle");
				String content = rs.getString("boardcontent");
				String regidate = rs.getString("boardregidate");
				int viewCnt = rs.getInt("boardviewcnt");
				int likeCnt = rs.getInt("boardlikecnt");
				int repRoot = rs.getInt("boardreproot");
				int repStep = rs.getInt("boardrepstep");
				int repIndent = rs.getInt("boardrepindent");
				String videoName = rs.getString("boardvideoname");
				
				list.add(new BoardDTO(num, userEmail, author, title, content, regidate, viewCnt, likeCnt, repRoot,
						repStep, repIndent, videoName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return list;
	}
	
	public void insert(BoardDTO dto) {
		
		// values(movieboard_seq.nextval, ?, ?, ?, ?, sysdate, 0, 0, 0, 0, 0, ?)";
		// num, userEmail, author, title, content, regidate, viewcnt, likecnt, reproot, repstep, repindent, videoname 순
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_INSERT);
			ptmt.setString(1, dto.getUserEmail());
			ptmt.setString(2, dto.getAuthor());
			ptmt.setString(3, dto.getTitle());
			ptmt.setString(4, dto.getContent());
			ptmt.setString(5, dto.getVideoName());
			
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
	
	public BoardDTO selectbyBoardNum(String num) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_DETAIL);
			ptmt.setInt(1, Integer.parseInt(num));
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				int boardNum = rs.getInt("boardnum");
				String boardAuthor = rs.getString("boardauthor");
				String boardTitle = rs.getString("boardtitle");
				String boardContent = rs.getString("boardcontent");
				// String boardPassword = rs.getString("boardpassword");
				String boardRegiDate = rs.getString("boardregidate");
				int boardViewCnt = rs.getInt("boardviewcnt");
				int boardLikeCnt = rs.getInt("boardlikecnt");
				int boardRepRoot = rs.getInt("boardreproot");
				int boardRepStep = rs.getInt("boardrepstep");
				int boardRepIndent = rs.getInt("boardrepindent");
				String boardVideoName = rs.getString("boardvideoname");
				String boardEmail = rs.getString("boardemail");
				
				BoardDTO boardDTO = new BoardDTO(boardNum, boardEmail, boardAuthor, boardTitle, boardContent, boardRegiDate, boardViewCnt, boardLikeCnt,
						boardRepRoot, boardRepStep, boardRepIndent, boardVideoName);
				
				JdbcUtil.close(conn, ptmt, rs);
				
				return boardDTO;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return null;
	}
	
	public void update(String modifyTitle, String modifyContent, int modifyNum) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_UPDATE);
			ptmt.setString(1, modifyTitle);
			ptmt.setString(2, modifyContent);
			ptmt.setInt(3, modifyNum);
			
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
	
	public void delete(String deleteNum) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_DELETE);
			ptmt.setInt(1, Integer.parseInt(deleteNum));
			
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
				int saveViewCount = rs.getInt("boardviewcnt");
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
	
	public int getCommentCount(int boardNum) {
		
		// System.out.println("BoardDAO에서 댓글개수 구할 때 넘어온 게시글 번호 : " + boardNum);				// 정상 출력
		int count=0;
		
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_GET_COMMENTCOUNT);
			ptmt.setInt(1, boardNum);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				// System.out.println(rs.getInt("count(comment_num)")); 정상 출력
				count = rs.getInt("count(comment_num)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		return count;
	}
}
