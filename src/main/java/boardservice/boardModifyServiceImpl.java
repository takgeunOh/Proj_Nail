package boardservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ModelAndView;
import model.BoardDTO;

public class boardModifyServiceImpl implements Service {

	
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
			
		// ?��?��?��?�� ?��?�� dto ???��
		BoardDTO dto = boardDAO.selectbyBoardNum(modifyNum);
		req.setAttribute("boardaftermodify", dto);
		
	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			
			return new ModelAndView("bbs/modify", false);
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
			String password = boardDAO.selectbyBoardNum(modifyNum).getBoardPassword();
			
			if(password.equals(req.getParameter("modifyPassword"))) {
				doPost(req, resp);
				
				/*
				 * resp.setContentType("text/html; charset=utf-8"); PrintWriter out; try { out =
				 * resp.getWriter(); out.println("<script>");
				 * out.println("alert('?��?��?�� ?��료되?��?��?��?��.');"); // out.println("history.back();");
				 * out.println("</script>"); out.flush(); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */
				req.setAttribute("msg", "?��?��?�� ?��료되?��?��?��?��.");
				
				return new ModelAndView("bbs/passCheck", false);
			} else {
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter out;
				try {
					out = resp.getWriter();
					out.println("<script>");
			   		out.println("alert('비�?번호�? ?��치하�? ?��?��?��?��.');");
			   		out.println("history.back();");
			   		out.println("</script>");
			   		out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// req.setAttribute("message", "비�?번호�? ???��?��?��?��.");
				/*
				 * BoardDTO dto = boardDAO.selectbyBoardNum(modifyNum);
				 * req.setAttribute("boardaftermodify", dto); return new
				 * ModelAndView("bbs/detail", false);
				 */
				return null;
			}
		}
		else
			return null;
	}

}
