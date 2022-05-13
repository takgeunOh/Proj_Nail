package boardservice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ModelAndView;

public class boardDeleteServiceImpl implements Service {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String deleteNum = req.getParameter("deleteNum");
		
		boardDAO.delete(deleteNum);
	}
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("boardDeleteServiceImpl ì§„ì…ë°©ì‹ : " + req.getMethod());
		
		if("GET".equals(req.getMethod())) {
			
			return null;
		}
		else if("POST".equals(req.getMethod())) {
			String deleteNum = req.getParameter("deleteNum");
			String password = boardDAO.selectbyBoardNum(deleteNum).getBoardPassword();
			
			if(password.equals(req.getParameter("deletePassword"))) {
				doPost(req, resp);
				
				req.setAttribute("msg", "?‚­? œê°? ?™„ë£Œë˜?—ˆ?Šµ?‹ˆ?‹¤.");
				return new ModelAndView("bbs/passCheck", false);
			} else {
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter out;
				try {
					out = resp.getWriter();
					out.println("<script>");
			   		out.println("alert('ë¹„ë?ë²ˆí˜¸ê°? ?¼ì¹˜í•˜ì§? ?•Š?Šµ?‹ˆ?‹¤.');");
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
