package kr.siat.controller;

import java.util.HashMap;

import kr.siat.menuController.Controller;
import kr.siat.menuController.CartController;
import kr.siat.menuController.dramaController;
import kr.siat.menuController.feedbackBoardController;
import kr.siat.menuController.memberController;
import kr.siat.menuController.movieController;
import kr.siat.menuController.priceInfoController;
import kr.siat.menuController.reviewBoardController;

public class HandlerMapping {
	
	HashMap<String, Controller> mapping = new HashMap<String, Controller>();
	{
		mapping.put("/movie", new movieController());  //��ȭ
		mapping.put("/drama", new dramaController()); //���
		mapping.put("/cart", new CartController()); //īƮ
		mapping.put("/reviewboard", new reviewBoardController());
		mapping.put("/feedbackboard", new feedbackBoardController());
		mapping.put("/member", new memberController());
		mapping.put("/priceInfo", new priceInfoController());
	}
	
	public Controller getController(String menu) {
		System.out.println("menu : " + menu);
		return mapping.get(menu);
	}
}
