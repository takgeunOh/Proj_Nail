package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.siat.dbcp.JdbcUtil;

public class CartDAO {

	final String SQL_LIST = "select * from movietable";
	
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;
	
	public List<CartDTO> getList() {
		conn = JdbcUtil.getConnection();
		List<CartDTO> list = new ArrayList<CartDTO>();
		try {
			ptmt = conn.prepareStatement(SQL_LIST);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("movieNum");
				String genre = rs.getString("moviegenre");
				String title = rs.getString("movietitle");
				String content = rs.getString("moviecontent");
				String director = rs.getString("moviedirector");
				String year = rs.getString("movieyear");
				int price = rs.getInt("movieprice");
				String country = rs.getString("moviecountry");
				String company = rs.getString("moviecompany");
				int likeCnt = rs.getInt("movielikecnt");
				int hide = rs.getInt("moviehide");
				int age = rs.getInt("movieage");
				
				System.out.println();
				
				list.add(new CartDTO(num, genre, title, content, director, year, price, country, company, likeCnt, hide, age));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return list;
	}
}
