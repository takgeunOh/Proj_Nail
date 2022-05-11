package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.feedbackBoardDetailServiceImpl;
import kr.siat.boardservice.feedbackBoardListServiceImpl;
import kr.siat.boardservice.reviewBoardDeleteServiceImpl;
import kr.siat.boardservice.reviewBoardDetailServiceImpl;
import kr.siat.boardservice.reviewBoardInsertServiceImpl;
import kr.siat.boardservice.reviewBoardListServiceImpl;
import kr.siat.boardservice.reviewBoardModifyServiceImpl;
import kr.siat.controller.ModelAndView;

public class feedbackBoardController implements Controller{

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/feedbackList"))
			return new feedbackBoardListServiceImpl().request(req, resp);
		else if (req.getAttribute("service").equals("/feedbackDetail"))
			return new feedbackBoardDetailServiceImpl().request(req, resp);
		/*
		 * else if(req.getAttribute("service").equals("/insert")) return new
		 * reviewBoardInsertServiceImpl().request(req, resp); else
		 * if(req.getAttribute("service").equals("/detail")) return new
		 * reviewBoardDetailServiceImpl().request(req, resp); else
		 * if(req.getAttribute("service").equals("/modify")) return new
		 * reviewBoardModifyServiceImpl().request(req, resp); else
		 * if(req.getAttribute("service").equals("/delete")) return new
		 * reviewBoardDeleteServiceImpl().request(req, resp);
		 */
		
		return null;
	}

}
