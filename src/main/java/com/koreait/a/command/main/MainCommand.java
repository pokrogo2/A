package com.koreait.a.command.main;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface MainCommand {

	public Map<String, Object> execute(SqlSession sqlSession, Model model);
}
