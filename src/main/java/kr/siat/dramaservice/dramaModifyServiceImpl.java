package kr.siat.dramaservice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.boardservice.Service;
import kr.siat.controller.ModelAndView;
import kr.siat.model.MovieDTO;
import kr.siat.model.dramaDTO;

public class dramaModifyServiceImpl implements Service {

	private void doGET(HttpServletRequest req, HttpServletResponse resp){
		String num = req.getParameter("num");
		System.out.println("dramamodifyServiceImpl num by session : " + num);
		
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		dramaDTO dto = dramaDAO.selectbyDramaNum(num);
		req.setAttribute("dramamodify", dto);

	}
	
	
	private void dopost(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String modifyNum = req.getParameter("modifyNum");
		String modifyGenre = req.getParameter("modifyGenre");
		String modifyTitle = req.getParameter("modifyTitle");
		String modifyContent = req.getParameter("modifyContent");
		String modifyDirector = req.getParameter("modifyDirector");
		String modifyYear = req.getParameter("modifyYear");
		String modifyPrice = req.getParameter("modifyPrice");
		String modifyCountry = req.getParameter("modifyCountry");
		String modifyCompany = req.getParameter("modifyCompany");
		String modifyHide = req.getParameter("modifyHide");
		String modifyAge = req.getParameter("modifyAge");
		
		
		System.out.println("modifyService Post modifyNum : " + modifyNum);
		dramaDAO.update(modifyTitle, modifyContent,modifyGenre,modifyDirector,modifyYear,modifyCountry,modifyCompany,Integer.parseInt(modifyPrice), Integer.parseInt(modifyHide),Integer.parseInt(modifyAge),Integer.parseInt(modifyNum));
			
		// �뾽�뜲�씠�듃 �씠�썑 dto ���옣
		dramaDTO dto = dramaDAO.selectbyDramaNum(modifyNum);
		req.setAttribute("dramaaftermodify", dto);
		
		
	}
	
	
	
	
	
	
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		if("GET".equals(req.getMethod())) {
			doGET(req, resp);			
			return new ModelAndView("/drama/dramamodify", false);
		}else if("POST".equals(req.getMethod())) {
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			String modifyNum = req.getParameter("modifyNum");
			dopost(req, resp);
			return new ModelAndView("drama/detail", false);
			
		}
	
		return null;
	}

}
