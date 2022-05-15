package kr.siat.movieservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.MovieDTO;

public class movieWatchServiceImpl implements Service {

	private void doGET(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		System.out.println("WatchServiceImpl num by session : " + num);
		MovieDTO movieDto = movieDAO.selectbyMovieNum(num);
		
	//movieDAO.viewCountUpdate(movieDAO.ExtractViewCount(Integer.parseInt(num)), Integer.parseInt(num));
		req.setAttribute("moviewatch", movieDto);

	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		if("GET".equals(req.getMethod())) {
			System.out.println("movieWatchServiceImpl GET ��� ���� ");
			doGET(req, resp);
			return new ModelAndView("/movie/watchmovie", false);
		}
		else
			return null;
	}

}
