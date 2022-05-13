package menuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardservice.boardDeleteServiceImpl;
import boardservice.boardDetailServiceImpl;
import boardservice.boardInsertServiceImpl;
import boardservice.boardListServiceImpl;
import boardservice.boardModifyServiceImpl;
import controller.ModelAndView;
import dramaservice.dramaDetailServiceImpl;
import dramaservice.dramaInsertServiceImpl;
import dramaservice.dramaListServiceImpl;
import dramaservice.dramaWatchServiceImpl;

public class dramaController implements Controller {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/category"))
			return new dramaListServiceImpl().request(req, resp);
		
		else if(req.getAttribute("service").equals("/detail"))
			return new dramaDetailServiceImpl().request(req, resp);
		
		else if(req.getAttribute("service").equals("/watchdrama"))
			return new dramaWatchServiceImpl().request(req, resp);
		
		else if(req.getAttribute("service").equals("/modify"))
			return new boardModifyServiceImpl().request(req, resp);
		
		else if(req.getAttribute("service").equals("/insert"))
			return new dramaInsertServiceImpl().request(req, resp);
		
		return null;
	}

}
