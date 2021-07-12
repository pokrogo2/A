package com.koreait.a.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class ResController {

	private SqlSession sqlSession;
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="resInsertPage.do")
	public String resInsert() {
		return "res/resInsert";
	}
	
	@GetMapping(value="resListPage.do")
	public String resList() {
		return "res/resList";
	}
	
	@GetMapping(value="resViewPage.do")
	public String resView() {
		return "res/resView";
	}
	
}