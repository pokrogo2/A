package com.koreait.a.command.fBoard;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.FBoardDAO;

public class FBoardDeleteCommand implements FBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		long no = Long.parseLong(request.getParameter("no"));
		
		FBoardDAO fBoardDAO = sqlSession.getMapper(FBoardDAO.class);
		// 자유게시판 삭제
		int result = fBoardDAO.fBoardDelete(no);
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			if (result > 0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('게시글을 삭제했습니다.')");
				response.getWriter().println("location.href='fBoardPage.do'");
				response.getWriter().println("</script>");
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('게시글을 삭제하는 중에 오류가 발생했습니다.')");
				response.getWriter().println("history.back()");
				response.getWriter().println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
			
			

	}

}
