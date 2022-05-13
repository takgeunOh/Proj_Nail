package menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MovieModel.MovieDAO;
import controller.ModelAndView;
import model.BoardDAO;
import DramaModel.dramaDAO;


public interface Controller {
	BoardDAO boardDAO = new BoardDAO();
	MovieDAO movieDAO = new MovieDAO();
	dramaDAO dramaDAO = new dramaDAO();
	ModelAndView request(HttpServletRequest req, HttpServletResponse resp);
}
