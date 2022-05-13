package dramaservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DramaModel.dramaDTO;
import boardservice.Service;
import controller.ModelAndView;

public class dramaListServiceImpl implements Service {


	
	private void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<dramaDTO> list = new ArrayList<dramaDTO>();
		list = dramaDAO.List();
		
		req.setAttribute("dramaList", list);

	}
	
	private void doPost(HttpServletRequest req, HttpServletResponse resp) {
	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// 조회는 get방식으로 들어온다.
		// post 방식으로 들어올 때도 있을 수 있음을 숙지하고 일단 get 방식으로 구현
		
		if("GET".equals(req.getMethod())) {
			System.out.println("dramaListServiceImpl GET 방식 진입 ");
			doGet(req, resp);
			return new ModelAndView("/drama/category", false);
		}
		else
			return null;
	}

}
