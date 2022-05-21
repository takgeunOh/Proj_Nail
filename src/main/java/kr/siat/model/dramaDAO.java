package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.siat.dbcp.JdbcUtil;

public class dramaDAO {


 	final String SQL_SELECT = "select * from dramatable order by dramanum desc";
	final String SQL_INSERT = "insert into dramatable values(dramatable_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, 0, ?,?)";
	final String SQL_DETAIL = "select * from dramatable where dramanum=?";
	final String SQL_UPDATE = "update dramatable set dramatitle=?, dramacontent=?, dramagenre=?, dramadirector=?, dramayear=? ,dramacountry=?, dramacompany=?, dramaprice=?, dramahide=?, dramaage=? WHERE dramanum=?";
	final String SQL_DELETE = "delete dramatable where dramanum=?";
	//final String SQL_UPDATE_VIEWCOUNT = "update movietable set boardviewcnt=? where boardnum=?";
	final String SQL_SEARCH_TITLE = "SELECT * FROM dramatable WHERE dramatitle LIKE '%'||?||'%' ";
	
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ptmt;
	private ResultSet rs;
		
	
	
	public ArrayList<dramaDTO> List() {
		ArrayList<dramaDTO> list = new ArrayList<dramaDTO>();
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_SELECT);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				int dramaNum = rs.getInt("dramanum");
				String dramaGenre = rs.getString("dramagenre");
				String dramaTitle = rs.getString("dramatitle");
				String dramaContent = rs.getString("dramacontent");
				String dramaDirector = rs.getString("dramadirector");				
				String dramaYear = rs.getString("dramayear");
				int dramaPrice = rs.getInt("dramaprice");
				String dramaCountry = rs.getString("dramacountry");	
				String dramaCompany = rs.getString("dramacompany");	
				int dramaLikeCnt = rs.getInt("dramalikecnt");
				int dramaHide = rs.getInt("dramahide");
				int dramaAge = rs.getInt("dramaage");
				
				list.add(new dramaDTO(dramaNum, dramaGenre, dramaTitle, dramaContent, dramaDirector, dramaYear,dramaPrice, dramaCountry,
						dramaCompany, dramaLikeCnt, dramaHide,dramaAge));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return list;
	}



	public dramaDTO selectbyDramaNum(String num) {
		System.out.println(num);
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_DETAIL);
			ptmt.setInt(1, Integer.parseInt(num));
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				int dramaNum = rs.getInt("dramanum");
				String dramaGenre = rs.getString("dramagenre");
				String dramaTitle = rs.getString("dramatitle");
				String dramaContent = rs.getString("dramacontent");
				String dramaDirector = rs.getString("dramadirector");				
				String dramaYear = rs.getString("dramayear");
				int dramaPrice = rs.getInt("dramaprice");
				String dramaCountry = rs.getString("dramacountry");	
				String dramaCompany = rs.getString("dramacompany");	
				int dramaLikeCnt = rs.getInt("dramalikecnt");
				int dramaHide = rs.getInt("dramahide");
				int dramaAge = rs.getInt("dramaage");
				
				dramaDTO dramaDTO = new dramaDTO(dramaNum, dramaGenre, dramaTitle, dramaContent, dramaDirector, dramaYear,dramaPrice, dramaCountry,
						dramaCompany, dramaLikeCnt, dramaHide,dramaAge);
				
				JdbcUtil.close(conn, ptmt, rs);
				
				return dramaDTO;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return null;
	}
	public void insert(dramaDTO dto) {
	      
	      conn = JdbcUtil.getConnection();
	      
	      try {
	         ptmt = conn.prepareStatement(SQL_INSERT);
	         ptmt.setString(1, dto.getDramaGenre());
	         ptmt.setString(2, dto.getDramaTitle());
	         ptmt.setString(3, dto.getDramaContent());
	         ptmt.setString(4, dto.getDramaDirector());
	         ptmt.setString(5, dto.getDramaYear());
	         ptmt.setInt(6, dto.getDramaPrice());
	         ptmt.setString(7, dto.getDramaCountry());
	         ptmt.setString(8, dto.getDramaCompany());
	         ptmt.setInt(9, dto.getDramaHide());
	         ptmt.setInt(10, dto.getDramaAge());
	         
	         int cnt = ptmt.executeUpdate();
	         
	         if(cnt >0)
	            conn.commit();
	         else
	            conn.rollback();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      JdbcUtil.close(conn, ptmt);
	      
	   }

	public void update(String modifyTitle, String modifyContent, String modifyGenre,String modifyDirector,String modifyYear,String modifyCountry,String modifyCompany,int modifyPrice,int modifyHide,int modifyAge,int modifyNum) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_UPDATE);
			ptmt.setString(1, modifyTitle);
			ptmt.setString(2, modifyContent);
			ptmt.setString(3, modifyGenre);
			ptmt.setString(4, modifyDirector);
			ptmt.setString(5, modifyYear);
			ptmt.setString(6, modifyCountry);
			ptmt.setString(7, modifyCompany);
			ptmt.setInt(8, modifyPrice);
			ptmt.setInt(9, modifyHide);
			ptmt.setInt(10, modifyAge);
			ptmt.setInt(11, modifyNum);
		
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
	 
	public ArrayList<dramaDTO> search(String searchtext) {
			ArrayList<dramaDTO> list = new ArrayList<dramaDTO>();
			conn = JdbcUtil.getConnection();
			try {
				ptmt = conn.prepareStatement(SQL_SEARCH_TITLE);			
				ptmt.setString(1,searchtext);
			
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					int dramaNum = rs.getInt("dramanum");
					String dramaGenre = rs.getString("dramagenre");
					String dramaTitle = rs.getString("dramatitle");
					String dramaContent = rs.getString("dramacontent");
					String dramaDirector = rs.getString("dramadirector");				
					String dramaYear = rs.getString("dramayear");
					int dramaPrice = rs.getInt("dramaprice");
					String dramaCountry = rs.getString("dramacountry");	
					String dramaCompany = rs.getString("dramacompany");	
					int dramaLikeCnt = rs.getInt("dramalikecnt");
					int dramaHide = rs.getInt("dramahide");
					int dramaAge = rs.getInt("dramaage");
					
					list.add(new dramaDTO(dramaNum, dramaGenre, dramaTitle, dramaContent, dramaDirector, dramaYear,dramaPrice, dramaCountry,
							dramaCompany, dramaLikeCnt, dramaHide,dramaAge));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JdbcUtil.close(conn, ptmt, rs);
			
			return list;
		}

}
