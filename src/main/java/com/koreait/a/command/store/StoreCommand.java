package com.koreait.a.command.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface StoreCommand {
	
	public void execute(SqlSession sqlSession, Model model);
	
}