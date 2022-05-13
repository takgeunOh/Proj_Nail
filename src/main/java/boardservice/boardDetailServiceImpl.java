package boardservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ModelAndView;
import model.BoardDTO;

public class boardDetailServiceImpl implements Service {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		System.out.println("detailServiceImpl num by session : " + num);
		BoardDTO boardDto = boardDAO.selectbyBoardNum(num);
		
		boardDAO.viewCountUpdate(boardDAO.ExtractViewCount(Integer.parseInt(num)), Integer.parseInt(num));
		req.setAttribute("boarddetail", boardDto);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// ?��?��조회?�� get방식?���? ?��?��?��?��.
		// post 방식?���? ?��?��?�� ?��?�� ?��?�� ?�� ?��?��?�� ?���??���? ?��?�� get 방식?���? 구현
		
		if("GET".equals(req.getMethod())) {
			System.out.println("boardDetailServiceImpl GET 방식 진입 ");
			doGet(req, resp);
			return new ModelAndView("/bbs/detail", false);
		}
		else if("POST".equals(req.getMethod())) {
			System.out.println("boardDetailServiceImple POST 방식 진입(?��?��?�� 마쳤?�� ?��)");
			return new ModelAndView("detail.board", true);
		}
		
		return null;
	}

}
