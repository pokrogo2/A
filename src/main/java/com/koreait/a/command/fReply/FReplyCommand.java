package com.koreait.a.command.fReply;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface FReplyCommand {

	public Map<String, Object> execute(SqlSession sqlSession, Model model);
	
}
