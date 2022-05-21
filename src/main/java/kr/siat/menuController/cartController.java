package kr.siat.menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.cartservice.CartInfoServiceImpl;
import kr.siat.cartservice.CartMovieDeleteServiceImpl;
import kr.siat.cartservice.CartMovieInsertServiceImpl;
import kr.siat.controller.ModelAndView;
import kr.siat.dramaservice.dramaListServiceImpl;
import kr.siat.priceinfoservice.membershipCheckoutServiceImpl;

public class CartController implements Controller {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/cartInfo"))
			return new CartInfoServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/cartMovieInsert"))
			return new CartMovieInsertServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/cartMovieDelete"))
			return new CartMovieDeleteServiceImpl().request(req, resp);
		
		return null;
	}

}
