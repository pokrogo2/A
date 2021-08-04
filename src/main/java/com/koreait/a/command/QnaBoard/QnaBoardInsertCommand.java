package com.koreait.a.command.QnaBoard;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.QnaBoardDAO;
import com.koreait.a.dto.QnaBoardDTO;

public class QnaBoardInsertCommand implements QnaBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		QnaBoardDTO qnaBoard = new QnaBoardDTO();
		qnaBoard.setWriter(request.getParameter("writer"));
		qnaBoard.setTitle(request.getParameter("title"));
		qnaBoard.setContent(request.getParameter("content"));
		
		QnaBoardDAO qnsBoardDAO = sqlSession.getMapper(QnaBoardDAO.class);
		
		int result = qnsBoardDAO.qnaBoardInsert(qnaBoard);
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			if(result > 0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('새 게시글을 작성했습니다.')");
				response.getWriter().println("location.href='qnaBoardPage.do'");
				response.getWriter().println("</script>");
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('새 게시글을 작성하는 중에 오류가 발생했습니다.')");
				response.getWriter().println("history.back()");
				response.getWriter().println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
