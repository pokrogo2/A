package com.koreait.a.command.owner;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.OwnerDAO;
import com.koreait.a.dto.OwnerDTO;
import com.koreait.a.utils.SecurityUtils;

public class OwnerLoginCommand implements OwnerCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Long no = Long.parseLong(request.getParameter("no"));
		String pw = request.getParameter("ownerPw");
		
		OwnerDTO owner = new OwnerDTO();
		owner.setOwnerNo(no);
		owner.setOwnerPw(SecurityUtils.encodeBase64(pw));  // 암호화 된 pw
		
		OwnerDAO ownerDAO = sqlSession.getMapper(OwnerDAO.class);
		OwnerDTO loginOwner = ownerDAO.login(owner);
		
		if (loginOwner != null) {

			request.getSession().setAttribute("loginOwner", loginOwner);
		}
		
	}

}
