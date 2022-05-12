package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dramaservice.dramaDetailServiceImpl;
import dramaservice.dramaListServiceImpl;
import dramaservice.dramaWatchServiceImpl;
import kr.siat.boardservice.boardDeleteServiceImpl;
import kr.siat.boardservice.boardDetailServiceImpl;
import kr.siat.boardservice.boardInsertServiceImpl;
import kr.siat.boardservice.boardListServiceImpl;
import kr.siat.boardservice.boardModifyServiceImpl;
import kr.siat.controller.ModelAndView;

public class dramaController implements Controller {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/category"))
			return new dramaListServiceImpl().request(req, resp);
		
		else if(req.getAttribute("service").equals("/detail"))
			return new dramaDetailServiceImpl().request(req, resp);
		
		else if(req.getAttribute("service").equals("/watchdrama"))
			return new dramaWatchServiceImpl().request(req, resp);
		
		else if(req.getAttribute("service").equals("/modify"))
			return new boardModifyServiceImpl().request(req, resp);
		
		else if(req.getAttribute("service").equals("/delete"))
			return new boardDeleteServiceImpl().request(req, resp);
		
		return null;
	}

}
