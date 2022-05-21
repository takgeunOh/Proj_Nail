package kr.siat.boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;

public class feedbackBoardDeleteAnswerServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		// 답변 삭제 시 GET 방식으로만.
		
		System.out.println("문의게시판삭제서비스 진입 방식 : " + req.getMethod());
		
		
		feedbackAnswerDAO.delete((Integer.parseInt(req.getParameter("num"))));
		
		return null;
	}

}
