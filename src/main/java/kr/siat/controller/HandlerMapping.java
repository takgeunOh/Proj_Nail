package kr.siat.controller;

import java.util.HashMap;

import kr.siat.menuController.Controller;
import kr.siat.menuController.boardController;

public class HandlerMapping {
	
	HashMap<String, Controller> mapping = new HashMap<String, Controller>();
	{
		mapping.put("/bbs", new boardController());
	}
	
	public Controller getController(String menu) {
		return mapping.get(menu);
	}
}
