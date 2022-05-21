package kr.siat.cartservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;

public class CartMovieInsertServiceImpl implements Service {
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		int MovieproductNum = Integer.parseInt(req.getParameter("movieNum"));
		System.out.println("카트추가서비스 movieNum : " + MovieproductNum);				
		
		movieCartDAO.insertMovie(MovieproductNum);
		
		return null;
	}

}
