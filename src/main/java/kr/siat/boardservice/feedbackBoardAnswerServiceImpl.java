package kr.siat.boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.siat.controller.ModelAndView;
import kr.siat.model.FeedbackAnswerDTO;

public class feedbackBoardAnswerServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		FeedbackAnswerDTO dto = new FeedbackAnswerDTO((Integer.parseInt(req.getParameter("boardNum"))), (String)session.getAttribute("user_email"), req.getParameter("answer"));
		System.out.println("문의게시판 데이터 확인 : " + req.getParameter("boardNum") + " " + req.getParameter("answer"));
		feedbackAnswerDAO.insert(dto);
		
		req.setAttribute("answerDTO", dto);
		
		return null;
	}

}
