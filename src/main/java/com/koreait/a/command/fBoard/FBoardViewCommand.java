package com.koreait.a.command.fBoard;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.FBoardDAO;
import com.koreait.a.dto.FBoard;

public class FBoardViewCommand implements FBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		long no = Long.parseLong(request.getParameter("no"));
		String loginUser = request.getParameter("loginUser");
		
		FBoardDAO fBoardDAO = sqlSession.getMapper(FBoardDAO.class);
		// 공지사항 불러오기
		FBoard fBoard = fBoardDAO.fBoardView(no);
		// 조회수 중가
		if(fBoard.getWriter() != loginUser) {
			int count = fBoardDAO.fBoardHitUp(no);
			fBoard.setHit(fBoard.getHit() + 1);
		}
		
		response.setCharacterEncoding("UTF-8");
		try {
			if (fBoard != null) {
				model.addAttribute("fBoard", fBoard);
			} else {
					response.getWriter().println("<script>");
					response.getWriter().println("alert('자유게시판의 글을 불러오는데 오류가 발생했습니다.')");
					response.getWriter().println("location.href='fBoardPage.do'");
					response.getWriter().println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
			
			

	}

}
