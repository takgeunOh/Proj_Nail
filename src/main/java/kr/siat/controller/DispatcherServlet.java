package kr.siat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.menuController.Controller;

public class DispatcherServlet extends HttpServlet{
	
	private HandlerMapping handlerMapping = new HandlerMapping();
	private ViewResolver viewResolver = new ViewResolver();
	
	private void process(HttpServletRequest req, HttpServletResponse resp) {
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		
		int startIndex = ctxPath.length();
		int endIndex = reqUri.indexOf(".");
		
		String path = reqUri.substring(startIndex, endIndex);
		System.out.println("디스패처서블릿 path : " + path);
		String menu = path.substring(0,path.indexOf("/", 1));
		String function = path.substring(path.indexOf("/",1));
		
		System.out.println("DispatcherServlet menu : " + menu);						// 정상 출력 (/bbs)
		System.out.println("DIspatcherServlet function : " + function);					// 정상 출력 (/list)
		
		req.setAttribute("service", function);
		
		Controller controller = handlerMapping.getController(menu);
		
		if(controller!=null) {
			ModelAndView modelAndView = controller.request(req, resp);
			// System.out.println(modelAndView.getViewName());							// 정상 출력 /bbs/list
			if(modelAndView!=null) {
				viewResolver.forward(req, resp, modelAndView);
			} else {
				System.out.println("ModelAndView가 null입니다.");
			}
		}
		else {
			System.out.println("controller가 null입니다.");
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
