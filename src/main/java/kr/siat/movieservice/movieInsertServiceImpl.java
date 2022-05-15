package kr.siat.movieservice;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.MovieDTO;

public class movieInsertServiceImpl implements Service {

	//������ ����(���̵�)�� �α��� �� ����� ���� ����

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("movieInsertServiceImpl GET 통과 >>");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("movieInsertServiceImpl POST 통과 >>");
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String genre = req.getParameter("genre");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String director = req.getParameter("director");
		String year = req.getParameter("year");
		int price = Integer.parseInt(req.getParameter("price"));
		String country = req.getParameter("country");
		String company = req.getParameter("company");
		int hide = Integer.parseInt(req.getParameter("hide"));
		int age = Integer.parseInt(req.getParameter("age"));
		
		movieDAO.insert(new MovieDTO(genre, title, content, director, year, price, country, company, hide, age));
		
	}

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		// GET���, POSST���
		
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
