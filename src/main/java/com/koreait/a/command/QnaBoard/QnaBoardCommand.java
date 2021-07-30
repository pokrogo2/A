package com.koreait.a.command.QnaBoard;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface QnaBoardCommand {
	
	public void execute(SqlSession sqlSession, Model model);

}
