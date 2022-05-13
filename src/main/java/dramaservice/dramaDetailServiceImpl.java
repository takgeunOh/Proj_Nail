package dramaservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DramaModel.dramaDTO;
import MovieModel.MovieDTO;
import boardservice.Service;
import controller.ModelAndView;

public class dramaDetailServiceImpl implements Service {

	
	private void doGET(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		System.out.println("detailServiceImpl num by session : " + num);
		dramaDTO dramaDto = dramaDAO.selectbyDramaNum(num);
		
	//movieDAO.viewCountUpdate(movieDAO.ExtractViewCount(Integer.parseInt(num)), Integer.parseInt(num));
		req.setAttribute("dramadetail", dramaDto);

	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		if("GET".equals(req.getMethod())) {
			System.out.println("dramaDetailServiceImpl GET 방식 진입 ");
			doGET(req, resp);
			return new ModelAndView("/drama/detail", false);
		}
		else
			return null;
	}
}
