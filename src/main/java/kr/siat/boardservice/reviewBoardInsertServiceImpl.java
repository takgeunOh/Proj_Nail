package kr.siat.boardservice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.siat.controller.ModelAndView;
import kr.siat.model.BoardDTO;

public class reviewBoardInsertServiceImpl implements Service {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String userEmail = req.getParameter("userEmail");
		String author = req.getParameter("user_name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String videoName = req.getParameter("videoName");
		
		System.out.println("리뷰게시판 DAO videoName : " + videoName);
		System.out.println("리뷰게시판 DAO email : " + userEmail);
		
		BoardDTO boardDTO = new BoardDTO(userEmail, author, title, content, videoName);
		boardDAO.insert(boardDTO);
	}

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		// GET방식, POSST방식
		
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			return new ModelAndView("reviewboard/insert", false);
		}
		else if("POST".equals(req.getMethod())){
			doPost(req, resp);
			return new ModelAndView("list.board", true);
		}
		else
			return null;
	}

}
