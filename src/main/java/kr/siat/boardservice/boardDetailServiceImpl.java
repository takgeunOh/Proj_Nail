package kr.siat.boardservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.siat.controller.ModelAndView;
import kr.siat.model.BoardDTO;

public class boardDetailServiceImpl implements Service {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		System.out.println("detailServiceImpl num by session : " + num);
		BoardDTO boardDto = boardDAO.selectbyBoardNum(num);
		
		boardDAO.viewCountUpdate(boardDAO.ExtractViewCount(Integer.parseInt(num)), Integer.parseInt(num));
		req.setAttribute("boarddetail", boardDto);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// 상세조회는 get방식으로 들어온다.
		// post 방식으로 들어올 때도 있을 수 있음을 숙지하고 일단 get 방식으로 구현
		
		if("GET".equals(req.getMethod())) {
			System.out.println("boardDetailServiceImpl GET 방식 진입 ");
			doGet(req, resp);
			return new ModelAndView("/bbs/detail", false);
		}
		else if("POST".equals(req.getMethod())) {
			System.out.println("boardDetailServiceImple POST 방식 진입(수정을 마쳤을 때)");
			return new ModelAndView("detail.board", true);
		}
		
		return null;
	}

}
