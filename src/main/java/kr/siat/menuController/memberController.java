package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.memberservice.memberLoginServiceImpl;
import kr.siat.memberservice.memberRegisterServiceImpl;

public class memberController implements Controller{

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/register"))
			return new memberRegisterServiceImpl().request(req, resp);
		if(req.getAttribute("service").equals("/login"))
			return new memberLoginServiceImpl().request(req, resp);
		return null;
	}

}
