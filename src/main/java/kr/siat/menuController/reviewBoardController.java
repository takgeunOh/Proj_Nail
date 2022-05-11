package kr.siat.menuController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.reviewBoardDeleteServiceImpl;
import kr.siat.boardservice.reviewBoardDetailServiceImpl;
import kr.siat.boardservice.reviewBoardInsertServiceImpl;
import kr.siat.boardservice.reviewBoardListServiceImpl;
import kr.siat.boardservice.reviewBoardModifyServiceImpl;
import kr.siat.controller.ModelAndView;

public class reviewBoardController implements Controller{

	// 기능 컨트롤러에서는 서비스로 안내할 수 있도록
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/list"))
			return new reviewBoardListServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/insert"))
			return new reviewBoardInsertServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/detail"))
			return new reviewBoardDetailServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/modify"))
			return new reviewBoardModifyServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/delete"))
			return new reviewBoardDeleteServiceImpl().request(req, resp);
		
		return null;
	}

}
