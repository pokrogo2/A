package com.koreait.a.command.owner;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.OwnerDAO;
import com.koreait.a.dto.OwnerDTO;

public class OwnerDeleteCommand implements OwnerCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		
		long no = ((OwnerDTO)session.getAttribute("loginOwner")).getOwnerNo();
		System.out.println(no);
		OwnerDAO ownerDAO = sqlSession.getMapper(OwnerDAO.class);
		int count = ownerDAO.delete(no);
		
		if(count > 0) {
			session.invalidate();
		}

	}

}
