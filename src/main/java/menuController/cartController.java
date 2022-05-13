package menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartservice.cartServiceImpl;
import controller.ModelAndView;
import dramaservice.dramaListServiceImpl;

public class cartController implements Controller {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/cart"))
			return new cartServiceImpl().request(req, resp);
		
		return null;
	}

}
