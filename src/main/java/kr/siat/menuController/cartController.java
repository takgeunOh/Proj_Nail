package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.cartservice.CartInfoServiceImpl;
import kr.siat.controller.ModelAndView;
import kr.siat.dramaservice.dramaListServiceImpl;

public class CartController implements Controller {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/cartInfo"))
			return new CartInfoServiceImpl().request(req, resp);
		
		return null;
	}

}
