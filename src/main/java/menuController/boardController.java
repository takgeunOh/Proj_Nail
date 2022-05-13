package menuController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardservice.boardDeleteServiceImpl;
import boardservice.boardDetailServiceImpl;
import boardservice.boardInsertServiceImpl;
import boardservice.boardListServiceImpl;
import boardservice.boardModifyServiceImpl;
import controller.ModelAndView;

public class boardController implements Controller{

	// 기능 컨트롤러?��?��?�� ?��비스�? ?��?��?�� ?�� ?��?���?
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getAttribute("service").equals("/list"))
			return new boardListServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/insert"))
			return new boardInsertServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/detail"))
			return new boardDetailServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/modify"))
			return new boardModifyServiceImpl().request(req, resp);
		else if(req.getAttribute("service").equals("/delete"))
			return new boardDeleteServiceImpl().request(req, resp);
		
		return null;
	}

}
