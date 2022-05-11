package movieservice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MovieModel.MovieDTO;
import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.BoardDTO;

public class movieModifyServiceImpl implements Service {

	
	
	//관리자만 접근 가능
	
	private void doget(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		MovieDTO dto = movieDAO.selectbyMovieNum(req.getParameter("num"));
		req.setAttribute("moviemodify", dto);

	}
	
	
	private void dopost(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		
		
		
	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		if("GET".equals(req.getMethod())) {
			doget(req, resp);
			
			return new ModelAndView("movie/modify", false);
		}
		return null;
	}

}
