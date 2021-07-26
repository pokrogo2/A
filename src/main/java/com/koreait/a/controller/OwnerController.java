package com.koreait.a.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.koreait.a.command.owner.JoinCommand;
import com.koreait.a.command.owner.NoCheckCommand;
import com.koreait.a.command.owner.OwnerDeleteCommand;
import com.koreait.a.command.owner.OwnerEmailCheckCommand;
import com.koreait.a.command.owner.OwnerFindPwCommand;
import com.koreait.a.command.owner.OwnerLoginCommand;
import com.koreait.a.command.owner.OwnerLogoutCommand;

@Controller
public class OwnerController {
	private SqlSession sqlSession;
	private JoinCommand joinCommand;
	private NoCheckCommand noCheckCommand;
	private OwnerEmailCheckCommand ownerEmailCheckCommand;
	private OwnerFindPwCommand ownerFindPwCommand;
	private OwnerDeleteCommand ownerDeleteCommand;
	private OwnerLoginCommand ownerLoginCommand;
	private OwnerLogoutCommand ownerLogoutCommand;
	// private EmailAuthCommand emailAuthCommand;
	
	
	@Autowired
	public OwnerController(SqlSession sqlSession, JoinCommand joinCommand,
			NoCheckCommand noCheckCommand,
			OwnerEmailCheckCommand ownerEmailCheckCommand,
			OwnerFindPwCommand ownerFindPwCommand,
			OwnerDeleteCommand ownerDeleteCommand,
			OwnerLoginCommand ownerLoginCommand,
			OwnerLogoutCommand ownerLogoutCommand
			//EmailAuthCommand emailAuthCommand
			) {
		super();
		this.sqlSession = sqlSession;
		this.joinCommand = joinCommand;
		this.noCheckCommand=noCheckCommand;
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
	@GetMapping(value="ownerJoinPage.do")
	public String join() {
		return "owner/joinPage";
	}
	
	@GetMapping(value="ownerLoginPage.do")
	public String login() {
		return "owner/ownerLoginPage";
	}
	
	@PostMapping(value="ownerlogin.do")
	public String login(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ownerLoginCommand.execute(sqlSession, model);
		return "redirect:ownerLoginPage.do";				
	}
	@GetMapping(value="ownerlogout.do")
	public String logout(HttpSession session, Model model) {
		model.addAttribute("session", session);
		ownerLogoutCommand.execute(sqlSession, model);
		return "redirect:ownerLoginPage.do";
	}
	@GetMapping(value="ownerPwPage.do")
	public String ownerfindPwPage() {
		return "owner/findPw";
	}
	@PostMapping(value="ownerFindPw.do")
	public String ownerfindPw(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ownerFindPwCommand.execute(sqlSession, model);
		return "owner/findPwResult";
	}
	@GetMapping(value="ownerDelete.do")
	public String delete(HttpSession session, Model model) {
		model.addAttribute("session", session);
		ownerDeleteCommand.execute(sqlSession, model);
		return "redirect:/";
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
