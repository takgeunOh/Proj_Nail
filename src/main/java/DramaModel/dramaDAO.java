package DramaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MovieModel.MovieDTO;
import kr.siat.dbcp.JdbcUtil;

public class dramaDAO {


 	final String SQL_SELECT = "select * from dramatable order by dramanum desc";
	//final String SQL_INSERT = "insert into movietable values(movieboard_seq.nextval, ?, ?, ?, ?, sysdate, 0, 0, 0, 0, 0)";
	final String SQL_DETAIL = "select * from dramatable where dramanum=?";
	final String SQL_UPDATE = "update dramatable set dramatitle=?, dramacontent=? WHERE dramanum=?";
	final String SQL_DELETE = "delete dramatable where dramanum=?";
	//final String SQL_UPDATE_VIEWCOUNT = "update movietable set boardviewcnt=? where boardnum=?";
	
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
				int dramaYear = rs.getInt("dramayear");
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
				int dramaYear = rs.getInt("dramayear");
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





}
