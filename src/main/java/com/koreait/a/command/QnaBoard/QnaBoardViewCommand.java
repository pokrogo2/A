package com.koreait.a.command.QnaBoard;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.QnaBoardDAO;
import com.koreait.a.dto.QnaBoardDTO;

public class QnaBoardViewCommand implements QnaBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		long no = Long.parseLong(request.getParameter("no"));
		String loginUser = request.getParameter("loginUser");
		
		QnaBoardDAO qnaBoardDAO = sqlSession.getMapper(QnaBoardDAO.class);
		QnaBoardDTO qnaBoard = qnaBoardDAO.qnaBoardView(no);
		
		response.setCharacterEncoding("UTF-8");
		try {
			if(qnaBoard != null) {
				model.addAttribute("qnaBoard", qnaBoard);
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('공지사항을 불러오지 못했습니다.')");
				response.getWriter().println("location.href='qnaBoardPage.do'");
				response.getWriter().println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
