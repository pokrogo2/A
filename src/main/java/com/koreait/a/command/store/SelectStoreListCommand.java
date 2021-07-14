package com.koreait.a.command.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public class SelectStoreListCommand implements StoreCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		/*
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		model.addAttribute("list", storeDAO.selectStoreList());
		*/
		
		
	}

}
