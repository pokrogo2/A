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

import com.koreait.a.command.owner.OwnerDeleteCommand;
import com.koreait.a.command.owner.OwnerEmailCheckCommand;
import com.koreait.a.command.owner.OwnerFindPwCommand;
import com.koreait.a.command.owner.OwnerJoinCommand;
import com.koreait.a.command.owner.OwnerLoginCommand;
import com.koreait.a.command.owner.OwnerLogoutCommand;
import com.koreait.a.command.owner.OwnerNoCheckCommand;

@Controller
public class OwnerController {
	private SqlSession sqlSession;
	private OwnerJoinCommand ownerJoinCommand;
	private OwnerNoCheckCommand ownerNoCheckCommand;
	private OwnerEmailCheckCommand ownerEmailCheckCommand;
	private OwnerFindPwCommand ownerFindPwCommand;
	private OwnerDeleteCommand ownerDeleteCommand;
	private OwnerLoginCommand ownerLoginCommand;
	private OwnerLogoutCommand ownerLogoutCommand;
	// private EmailAuthCommand emailAuthCommand;
	
	
	@Autowired
	public OwnerController(SqlSession sqlSession, OwnerJoinCommand ownerJoinCommand,
			OwnerNoCheckCommand ownerNoCheckCommand,
			OwnerEmailCheckCommand ownerEmailCheckCommand,
			OwnerFindPwCommand ownerFindPwCommand,
			OwnerDeleteCommand ownerDeleteCommand,
			OwnerLoginCommand ownerLoginCommand,
			OwnerLogoutCommand ownerLogoutCommand
			//EmailAuthCommand emailAuthCommand
			) {
		super();
		this.sqlSession = sqlSession;
		this.ownerJoinCommand = ownerJoinCommand;
		this.ownerNoCheckCommand = ownerNoCheckCommand;
		this.ownerEmailCheckCommand = ownerEmailCheckCommand;
		this.ownerFindPwCommand = ownerFindPwCommand;
		this.ownerDeleteCommand = ownerDeleteCommand;
		this.ownerLoginCommand = ownerLoginCommand;
		this.ownerLogoutCommand = ownerLogoutCommand;
		// this.emailAuthCommand = emailAuthCommand;
	}
/*
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	*/
	@GetMapping(value="noCheck.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Integer> noCheck(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return ownerNoCheckCommand.execute(sqlSession, model);
	}
	
	@GetMapping(value="ownerJoinPage.do")
	public String join() {
		return "owner/joinPage";
	}
	@PostMapping(value="ownerJoin.do")
	public String join(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ownerJoinCommand.execute(sqlSession, model);
		return "redirect:index.do";
	}
	
	@GetMapping(value="ownerLoginPage.do")
	public String login() {
		return "owner/ownerLoginPage";
	}
	
	@PostMapping(value="ownerLogin.do")
	public String login(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ownerLoginCommand.execute(sqlSession, model);
		return "redirect:ownerLoginPage.do";				
	}
	@GetMapping(value="ownerLogout.do")
	public String logoutOwner(HttpSession session, Model model) {
		model.addAttribute("session", session);
		ownerLogoutCommand.execute(sqlSession, model);
		return "redirect:ownerLoginPage.do";
	}
	@GetMapping(value="ownerPwPage.do")
	public String ownerfindPwPage() {
		return "owner/ownerFindPw";
	}
	@PostMapping(value="ownerFindPw.do")
	public String ownerfindPw(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ownerFindPwCommand.execute(sqlSession, model);
		return "owner/ownerFindPwResult";
	}
	@GetMapping(value="ownerDelete.do")
	public String delete(HttpSession session, Model model) {
		model.addAttribute("session", session);
		ownerDeleteCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	@GetMapping(value="ownerEmailCheck.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Integer> ownerEmailCheck(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return ownerEmailCheckCommand.execute(sqlSession, model);
	}
	/*@GetMapping(value="verifyNum.do",
			produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> verifyNum(HttpServletRequest request, 
				 Model model) {
		model.addAttribute("request", request);
	return emailAuthCommand.execute(sqlSession, model);
	
	}*/
}
