package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.model.BoardDAO;
import kr.siat.model.FeedbackDAO;
import kr.siat.model.MemberDAO;

public interface Controller {
	FeedbackDAO feedbackDAO = new FeedbackDAO();
	BoardDAO boardDAO = new BoardDAO();
	MemberDAO memberDAO = new MemberDAO();
	ModelAndView request(HttpServletRequest req, HttpServletResponse resp);
}
