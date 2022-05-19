package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import kr.siat.dbcp.JdbcUtil;


public class MovieDAO {

	
 	final String SQL_SELECT = "select * from movietable order by movienum desc";
 	final String SQL_INSERT = "insert into movietable values(movietable_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, 0, ?,?)";
	final String SQL_DETAIL = "select * from movietable where movienum=?";
	final String SQL_UPDATE = "update movietable set movietitle=?, moviecontent=?, moviegenre=?, moviedirector=?, movieyear=? ,moviecountry=?, moviecompany=?, movieprice=?, moviehide=?, movieage=? WHERE movienum=?";
	final String SQL_DELETE = "delete movietable where movienum=?";
	//final String SQL_UPDATE_VIEWCOUNT = "update movietable set boardviewcnt=? where boardnum=?";
	final String SQL_SEARCH_TITLE = "SELECT * FROM movietable WHERE movietitle LIKE '%'||?||'%' ";
	//or AUTHOR LIKE '%'||?||'%' or CONTENT LIKE '%'||?||'%' ;
	//final String SQL_FIND = "SELECT movietitle FROM movietable WHERE movietitle=?";
	  
	
	
	
	
	
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ptmt;
	private ResultSet rs;
		
	
	
	
	public ArrayList<MovieDTO> List() {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_SELECT);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
	            int movieNum = rs.getInt("movienum");
	            String movieGenre = rs.getString("moviegenre");
	            String movieTitle = rs.getString("movietitle");
	            String movieContent = rs.getString("moviecontent");
	            String movieDirector = rs.getString("moviedirector");            
	            String movieYear = rs.getString("movieyear");
	            int moviePrice = rs.getInt("movieprice");
	            String movieCountry = rs.getString("moviecountry");   
	            String movieCompany = rs.getString("moviecompany");   
	            int movieLikeCnt = rs.getInt("movielikecnt");
	            int movieHide = rs.getInt("moviehide");
	            int movieAge = rs.getInt("movieage");
	            
	            list.add(new MovieDTO(movieNum, movieGenre, movieTitle, movieContent, movieDirector, movieYear,moviePrice, movieCountry,
	                  movieCompany, movieLikeCnt, movieHide,movieAge));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return list;
	}


	public MovieDTO selectbyMovieNum(String num) {
		System.out.println(num);		// 정상 출력
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_DETAIL);
			ptmt.setInt(1, Integer.parseInt(num));
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
	            int movieNum = rs.getInt("movienum");
	            String movieGenre = rs.getString("moviegenre");
	            String movieTitle = rs.getString("movietitle");
	            String movieContent = rs.getString("moviecontent");
	            String movieDirector = rs.getString("moviedirector");            
	            String movieYear = rs.getString("movieyear");
	            int moviePrice = rs.getInt("movieprice");
	            String movieCountry = rs.getString("moviecountry");   
	            String movieCompany = rs.getString("moviecompany");   
	            int movieLikeCnt = rs.getInt("movielikecnt");
	            int movieHide = rs.getInt("moviehide");
	            int movieAge = rs.getInt("movieage");
	            
	            MovieDTO movieDTO = new MovieDTO(movieNum, movieGenre, movieTitle, movieContent, movieDirector, movieYear,moviePrice, movieCountry,
	                  movieCompany, movieLikeCnt, movieHide,movieAge);
				
				JdbcUtil.close(conn, ptmt, rs);
				
				return movieDTO;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return null;
	}


	public void insert(MovieDTO dto) {
	      
	      conn = JdbcUtil.getConnection();
	      
	      try {
	         ptmt = conn.prepareStatement(SQL_INSERT);
	         ptmt.setString(1, dto.getMovieGenre());
	         ptmt.setString(2, dto.getMovieTitle());
	         ptmt.setString(3, dto.getMovieContent());
	         ptmt.setString(4, dto.getMovieDirector());
	         ptmt.setString(5, dto.getMovieYear());
	         ptmt.setInt(6, dto.getMoviePrice());
	         ptmt.setString(7, dto.getMovieCountry());
	         ptmt.setString(8, dto.getMovieCompany());
	         ptmt.setInt(9, dto.getMovieHide());
	         ptmt.setInt(10, dto.getMovieAge());
	         
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
	


	
	 public ArrayList<MovieDTO> search(String searchtext) {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_SEARCH_TITLE);			
			ptmt.setString(1,searchtext);
		
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
	            int movieNum = rs.getInt("movienum");
	            String movieGenre = rs.getString("moviegenre");
	            String movieTitle = rs.getString("movietitle");
	            String movieContent = rs.getString("moviecontent");
	            String movieDirector = rs.getString("moviedirector");            
	            String movieYear = rs.getString("movieyear");
	            int moviePrice = rs.getInt("movieprice");
	            String movieCountry = rs.getString("moviecountry");   
	            String movieCompany = rs.getString("moviecompany");   
	            int movieLikeCnt = rs.getInt("movielikecnt");
	            int movieHide = rs.getInt("moviehide");
	            int movieAge = rs.getInt("movieage");
	            
	            list.add(new MovieDTO(movieNum, movieGenre, movieTitle, movieContent, movieDirector, movieYear,moviePrice, movieCountry,
	                  movieCompany, movieLikeCnt, movieHide,movieAge));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return list;
	}


		
	

}
