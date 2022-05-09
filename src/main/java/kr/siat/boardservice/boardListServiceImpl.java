package kr.siat.boardservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.model.BoardDTO;

public class boardListServiceImpl implements Service {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		list = boardDAO.List();
		
		req.setAttribute("boardList", list);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// 조회는 get방식으로 들어온다.
		// post 방식으로 들어올 때도 있을 수 있음을 숙지하고 일단 get 방식으로 구현
		
		if("GET".equals(req.getMethod())) {
			System.out.println("boardListServiceImpl GET 방식 진입 ");
			doGet(req, resp);
			return new ModelAndView("/bbs/list", false);
		}
		else
			return null;
	}

}
