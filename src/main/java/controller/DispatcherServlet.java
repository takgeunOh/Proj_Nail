package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menuController.Controller;

public class DispatcherServlet extends HttpServlet{
	
	private HandlerMapping handlerMapping = new HandlerMapping();
	private ViewResolver viewResolver = new ViewResolver();
	
	private void process(HttpServletRequest req, HttpServletResponse resp) {
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		
		int startIndex = ctxPath.length();
		int endIndex = reqUri.indexOf(".");
		
		String path = reqUri.substring(startIndex, endIndex);
		String menu = path.substring(0,path.indexOf("/", 1));
		String function = path.substring(path.indexOf("/",1));
		
		System.out.println("DispatcherServlet menu : " + menu);						// ?†ï?ÉÅ Ï∂úÎ†• (/bbs)
		System.out.println("DIspatcherServlet function : " + function);					// ?†ï?ÉÅ Ï∂úÎ†• (/list)
		
		req.setAttribute("service", function);
		
		Controller controller = handlerMapping.getController(menu);
		
		if(controller!=null) {
			ModelAndView modelAndView = controller.request(req, resp);
			// System.out.println(modelAndView.getViewName());							// ?†ï?ÉÅ Ï∂úÎ†• /bbs/list
			if(modelAndView!=null) {
				viewResolver.forward(req, resp, modelAndView);
			} else {
				System.out.println("ModelAndViewÍ∞? null?ûÖ?ãà?ã§.");
			}
		}
		else {
			System.out.println("controllerÍ∞? null?ûÖ?ãà?ã§.");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
}
