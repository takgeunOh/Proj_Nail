package movieservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MovieModel.MovieDTO;
import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.BoardDTO;

public class movieDetailServiceImpl implements Service {

	
	private void doGET(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		System.out.println("detailServiceImpl num by session : " + num);
		MovieDTO movieDto = movieDAO.selectbyMovieNum(num);
		
	//	movieDAO.viewCountUpdate(movieDAO.ExtractViewCount(Integer.parseInt(num)), Integer.parseInt(num));
		req.setAttribute("moviedetail", movieDto);

	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		if("GET".equals(req.getMethod())) {
			System.out.println("movieDetailServiceImpl GET 방식 진입 ");
			doGET(req, resp);
			return new ModelAndView("/movie/detail", false);
		}
		else
			return null;
	}

}
