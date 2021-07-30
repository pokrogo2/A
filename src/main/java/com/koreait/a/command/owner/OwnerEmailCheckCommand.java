package com.koreait.a.command.owner;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.OwnerDAO;

public class OwnerEmailCheckCommand {
	public Map<String, Integer> execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String email = request.getParameter("email");
		OwnerDAO ownerDAO = sqlSession.getMapper(OwnerDAO.class);
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("count", ownerDAO.emailCheck(email));
		return resultMap;
	}

}