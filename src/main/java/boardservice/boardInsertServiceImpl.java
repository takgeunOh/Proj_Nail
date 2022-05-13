package boardservice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ModelAndView;
import model.BoardDTO;

public class boardInsertServiceImpl implements Service {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String password = req.getParameter("password");
		String content = req.getParameter("content");
		
		BoardDTO boardDTO = new BoardDTO(author, title, content, password);
		boardDAO.insert(boardDTO);
	}

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		// GET방식, POSST방식
		
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			return new ModelAndView("bbs/insert", false);
		}
		else if("POST".equals(req.getMethod())){
			doPost(req, resp);
			return new ModelAndView("list.board", true);
		}
		else
			return null;
	}

}
