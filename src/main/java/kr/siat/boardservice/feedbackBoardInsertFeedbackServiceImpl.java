package kr.siat.boardservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.siat.controller.ModelAndView;
import kr.siat.model.FeedbackDTO;

public class feedbackBoardInsertFeedbackServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		// System.out.println("피드백글 작성 서비스에서의 email : " +session.getAttribute("user_email"));		// 정상 출력
		System.out.println("피드백글 작성 서비스에서의 진입방식 : " + req.getMethod());
		if("GET".equals(req.getMethod())) {
			return new ModelAndView("feedbackboard/insert", false);
		} else {
			
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			// String userEmail = req.getParameter("user_email");
			String userEmail = req.getParameter("user_email");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String type = req.getParameter("queryType");
			
			feedbackDAO.insert(new FeedbackDTO(userEmail, type, title, content));
			
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = resp.getWriter();
				out.println("<script>alert('문의글 작성이 완료되었습니다.');");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return new ModelAndView("list.board", true);
		}
	}

}
