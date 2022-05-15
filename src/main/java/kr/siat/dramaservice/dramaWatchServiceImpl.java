package kr.siat.dramaservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.MovieDTO;
import kr.siat.model.dramaDTO;

public class dramaWatchServiceImpl implements Service {

	private void doGET(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		System.out.println("drama WatchServiceImpl num by session : " + num);
		dramaDTO dramaDto = dramaDAO.selectbyDramaNum(num);
		
	//movieDAO.viewCountUpdate(movieDAO.ExtractViewCount(Integer.parseInt(num)), Integer.parseInt(num));
		req.setAttribute("dramawatch", dramaDto);

	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		if("GET".equals(req.getMethod())) {
			System.out.println("dramaWatchServiceImpl GET ��� ���� ");
			doGET(req, resp);
			return new ModelAndView("/drama/watchdrama", false);
		}
		else
			return null;
	}
}
