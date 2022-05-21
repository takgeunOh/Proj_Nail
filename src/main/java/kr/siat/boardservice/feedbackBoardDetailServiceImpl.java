package kr.siat.boardservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.model.CommentDTO;
import kr.siat.model.FeedbackAnswerDTO;
import kr.siat.model.FeedbackDTO;

public class feedbackBoardDetailServiceImpl implements Service {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		FeedbackDTO dto = new FeedbackDTO();
		
		dto = feedbackDAO.getDTObyNum(num);
		
		feedbackDAO.viewCountUpdate(feedbackDAO.ExtractViewCount(num), num);
		ArrayList<FeedbackAnswerDTO> answerList = feedbackAnswerDAO.getAnswerList(num);
		
		req.setAttribute("feedbackAnswerList", answerList);
		req.setAttribute("feedbackDto", dto);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("건의게시판 POST방식 진입");
	}
	
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// GET 방식으로 들어온 후
		// 수정이나 삭제작업을 진행할 시 POST 방식으로 진행
		
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			return new ModelAndView("/feedbackboard/detail", false);
		} else if ("POST".equals(req.getMethod())) {
			doPost(req, resp);
			
			return new ModelAndView("list.board", true);
		}
		
		return null;
	}

}
