package com.koreait.a.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.a.command.member.EmailAuthCommand;
import com.koreait.a.command.member.IdCheckCommand;
import com.koreait.a.command.member.JoinCommand;

@Controller
public class MemberController {
	private SqlSession sqlSession;
	private EmailAuthCommand emailAuthCommand;
	private JoinCommand joinCommand;
	private IdCheckCommand idCheckCommand;
	
	@Autowired
	public MemberController(SqlSession sqlSession, EmailAuthCommand emailAuthCommand, 
			JoinCommand joinCommand,IdCheckCommand idCheckCommand
			) {
		super();
		this.sqlSession = sqlSession;
		this.emailAuthCommand = emailAuthCommand;
		this.joinCommand = joinCommand;
		this.idCheckCommand = idCheckCommand;
	}

	@GetMapping(value="loginPage.do")
	public String login() {
		return "member/loginPage";
	}
	@GetMapping(value="idCheck.do",produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Integer> idCheck(HttpServletRequest request,
				Model model) {
		model.addAttribute("request", request);
		return idCheckCommand.execute(sqlSession, model);
	}


	@GetMapping(value="joinPage.do")
	public String join() {
		return "member/joinPage";
	}
	@PostMapping(value="join.do")
	public String join(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		joinCommand.execute(sqlSession, model);
		return "redirect:loginPage.do";
	}
	
	@GetMapping(value="verifyNum.do",
			produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> verifyNum(HttpServletRequest request, 
				 Model model) {
		model.addAttribute("request", request);
	return emailAuthCommand.execute(sqlSession, model);
	
	}
	
	
	
}
