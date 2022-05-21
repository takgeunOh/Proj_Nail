package kr.siat.boardservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.siat.controller.ModelAndView;
import kr.siat.model.BoardDTO;

public class reviewBoardModifyServiceImpl implements Service {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		BoardDTO dto = boardDAO.selectbyBoardNum(req.getParameter("num"));
		req.setAttribute("boardmodify", dto);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String modifyNum = req.getParameter("modifyNum");
		String modifyTitle = req.getParameter("modifyTitle");
		String modifyContent = req.getParameter("modifyContent");

			
			
		System.out.println("modifyService Post modifyNum : " + modifyNum);
		boardDAO.update(modifyTitle, modifyContent, Integer.parseInt(modifyNum));
			
		// 업데이트 이후 dto 저장
		BoardDTO dto = boardDAO.selectbyBoardNum(modifyNum);
		req.setAttribute("boardaftermodify", dto);
		
	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if("GET".equals(req.getMethod())) {
			System.out.println("수정 get 방식 진입");
			doGet(req, resp);
			
			return new ModelAndView("reviewboard/modify", false);
		}
		else if("POST".equals(req.getMethod())) {
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			String modifyNum = req.getParameter("modifyNum");
			// String password = boardDAO.selectbyBoardNum(modifyNum).getBoardPassword();
			
			doPost(req, resp);
				
				/*
				 * resp.setContentType("text/html; charset=utf-8"); PrintWriter out; try { out =
				 * resp.getWriter(); out.println("<script>");
				 * out.println("alert('수정이 완료되었습니다.');"); // out.println("history.back();");
				 * out.println("</script>"); out.flush(); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */
			req.setAttribute("msg", "수정이 완료되었습니다.");
				
			return new ModelAndView("reviewboard/passCheck", false);
			/*} else {
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
				
				req.setAttribute("message", "비밀번호가 틀렸습니다.");

				BoardDTO dto = boardDAO.selectbyBoardNum(modifyNum);
				req.setAttribute("boardaftermodify", dto); return new
				ModelAndView("bbs/detail", false);
				
				return null;
			*/
		}
		return null;
	}
}
