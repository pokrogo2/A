package com.koreait.a.command.owner;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.OwnerDAO;
import com.koreait.a.dto.OwnerDTO;
import com.koreait.a.utils.SecurityUtils;


public class OwnerFindPwCommand implements OwnerCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");		
		String email = request.getParameter("email");
		
		OwnerDAO ownerDAO = sqlSession.getMapper(OwnerDAO.class);
		OwnerDTO findOwner = ownerDAO.findPw(email);
		findOwner.setOwnerPw(SecurityUtils.decodeBase64(findOwner.getOwnerPw()));
		if (findOwner != null) {
			model.addAttribute("findUser", findOwner);
		}
	}

}
