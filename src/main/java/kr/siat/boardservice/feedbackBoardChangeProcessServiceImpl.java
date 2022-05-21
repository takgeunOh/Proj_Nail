package kr.siat.boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;

public class feedbackBoardChangeProcessServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		// 클릭해서 버튼 모양만 바꿀 것.
		// DB의 answercheck 값만 바꿔주면 된다.
		
		// System.out.println("문의게시판 번호 넘어옴 확인 : " + req.getParameter("idx"));		// 정상 출력
		
		feedbackDAO.changeProcess((Integer.parseInt(req.getParameter("idx"))));
		
		return null;
	}

}
