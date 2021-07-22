package com.koreait.a.command.notice;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.NoticeDAO;
import com.koreait.a.dto.NoticeDTO;

public class NoticeUpdateCommand implements NoticeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		NoticeDTO notice = new NoticeDTO();
		notice.setNo(Long.parseLong(request.getParameter("no")));
		notice.setWriter(request.getParameter("writer"));
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		
		NoticeDAO noticeDAO = sqlSession.getMapper(NoticeDAO.class);
		// 공지사항 수정
		int result = noticeDAO.noticeUpdate(notice);
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			if (result > 0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('수정을 완료했습니다.')");
				response.getWriter().println("location.href='noticeView.do?no=" + notice.getNo() + "'");
				response.getWriter().println("</script>");
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('수정을 처리하는 중에 오류가 발생했습니다.')");
				response.getWriter().println("history.back()");
				response.getWriter().println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
			
			

	}

}
