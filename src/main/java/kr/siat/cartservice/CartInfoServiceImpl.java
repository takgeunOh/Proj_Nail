package kr.siat.cartservice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.CartDTO;
import kr.siat.model.MovieDTO;

public class CartInfoServiceImpl implements Service {

	
	private void doGet(HttpServletRequest req, HttpServletResponse resp) {
		List<CartDTO> list = cartDAO.getList();
		
		req.setAttribute("cartList", list);

	}
	private void doPost(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("카트정보 서비스 진입 방식 : " + req.getMethod());
		
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			return new ModelAndView("cart/cartInfo", false);
		}
		else
			return null;
	}

}
