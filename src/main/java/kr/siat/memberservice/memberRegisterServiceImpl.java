package kr.siat.memberservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.model.MemberDTO;

public class memberRegisterServiceImpl implements Service{

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// doget, dopost로 나눠서 하면 될 듯
		
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		if("GET".equals(req.getMethod())) {
			// get 방식으로 들어오면 회원가입 페이지로 이동
			return new ModelAndView("member/register", false);
		} else if ("POST".equals(req.getMethod())) {
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			String userName = req.getParameter("userName");
			String userEmail = req.getParameter("userEmail");
			String userPassword = req.getParameter("userPassword");
			String userPhone = req.getParameter("userPhone");
			int userType = Integer.parseInt(req.getParameter("userType"));
			
			System.out.printf("%s, %s, %s, %s, %d\n", userName, userEmail, userPassword, userPhone, userType);
			
			if(memberDAO.existUserEmail(userEmail)) {
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter out;
				try {
					out = resp.getWriter();
					out.println("<script>");
			   		out.println("alert('이미 가입하신 이메일이 존재합니다.');");
			   		out.println("history.back();");
			   		out.println("</script>");
			   		out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			} else {
				MemberDTO dto = new MemberDTO(userName, userEmail, userPassword, userPhone, userType);
				memberDAO.register(dto);
				
				req.setAttribute("msg", "가입이 완료되었습니다. 로그인 페이지로 이동합니다.");
				
				return new ModelAndView("member/passCheck", false);
			}
		}
		
		
		return null;
	}

}
