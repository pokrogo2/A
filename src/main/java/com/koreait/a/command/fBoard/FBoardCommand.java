package com.koreait.a.command.fBoard;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface FBoardCommand {

	public void execute(SqlSession sqlSession, Model model);
	
}
