package MovieModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import kr.siat.dbcp.JdbcUtil;
import kr.siat.model.BoardDTO;

public class MovieDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement ptmt;
	private ResultSet rs;
		
	
	
	
	public ArrayList<MovieDTO> List() {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		conn = JdbcUtil.getConnection();
		
		
		
		
		return null;
	}


	public MovieDTO selectbyMovieNum(String num) {
		conn = JdbcUtil.getConnection();
		
		
		
		
		return null;
	}

	

	
}
