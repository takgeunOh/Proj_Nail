package movieservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;

public class movieInsertServiceImpl implements Service {

	//관리자 계정(아이디)로 로그인 한 사람만 접근 가능
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		
		return null;
	}

}
