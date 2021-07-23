package com.koreait.a.command.member;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.MemberDAO;
import com.koreait.a.dto.MemberDTO;

public class MemberDeleteCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		long no = ((MemberDTO)session.getAttribute("loginUser")).getMemberNo();
		System.out.println(no);
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int count = memberDAO.delete(no);
		response.setContentType("html/text; charset=UTF-8");
		try {
		if (count > 0) {
			session.invalidate();
			response.getWriter().println("<script>");
			response.getWriter().println("alert('탈퇴에 성공하였습니다.')");
			response.getWriter().println("location.href='index.do'");
			response.getWriter().println("</script>");
		}else {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('탈퇴에 실패하였습니다.')");
			response.getWriter().println("location.href='index.do'");
			response.getWriter().println("</script>");
		}
	}catch(IOException e) {
		e.printStackTrace();
	}
	}

}
