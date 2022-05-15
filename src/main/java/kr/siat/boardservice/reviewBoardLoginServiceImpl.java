package kr.siat.boardservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.siat.controller.ModelAndView;
import kr.siat.model.MemberDAO;
import kr.siat.model.MemberDTO;

public class reviewBoardLoginServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		// 댓글에서 로그인하기 클릭 시 GET방식으로 진입됨.
		// GET 방식 진입하여 입력폼 작성 후 다시 POST방식으로 진입되어 처리
		
		
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
					session.setAttribute("user_type", dto.getUserType());
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
