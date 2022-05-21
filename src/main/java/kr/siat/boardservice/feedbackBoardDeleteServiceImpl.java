package kr.siat.boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;

public class feedbackBoardDeleteServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("문의글 삭제 서비스 진입 방식 : " + req.getMethod());
		
		feedbackDAO.delete(Integer.parseInt(req.getParameter("idx")));
		
		return null;
	}

}
