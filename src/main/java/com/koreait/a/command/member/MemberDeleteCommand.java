package com.koreait.a.command.member;

import java.util.Map;

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
		
		long no = ((MemberDTO)session.getAttribute("loginUser")).getMemberNo();
		System.out.println(no);
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int count = memberDAO.delete(no);
		
		if (count > 0) {
			session.invalidate();
		}
	}

}
