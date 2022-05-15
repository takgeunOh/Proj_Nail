package kr.siat.movieservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.MovieDTO;

public class movieListServiceImpl implements Service {

	
	
	private void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		list = movieDAO.List();
		
		req.setAttribute("movieList", list);

	}
	
	private void doPost(HttpServletRequest req, HttpServletResponse resp) {
	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// ��ȸ�� get������� ���´�.
		// post ������� ���� ���� ���� �� ������ �����ϰ� �ϴ� get ������� ����
		
		if("GET".equals(req.getMethod())) {
			System.out.println("movieListServiceImpl GET ��� ���� ");
			doGet(req, resp);
			return new ModelAndView("/movie/category", false);
		}
		else
			return null;
	}

}
