package kr.siat.priceinfoservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.cartservice.Service;
import kr.siat.controller.ModelAndView;

public class membershipCheckoutServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		
		System.out.println("구독결제서비스 진입 방식 : " + req.getMethod());
		/* System.out.println("구독결제서비스 번호 : " + req.getParameter("choice")); */
		
		
		return new ModelAndView("/priceInfo/checkout", false);
	}

}
