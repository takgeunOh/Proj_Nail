package kr.siat.boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.siat.controller.ModelAndView;
import kr.siat.model.CommentDTO;

public class ReviewBoardInsertCommentServiceImpl implements Service {

	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// get 방식으로 들어오는 일은 없을 것 같다.
		
		if("GET".equals(req.getMethod())) {
			System.out.println("리뷰게시판 댓글 서비스 GET 방식 진입");
			
			return null;
		} else if ("POST".equals(req.getMethod())) {
			
			// System.out.println("리뷰게시판 댓글서비스 POST 방식 진입");
			// System.out.println("리뷰게시판 댓글서비스 content 넘어왔는지 확인 >> " + req.getParameter("content"));		// 정상 출력 확인완료
			System.out.printf("리뷰댓글서비스 데이터 넘어왔는지 확인 >> %s %s %s\n", req.getParameter("boardNum"), req.getParameter("userEmail"),
					req.getParameter("content"));
			
			int boardNum = Integer.parseInt(req.getParameter("boardNum"));
			String userEmail = req.getParameter("userEmail");
			String commentContent = req.getParameter("content");
			System.out.println("리뷰댓글서비스 유저이메일 확인 >> " + userEmail);
			
			CommentDTO dto = new CommentDTO(boardNum, userEmail, commentContent);
			commentDAO.commentInsert(dto);
			
			
			// return new ModelAndView("/reviewboard/insertComment", false);
			return null;
		}
		
		return null;
	}

}
