package com.koreait.a.command.QnaBoard;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.QnaBoardDAO;

public class QnaBoardDeleteCommand implements QnaBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		long no = Long.parseLong(request.getParameter("no"));
		
		QnaBoardDAO qnaBoardDAO = sqlSession.getMapper(QnaBoardDAO.class);
		
		int result = qnaBoardDAO.qnaBoardDelete(no);
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			if (result > 0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('게시물 삭제 성공했습니다')");
				response.getWriter().println("location.href='qnaBoardPage.do'");
				response.getWriter().println("</script>");
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('삭제에 실패했습니다')");
				response.getWriter().println("history.back()");
				response.getWriter().println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
