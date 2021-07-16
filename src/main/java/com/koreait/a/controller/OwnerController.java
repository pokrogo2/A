package com.koreait.a.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.koreait.a.command.owner.JoinCommand;
import com.koreait.a.command.owner.NoCheckCommand;
import com.koreait.a.command.owner.OwnerEmailCheckCommand;

@Controller
public class OwnerController {
	private SqlSession sqlSession;
	private JoinCommand joinCommand;
	private NoCheckCommand noCheckCommand;

	private OwnerEmailCheckCommand ownerEmailCheckCommand;
	
	
	@Autowired
	public OwnerController(SqlSession sqlSession, JoinCommand joinCommand,
			NoCheckCommand noCheckCommand,
			OwnerEmailCheckCommand ownerEmailCheckCommand) {
		super();
		this.sqlSession = sqlSession;
		this.joinCommand = joinCommand;
		this.noCheckCommand=noCheckCommand;

		this.ownerEmailCheckCommand = ownerEmailCheckCommand;
	}
/*
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	*/
	@GetMapping(value="ownerJoinPage.do")
	public String join() {
		return "owner/joinPage";
	}
}
