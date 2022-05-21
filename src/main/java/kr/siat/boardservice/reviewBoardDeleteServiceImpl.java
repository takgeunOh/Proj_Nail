package kr.siat.boardservice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.siat.controller.ModelAndView;

public class reviewBoardDeleteServiceImpl implements Service {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String deleteNum = req.getParameter("deleteNum");
		
		boardDAO.delete(deleteNum);
	}
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		System.out.println("boardDeleteServiceImpl 진입방식 : " + req.getMethod());
		
		if("GET".equals(req.getMethod())) {
			
			return null;
		}
		else if("POST".equals(req.getMethod())) {
			// String deleteNum = req.getParameter("deleteNum");
			String deleteEmail = req.getParameter("deleteEmail");
			
			if(deleteEmail.equals(session.getAttribute("user_email"))) {
				doPost(req, resp);
				
				req.setAttribute("msg", "삭제가 완료되었습니다.");
				return new ModelAndView("reviewboard/passCheck", false);
			} else {
				req.setAttribute("msg", "이메일 입력이 잘못 되었습니다. 다시 확인해주세요.");
				return new ModelAndView("reviewboard/passCheck", false);
			}
		}
		
		return null;
	}

}
