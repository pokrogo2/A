package com.koreait.a.command.notice;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.NoticeDAO;
import com.koreait.a.dto.Notice;

public class NoticeViewCommand implements NoticeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		long no = Long.parseLong(request.getParameter("no"));
		String loginUser = request.getParameter("loginUser");
		
		NoticeDAO noticeDAO = sqlSession.getMapper(NoticeDAO.class);
		// 공지사항 불러오기
		Notice notice = noticeDAO.noticeView(no);
		// 조회수 중가
		if(notice.getWriter() != loginUser) {
			int count = noticeDAO.hitUp(no);
			notice.setHit(notice.getHit() + 1);
		}
		
		response.setCharacterEncoding("UTF-8");
		try {
			if (notice != null) {
				model.addAttribute("notice", notice);
			} else {
					response.getWriter().println("<script>");
					response.getWriter().println("alert('공지사항을 불러오는데 오류가 발생했습니다.')");
					response.getWriter().println("location.href='noticePage.do'");
					response.getWriter().println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
			
			

	}

}
