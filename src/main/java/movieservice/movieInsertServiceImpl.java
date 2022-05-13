package movieservice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MovieModel.MovieDTO;
import boardservice.Service;
import controller.ModelAndView;

public class movieInsertServiceImpl implements Service {

	//관리자 계정(아이디)로 로그인 한 사람만 접근 가능

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//String movienum = req.getParameter("num");
		String genre = req.getParameter("genre");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String director = req.getParameter("director");
		String year = req.getParameter("year");
		String price = req.getParameter("price");
		String country = req.getParameter("country");
		String company = req.getParameter("company");
		//String likecnt = req.getParameter("lcnt");
		String hide = req.getParameter("hide");
		String age = req.getParameter("age");
		
		MovieDTO movieDTO = new MovieDTO(genre, title, content,director ,year,price,country,company,hide,age, age);
		movieDAO.insert(movieDTO);
	}

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		// GET방식, POSST방식
		
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			return new ModelAndView("movie/insert", false);
		}
		else if("POST".equals(req.getMethod())){
			doPost(req, resp);
			return new ModelAndView("category.movie", true);
		}
		else
			return null;
	}

}
