package com.koreait.a.command.review;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.ReviewDAO;

public class ReviewDeleteCommand implements ReviewCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		long no = Long.parseLong(request.getParameter("no"));
		
		ReviewDAO reviewDAO = sqlSession.getMapper(ReviewDAO.class);
		response.setContentType("text/html; charset=UTF-8");
		int result = reviewDAO.deleteReview(no);
		
		try {
			if(result != 0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('리뷰삭제 성공')");
				response.getWriter().println("location.href='memberMyPage.do'");
				response.getWriter().println("</script>");
			}else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('리뷰삭제 실패')");
				response.getWriter().println("location.href='memberMyPage.do'");
				response.getWriter().println("</script>");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
