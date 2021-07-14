package com.koreait.a.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.a.command.owner.JoinCommand;

@org.springframework.stereotype.Controller
public class OwnerController {
	private SqlSession sqlSession;
	private JoinCommand joinCommand;
	
	@Autowired
	public OwnerController(SqlSession sqlSession, JoinCommand joinCommand) {
		super();
		this.sqlSession = sqlSession;
		this.joinCommand = joinCommand;
	}

	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="joinPage.do")
	public String join() {
		return "owner/joinPage";
	}
	

}
