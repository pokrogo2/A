package com.koreait.a.command.owner;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface OwnerCommand {
	public void execute(SqlSession sqlSession, Model model);

}