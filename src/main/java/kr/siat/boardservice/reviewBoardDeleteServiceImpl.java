package kr.siat.boardservice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;

public class reviewBoardDeleteServiceImpl implements Service {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String deleteNum = req.getParameter("deleteNum");
		
		boardDAO.delete(deleteNum);
	}
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("boardDeleteServiceImpl 진입방식 : " + req.getMethod());
		
		if("GET".equals(req.getMethod())) {
			
			return null;
		}
		else if("POST".equals(req.getMethod())) {
			String deleteNum = req.getParameter("deleteNum");
			String password = boardDAO.selectbyBoardNum(deleteNum).getBoardPassword();
			
			if(password.equals(req.getParameter("deletePassword"))) {
				doPost(req, resp);
				
				req.setAttribute("msg", "삭제가 완료되었습니다.");
				return new ModelAndView("reviewboard/passCheck", false);
			} else {
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter out;
				try {
					out = resp.getWriter();
					out.println("<script>");
			   		out.println("alert('비밀번호가 일치하지 않습니다.');");
			   		out.println("history.back();");
			   		out.println("</script>");
			   		out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		}
		else
			return null;
	}

}
