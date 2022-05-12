package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.boardInsertServiceImpl;
import kr.siat.boardservice.boardListServiceImpl;
import kr.siat.controller.ModelAndView;
import movieservice.movieDetailServiceImpl;
import movieservice.movieInsertServiceImpl;
import movieservice.movieListServiceImpl;
import movieservice.movieModifyServiceImpl;
import movieservice.movieWatchServiceImpl;

public class movieController implements Controller {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
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
		}
		
		
		return null;
	}

}
