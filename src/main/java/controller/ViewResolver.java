package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	
	private String prefix;
	private String suffix;
	
	public void forward(HttpServletRequest req, HttpServletResponse resp, ModelAndView mav) {
		String viewName = mav.getViewName();
		boolean isRedirect = mav.isRedirect();
		
		System.out.println("ViewResolver viewName : " + viewName);
		
		if(isRedirect) {
			
			try {
				resp.sendRedirect(viewName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else {
			prefix = "/WEB-INF/views/";
			suffix = ".jsp";
			RequestDispatcher view = req.getRequestDispatcher(prefix + viewName + suffix);
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
