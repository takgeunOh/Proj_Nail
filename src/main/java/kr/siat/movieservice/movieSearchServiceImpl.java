package kr.siat.movieservice;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.MovieDTO;



public class movieSearchServiceImpl implements Service {


	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		String searchData = req.getParameter("searchtext");
		
		System.out.println(" >> movieSearchServiceImpl searchData : " + searchData);
		
		list = movieDAO.search(searchData);
		
		req.setAttribute("searchList", list);

		return new ModelAndView("/movie/search", false);
	}

}
