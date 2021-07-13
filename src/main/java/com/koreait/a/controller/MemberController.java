package com.koreait.a.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	private SqlSession sqlSession;
	
	
	
	@GetMapping(value="loginPage.do")
	public String login() {
		return "member/loginPage";
	}
	
	
	@GetMapping(value="joinPage.do")
	public String join() {
		return "member/joinPage";
	}
	
	
	
	
	
	
}
