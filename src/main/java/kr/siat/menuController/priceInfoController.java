package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.memberservice.memberLoginServiceImpl;
import kr.siat.memberservice.memberRegisterServiceImpl;
import kr.siat.priceinfoservice.membershipInfoServiceImpl;

public class priceInfoController implements Controller {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/membershipInfo"))
			return new membershipInfoServiceImpl().request(req, resp);
		/*
		 * else if(req.getAttribute("service").equals("/downloadInfo")) return new
		 * memberLoginServiceImpl().request(req, resp);
		 */
		
		return null;
	}

}
