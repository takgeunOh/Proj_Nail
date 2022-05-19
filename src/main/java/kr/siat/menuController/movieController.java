package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.movieservice.movieDetailServiceImpl;
import kr.siat.movieservice.movieInsertServiceImpl;
import kr.siat.movieservice.movieListServiceImpl;
import kr.siat.movieservice.movieModifyServiceImpl;
import kr.siat.movieservice.movieSearchServiceImpl;
import kr.siat.movieservice.movieWatchServiceImpl;

public class movieController implements Controller {
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("영화컨트롤러 서비스명 : " + req.getAttribute("service"));
		if(req.getAttribute("service").equals("/category")) {
			return new movieListServiceImpl().request(req, resp);			
		}
		else if(req.getAttribute("service").equals("/detail")) {
			return new movieDetailServiceImpl().request(req, resp);
		}
			else if(req.getAttribute("service").equals("/moviemodify")) {
			return new movieModifyServiceImpl().request(req, resp);
		}else if(req.getAttribute("service").equals("/watchmovie")) {
			return new movieWatchServiceImpl().request(req, resp);
		}else if(req.getAttribute("service").equals("/insert")) {
			return new movieInsertServiceImpl().request(req, resp);
		}else if(req.getAttribute("service").equals("/search")) {
			return new movieSearchServiceImpl().request(req, resp);
		}
		
		
		return null;
	}

}
