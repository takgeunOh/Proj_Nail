package boardservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ModelAndView;
import model.BoardDTO;

public class boardListServiceImpl implements Service {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		list = boardDAO.List();
		
		req.setAttribute("boardList", list);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// 조회?�� get방식?���? ?��?��?��?��.
		// post 방식?���? ?��?��?�� ?��?�� ?��?�� ?�� ?��?��?�� ?���??���? ?��?�� get 방식?���? 구현
		
		if("GET".equals(req.getMethod())) {
			System.out.println("boardListServiceImpl GET 방식 진입 ");
			doGet(req, resp);
			return new ModelAndView("/bbs/list", false);
		}
		else
			return null;
	}

}
///Proj_Nail/WebContent/WEB-INF/WEB-INF/views/bbs/list.jsp