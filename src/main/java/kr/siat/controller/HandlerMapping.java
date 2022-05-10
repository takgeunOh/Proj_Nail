package kr.siat.controller;

import java.util.HashMap;

import kr.siat.menuController.Controller;
import kr.siat.menuController.boardController;
import kr.siat.menuController.movieController;

public class HandlerMapping {
	
	HashMap<String, Controller> mapping = new HashMap<String, Controller>();
	{
		mapping.put("/bbs", new boardController());   //게시판
		mapping.put("/movie", new movieController());  //영화
		//mapping.put("/movie", new movieController()); //드라마
		//mapping.put("/movie", new movieController()); //로그인
	}
	
	public Controller getController(String menu) {
		return mapping.get(menu);
	}
}
