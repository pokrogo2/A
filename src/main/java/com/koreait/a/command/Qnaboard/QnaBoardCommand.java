package com.koreait.a.command.Qnaboard;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

public interface QnaBoardCommand {
	
	public Map<String, Object> execute(SqlSession sqlSession, Model model);
	public static Logger logger = LoggerFactory.getLogger(QnaBoardCommand.class);

}
