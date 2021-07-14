package com.koreait.a.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.a.command.member.EmailAuthCommand;
import com.koreait.a.command.member.EmailCheckCommand;
import com.koreait.a.command.member.FindIdCommand;
import com.koreait.a.command.member.FindPwCommand;
import com.koreait.a.command.member.IdCheckCommand;
import com.koreait.a.command.member.JoinCommand;
import com.koreait.a.command.member.LoginCommand;
import com.koreait.a.command.member.LogoutCommand;

@Controller
public class MemberController {
	private SqlSession sqlSession;
	private EmailAuthCommand emailAuthCommand;
	private JoinCommand joinCommand;
	private IdCheckCommand idCheckCommand;
	private LoginCommand loginCommand;
	private LogoutCommand logoutCommand;
	private EmailCheckCommand emailCheckCommand;
	private FindIdCommand findIdCommand;
	private FindPwCommand findPwCommand;
	@Autowired
	public MemberController(SqlSession sqlSession, EmailAuthCommand emailAuthCommand, 
			JoinCommand joinCommand,IdCheckCommand idCheckCommand,
			LoginCommand loginCommand,LogoutCommand logoutCommand,
			EmailCheckCommand emailCheckCommand,FindIdCommand findIdCommand
			,FindPwCommand findPwCommand
			) {
		super();
		this.sqlSession = sqlSession;
		this.emailAuthCommand = emailAuthCommand;
		this.joinCommand = joinCommand;
		this.idCheckCommand = idCheckCommand;
		this.loginCommand = loginCommand;
		this.logoutCommand = logoutCommand;
		this.emailCheckCommand = emailCheckCommand;
		this.findIdCommand = findIdCommand;
		this.findPwCommand = findPwCommand;
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
	@PostMapping(value="login.do")
	public String login(HttpServletRequest request,
						Model model) {
		model.addAttribute("request", request);
		loginCommand.execute(sqlSession, model);
		return "redirect:loginPage.do";
	}
	@GetMapping(value="logout.do")
	public String logout(HttpSession session,
						 Model model) {
		model.addAttribute("session", session);
		logoutCommand.execute(sqlSession, model);
		return "redirect:loginPage.do";
	}
	@GetMapping(value="findIdPage.do")
	public String findIdPage() {
		return "member/findId";
	}
	@GetMapping(value="emailCheck.do",produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Integer> emailCheck(HttpServletRequest request,
				Model model) {
		model.addAttribute("request", request);
		return emailCheckCommand.execute(sqlSession, model);
	}
	@PostMapping(value="findId.do")
	public String findId(HttpServletRequest request, 
						 Model model) {
		model.addAttribute("request", request);
		findIdCommand.execute(sqlSession, model);
		return "member/findIdResult";
	}
	@GetMapping(value="findPwPage.do")
	public String findPwPage() {
		return "member/findPw";
	}
	@PostMapping(value="findPw.do")
	public String findPw(HttpServletRequest request, 
						 Model model) {
		model.addAttribute("request", request);
		findPwCommand.execute(sqlSession, model);
		return "member/findPwResult";
	}
	
}
