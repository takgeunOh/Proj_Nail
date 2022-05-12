package kr.siat.memberservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.siat.controller.ModelAndView;
import kr.siat.menuController.Controller;
import kr.siat.model.MemberDAO;
import kr.siat.model.MemberDTO;

public class memberLoginServiceImpl implements Controller {
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("GET")) {
			return new ModelAndView("member/login", false);
		} else if(req.getMethod().equals("POST")) {
			System.out.println("memberLoginServiceImpl POST 방식 진입 확인");
			HttpSession session = req.getSession();
			
			
			// 입력 받은 값들
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			System.out.println("memberLoginServiceImpl 입력email : " + email);
			System.out.println("memberLoginServiceImpl 입력password : " + password);
			
			
			// 데이터베이스에 저장된 계정들의 정보들
			ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
			MemberDAO dao = new MemberDAO();
			list = dao.list();
			
			
			for(MemberDTO dto : list) {
				System.out.println("memberLoginServiceImpl 데이터베이스 email : " + dto.getUserEmail());
				System.out.println("memberLoginServiceImpl 데이터베이스 password : " + dto.getUserPassword());
				if(email.equals(dto.getUserEmail()) && password.equals(dto.getUserPassword())) {
					System.out.println(">>> email과 password 일치");
					session.setAttribute("user_email", email);
					session.setAttribute("user_name", dto.getUserName());
					System.out.println("memberLogin session name : " + dto.getUserName());
					
					/*
					 * resp.setContentType("text/html; charset=utf-8"); PrintWriter out; try { out =
					 * resp.getWriter(); out.println("<script>"); out.println("alert('로그인 성공');");
					 * // out.println("history.back();"); out.println("</script>"); out.close(); }
					 * catch (IOException e) { // TODO Auto-generated catch block
					 * e.printStackTrace(); }
					 */
					
					// return new ModelAndView(req.getContextPath() , true);
					return new ModelAndView(req.getContextPath() + "/redirect.jsp", true);
				}		
			}
			
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
		return null;
	}
}
