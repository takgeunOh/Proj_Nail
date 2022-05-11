package kr.siat.controller;

import java.util.HashMap;

import kr.siat.menuController.Controller;
import kr.siat.menuController.feedbackBoardController;
import kr.siat.menuController.reviewBoardController;
import kr.siat.menuController.memberController;

public class HandlerMapping {
	
	HashMap<String, Controller> mapping = new HashMap<String, Controller>();
	{
		mapping.put("/reviewboard", new reviewBoardController());
		mapping.put("/member", new memberController());
		mapping.put("/feedbackboard", new feedbackBoardController());
	}
	
	public Controller getController(String menu) {
		return mapping.get(menu);
	}
}
