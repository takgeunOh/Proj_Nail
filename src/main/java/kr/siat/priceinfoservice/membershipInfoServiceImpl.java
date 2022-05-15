package kr.siat.priceinfoservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;

public class membershipInfoServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		// GET 방식으로 넘어오는 것만 생각하자. (메뉴에서 클릭하기만 할거니깐)
		
		return new ModelAndView("/priceInfo/membershipInfo", false);
	}

}
