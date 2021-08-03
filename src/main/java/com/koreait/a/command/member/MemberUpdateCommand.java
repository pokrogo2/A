package com.koreait.a.command.member;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.MemberDAO;
import com.koreait.a.dto.MemberDTO;
import com.koreait.a.utils.SecurityUtils;

public class MemberUpdateCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		long no = Long.parseLong(request.getParameter("no"));
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		int age = Integer.parseInt(request.getParameter("age"));
		MemberDTO member = new MemberDTO();
		member.setMemberNo(no);
		member.setMemberPw(SecurityUtils.encodeBase64(pw));  // pw의 암호화
		member.setMemberName(SecurityUtils.xxs(name));  // name의 xxs처리
		member.setMemberTel(tel);
		member.setMemberAddr(addr);
		member.setMemberAge(age);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int result = memberDAO.updateMember(member);
		response.setContentType("text/html; charset=UTF-8");
		try {
			if (result > 0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('수정성공')");
				response.getWriter().println("location.href='memberUpdatePage.do'");
				response.getWriter().println("</script>");
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('수정실패')");
				response.getWriter().println("history.back()");
				response.getWriter().println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
