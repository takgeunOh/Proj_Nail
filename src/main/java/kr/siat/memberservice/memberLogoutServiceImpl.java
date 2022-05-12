package kr.siat.memberservice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;

public class memberLogoutServiceImpl implements Service {
	ModelAndView mav;
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("GET")) {
			HttpSession session = req.getSession();
			session.invalidate(); // 세션 로그아웃
			
			/*
			 * resp.setContentType("text/html; charset=utf-8"); PrintWriter out; try { out =
			 * resp.getWriter(); out.println("<script>");
			 * out.println("alert('로그아웃이 완료되었습니다.');"); // out.println("history.back();");
			 * out.println("</script>"); out.close(); } catch (IOException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			
			// mav = new ModelAndView(req.getContextPath() + "/", true);
			return new ModelAndView(req.getContextPath() + "/redirect.jsp", true);
		} else if(req.getMethod().equals("POST")) {
			mav = new ModelAndView("/", true);
		}
		return mav;
	}

}
