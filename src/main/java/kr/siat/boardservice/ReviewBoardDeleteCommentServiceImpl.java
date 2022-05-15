package kr.siat.boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;

public class ReviewBoardDeleteCommentServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		int commentNum = (Integer.parseInt(req.getParameter("commentNum")));
		int boardNum = (Integer.parseInt(req.getParameter("boardNum")));
		commentDAO.deleteComment(commentNum, boardNum);
		
		return null;
	}

}
