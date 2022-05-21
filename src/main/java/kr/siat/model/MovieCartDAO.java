package kr.siat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.siat.dbcp.JdbcUtil;

public class MovieCartDAO {

	final String SQL_LIST = "select * from cartlist";
	final String SQL_INSERT_MOVIE = "insert into cartlist values(cartlist_seq.nextval, ?, 0, ?, ?, ?)";
	final String SQL_INSERT_DRAMA_NUM = "insert into dramatable (dramanum) values(?)";
	final String SQL_DELETE = "delete from cartlist where cartnum=?";
	
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;
	
	public ArrayList<MovieCartDTO> getList() {
		conn = JdbcUtil.getConnection();
		ArrayList<MovieCartDTO> list = new ArrayList<MovieCartDTO>();
		try {
			ptmt = conn.prepareStatement(SQL_LIST);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("cartnum");
				int movieNum = rs.getInt("movieNum");
				int dramaNum = rs.getInt("dramanum");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int price = rs.getInt("productprice");
				
				list.add(new MovieCartDTO(num, movieNum, dramaNum, title, content, price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt, rs);
		
		return list;
	}
	
	public void insertMovie(int movieNum) {
		MovieDAO dao = new MovieDAO();
		MovieDTO dto = dao.selectbyMovieNum(Integer.toString(movieNum));

		System.out.println("카트DAO의 선택dto : " + dto.toString());
		
		conn = JdbcUtil.getConnection();
		try {
			ptmt = conn.prepareStatement(SQL_INSERT_MOVIE);
			ptmt.setInt(1, movieNum);
			ptmt.setString(2, dto.getMovieTitle());
			ptmt.setString(3, dto.getMovieContent());
			ptmt.setInt(4, dto.getMoviePrice());
			
			System.out.printf("카트DAO 값 확인 : %d %s %s %d\n", movieNum, dto.getMovieTitle(), dto.getMovieContent(), dto.getMoviePrice());
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
	
	public void deleteCartList(int cartNum) {
		conn = JdbcUtil.getConnection();
		try {
			ptmt =conn.prepareStatement(SQL_DELETE);
			ptmt.setInt(1, cartNum);
			
			int cnt=ptmt.executeUpdate();
			
			if(cnt>0)
				conn.close();
			else
				conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, ptmt);
	}
	
	public int getTotal(ArrayList<MovieCartDTO> list) {
		int total = 0;
		
		for(MovieCartDTO dto : list) {
			total = total + dto.getPrice();
		}
		
		return total;
	}
	public int getCountCartList(ArrayList<MovieCartDTO> list) {
		int count=0;
		
		count = list.size();
		
		return count;
	}
}
