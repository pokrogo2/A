package com.koreait.a.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.a.command.review.SelectReviewListCommand;

@Controller
public class ReviewController {
	private SqlSession sqlSession;
	private SelectReviewListCommand selectReviewListCommand;
	
	@Autowired
	public ReviewController(SqlSession sqlSession, SelectReviewListCommand selectReviewListCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectReviewListCommand = selectReviewListCommand;
	}
	
	
	@GetMapping(value= {"/","index.do"})
	public String index() {
		return "index";
	}
	@GetMapping(value="reviewPage.do")
	public String review(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		selectReviewListCommand.execute(sqlSession, model);
		return "review/reviewPage";
	}
}
