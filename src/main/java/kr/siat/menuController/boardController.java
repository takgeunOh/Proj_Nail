package kr.siat.menuController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.boardDeleteServiceImpl;
import kr.siat.boardservice.boardDetailServiceImpl;
import kr.siat.boardservice.boardInsertServiceImpl;
import kr.siat.boardservice.boardListServiceImpl;
import kr.siat.boardservice.boardModifyServiceImpl;
import kr.siat.controller.ModelAndView;

public class boardController implements Controller{

	// 기능 컨트롤러에서는 서비스로 안내할 수 있도록
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/list"))
			return new boardListServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/insert"))
			return new boardInsertServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/detail"))
			return new boardDetailServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/modify"))
			return new boardModifyServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/delete"))
			return new boardDeleteServiceImpl().request(req, resp);
		
		return null;
	}

}
