package kr.siat.cartservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;

public class CartMovieDeleteServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// GET방식
		
		System.out.println("카트삭제서비스 진입 확인");
		System.out.println(Integer.parseInt(req.getParameter("cartNum")));
		
		movieCartDAO.deleteCartList(Integer.parseInt(req.getParameter("cartNum")));
		return null;
	}

}
