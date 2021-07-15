package com.koreait.a.command.fReply;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface FReplyCommand {

	public void execute(SqlSession sqlSession, Model model);
	
}
