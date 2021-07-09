package com.koreait.a.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class OwenerController {

	private SqlSession sqlSession;
	
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	
}
