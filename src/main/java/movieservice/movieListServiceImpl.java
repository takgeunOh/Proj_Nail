package movieservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MovieModel.MovieDTO;
import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;

public class movieListServiceImpl implements Service {

	
	
	private void doGet() {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		list = movieDAO.List();
		
		

	}
	
	private void doPost() {
		

	}
	
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		return null;
	}

}
