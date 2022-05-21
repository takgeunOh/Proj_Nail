package kr.siat.dramaservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.dramaDTO;

public class dramaListServiceImpl implements Service {


	
	private void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<dramaDTO> list = new ArrayList<dramaDTO>();
		list = dramaDAO.List();		
		req.setAttribute("dramaList", list);

	}
	
	
	private void doPost(HttpServletRequest req, HttpServletResponse resp) {
	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// 占쏙옙회占쏙옙 get占쏙옙占쏙옙占쏙옙占� 占쏙옙占승댐옙.
		// post 占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹곤옙 占싹댐옙 get 占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙
		
		if("GET".equals(req.getMethod())) {
			System.out.println("dramaListServiceImpl GET 占쏙옙占� 占쏙옙占쏙옙 ");
			doGet(req, resp);
			return new ModelAndView("/drama/category", false);
		}
		else
			return null;
	}

}
