package kr.siat.dramaservice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.MovieDTO;
import kr.siat.model.dramaDTO;

public class dramaInsertServiceImpl implements Service {

	
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
		      
		      dramaDAO.insert(new dramaDTO(genre, title, content, director, year, price, country, company, hide, age));
	}
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			return new ModelAndView("drama/insert", false);
		}
		else if("POST".equals(req.getMethod())){
			doPost(req, resp);
			return new ModelAndView("category.drama", true);
		}
		else
			return null;
	}
}
