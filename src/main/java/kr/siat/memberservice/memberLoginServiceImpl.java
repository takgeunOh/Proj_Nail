package kr.siat.memberservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.menuController.Controller;

public class memberLoginServiceImpl implements Controller {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		
		return new ModelAndView("member/login", false);
	}

}
