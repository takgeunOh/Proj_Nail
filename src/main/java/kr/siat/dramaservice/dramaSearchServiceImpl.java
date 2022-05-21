package kr.siat.dramaservice;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;

import kr.siat.model.dramaDTO;

public class dramaSearchServiceImpl implements Service {

	
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		ArrayList<dramaDTO> list = new ArrayList<dramaDTO>();
		String searchData = req.getParameter("searchtext");
		
		System.out.println(" >> dramaSearchServiceImpl searchData : " + searchData);
		
		list = dramaDAO.search(searchData);
		
		req.setAttribute("searchList", list);

		return new ModelAndView("/drama/search", false);
	}

	

}
