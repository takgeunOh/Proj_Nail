package controller;

import java.util.HashMap;

import menuController.Controller;
import menuController.boardController;
import menuController.cartController;
import menuController.dramaController;
import menuController.movieController;

public class HandlerMapping {
	
	HashMap<String, Controller> mapping = new HashMap<String, Controller>();
	{
		mapping.put("/bbs", new boardController());   //게시판
		mapping.put("/movie", new movieController());  //영화
		mapping.put("/drama", new dramaController()); //드라마
		mapping.put("/cart", new cartController()); //카트
	}
	
	public Controller getController(String menu) {
		return mapping.get(menu);
	}
}
