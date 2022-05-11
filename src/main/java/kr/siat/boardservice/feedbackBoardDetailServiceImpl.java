package kr.siat.boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.model.FeedbackDTO;

public class feedbackBoardDetailServiceImpl implements Service {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		FeedbackDTO dto = new FeedbackDTO();
		
		dto = feedbackDAO.getDTObyNum(num);
		
		req.setAttribute("feedbackDto", dto);
	}
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// GET 방식으로 들어온 후
		// 수정이나 삭제작업을 진행할 시 POST 방식으로 진행
		
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			return new ModelAndView("/feedbackboard/detail", false);
		}
		
		return null;
	}

}
