package movieservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardservice.Service;
import controller.ModelAndView;

public class movieDisableServiceImpl implements Service {
	
	//판권 만료시 비활성화 시키는 서비스
	//역시 관리자만 접근 가능
	//이를 활성화  좋아요 빼고 다른 버튼들은 비활성화
	// 우선순위 나중에
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
