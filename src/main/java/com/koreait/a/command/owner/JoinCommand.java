package com.koreait.a.command.owner;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.OwnerDAO;
import com.koreait.a.dto.OwnerDTO;
import com.koreait.a.utils.SecurityUtils;

public class JoinCommand implements OwnerCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		long no = Long.parseLong(request.getParameter("no"));
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String name = request.getParameter("name"); // 사업자명
		String tel = request.getParameter("tel");
		
		OwnerDTO owner = new OwnerDTO();
		owner.setOwnerNo(no);
		owner.setOwnerPw(SecurityUtils.encodeBase64(pw));
		owner.setOwnerEmail(email);
		owner.setOwnerName(SecurityUtils.xxs(name));
		owner.setOwnerTel(tel);
		
		OwnerDAO ownerDAO = sqlSession.getMapper(OwnerDAO.class);
		ownerDAO.join(owner);

	}

}