package kr.siat.boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;

public class ReviewBoardDeleteCommentServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		// System.out.println(req.getParameter("idx1"));				// 정상 출력
		// System.out.println(req.getParameter("idx2"));				// 정상 출력
		
		int commentNum = (Integer.parseInt(req.getParameter("commentIdx")));
		int boardNum = (Integer.parseInt(req.getParameter("boardIdx")));
		
		commentDAO.deleteComment(commentNum, boardNum);
		
		return null;
	}

}
