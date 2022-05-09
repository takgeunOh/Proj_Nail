package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MovieModel.MovieDAO;
import kr.siat.controller.ModelAndView;
import kr.siat.model.BoardDAO;

public interface Controller {
	BoardDAO boardDAO = new BoardDAO();
	MovieDAO movieDAO = new MovieDAO();
	ModelAndView request(HttpServletRequest req, HttpServletResponse resp);
}
