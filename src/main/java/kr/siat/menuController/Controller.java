package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.model.BoardDAO;
import kr.siat.model.MovieCartDAO;
import kr.siat.model.CommentDAO;
import kr.siat.model.FeedbackAnswerDAO;
import kr.siat.model.FeedbackDAO;
import kr.siat.model.MemberDAO;
import kr.siat.model.MovieDAO;
import kr.siat.model.dramaDAO;


public interface Controller {
	MovieCartDAO movieCartDAO = new MovieCartDAO();
	FeedbackAnswerDAO feedbackAnswerDAO = new FeedbackAnswerDAO();
	CommentDAO commentDAO = new CommentDAO();
	MemberDAO memberDAO = new MemberDAO();
	FeedbackDAO feedbackDAO = new FeedbackDAO();
	BoardDAO boardDAO = new BoardDAO();
	MovieDAO movieDAO = new MovieDAO();
	dramaDAO dramaDAO = new dramaDAO();
	ModelAndView request(HttpServletRequest req, HttpServletResponse resp);
}
