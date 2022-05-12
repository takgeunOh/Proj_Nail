package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartservice.cartServiceImpl;
import dramaservice.dramaListServiceImpl;
import kr.siat.controller.ModelAndView;

public class cartController implements Controller {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/cart"))
			return new cartServiceImpl().request(req, resp);
		
		return null;
	}

}
