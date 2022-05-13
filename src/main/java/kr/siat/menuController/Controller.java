package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MovieModel.MovieDAO;
import kr.siat.controller.ModelAndView;
import kr.siat.model.BoardDAO;
import DramaModel.dramaDAO;


public interface Controller {
	BoardDAO boardDAO = new BoardDAO();
	MovieDAO movieDAO = new MovieDAO();
	dramaDAO dramaDAO = new dramaDAO();
	ModelAndView request(HttpServletRequest req, HttpServletResponse resp);
}
