package cartservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MovieModel.MovieDTO;
import boardservice.Service;
import controller.ModelAndView;

public class cartServiceImpl implements Service {

	
	private void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		list = movieDAO.List();
		
		req.setAttribute("movieList", list);


}
	private void doPost(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			return new ModelAndView("cart/cart", false);
		}
		else
		return null;
	}

}
