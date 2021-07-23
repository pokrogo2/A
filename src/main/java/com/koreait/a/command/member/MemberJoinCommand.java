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

public class MemberJoinCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		
		int result;
		
		MemberDTO member = new MemberDTO();
		member.setMemberId(id);
		member.setMemberPw(SecurityUtils.encodeBase64(pw));  // pw의 암호화
		member.setMemberName(SecurityUtils.xxs(name));  // name의 xxs처리
		member.setMemberEmail(email);
		member.setMemberTel(tel);
		member.setMemberAddr(address);
		member.setMemberAge(age);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		result = memberDAO.join(member);
		response.setContentType("html/text; charset=UTF-8");
		try {
			if(result ==0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('회원가입에 실패하였습니다.')");
				response.getWriter().println("location.href='joinPage.do'");
				response.getWriter().println("</script>");
			}else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('회원가입에 성공하였습니다.')");
				response.getWriter().println("location.href='login.do'");
				response.getWriter().println("</script>");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
