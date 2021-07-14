package com.koreait.a.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class OwnerController {
	private SqlSession sqlSession;
	
	@GetMapping(value="joinPage.do")
	public String join() {
		return "owner/joinPage";
	}
	

}
