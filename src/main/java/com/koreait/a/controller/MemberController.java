package com.koreait.a.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.koreait.a.command.member.MemberDeleteCommand;
import com.koreait.a.command.member.MemberFindIdCommand;
import com.koreait.a.command.member.MemberFindPwCommand;
import com.koreait.a.command.member.MemberIdCheckCommand;
import com.koreait.a.command.member.MemberJoinCommand;
import com.koreait.a.command.member.MemberLoginCommand;
import com.koreait.a.command.member.MemberLogoutCommand;
import com.koreait.a.command.member.MemberUpdateCommand;

@Controller
public class MemberController {
	private SqlSession sqlSession;
	private EmailAuthCommand emailAuthCommand;
	private MemberJoinCommand memberJoinCommand;
	private MemberIdCheckCommand memberIdCheckCommand;
	private MemberLoginCommand memberLoginCommand;
	private MemberLogoutCommand memberLogoutCommand;
	private EmailCheckCommand emailCheckCommand;
	private MemberFindIdCommand memberFindIdCommand;
	private MemberFindPwCommand memberFindPwCommand;
	private MemberDeleteCommand memberDeleteCommand;
	private MemberUpdateCommand memberUpdateCommand;

	@Autowired
	public MemberController(SqlSession sqlSession, EmailAuthCommand emailAuthCommand,
			MemberJoinCommand memberJoinCommand, MemberIdCheckCommand memberIdCheckCommand,
			MemberLoginCommand memberLoginCommand, MemberLogoutCommand memberLogoutCommand,
			EmailCheckCommand emailCheckCommand, MemberFindIdCommand memberFindIdCommand,
			MemberFindPwCommand memberFindPwCommand, MemberDeleteCommand memberDeleteCommand,
			MemberUpdateCommand memberUpdateCommand) {
		super();
		this.sqlSession = sqlSession;
		this.emailAuthCommand = emailAuthCommand;
		this.memberJoinCommand = memberJoinCommand;
		this.memberIdCheckCommand = memberIdCheckCommand;
		this.memberLoginCommand = memberLoginCommand;
		this.memberLogoutCommand = memberLogoutCommand;
		this.emailCheckCommand = emailCheckCommand;
		this.memberFindIdCommand = memberFindIdCommand;
		this.memberFindPwCommand = memberFindPwCommand;
		this.memberDeleteCommand = memberDeleteCommand;
		this.memberUpdateCommand = memberUpdateCommand;

	}

	

	@GetMapping(value="loginPage.do")
	public String login() {
		return "member/loginPage";
	}
	
		@GetMapping(value="memberUpdatePage.do")
	public String memberUpdatePage() {
		return "member/updatePage";
	}
	@GetMapping(value="idCheck.do",produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Integer> idCheck(HttpServletRequest request,
				Model model) {
		model.addAttribute("request", request);
		return memberIdCheckCommand.execute(sqlSession, model);
	}

	// 회원과 사장님 회원가입으로 가기 위한 join,jsp
	@GetMapping(value="joinPage.do")
	public String join() {
		return "member/navJoin";
	}
	
	// 회원 회원가입 페이지 
	@GetMapping(value="userJoinPage.do")
	public String userJoinPage() {
		return "member/joinPage";
	}
	@PostMapping(value="join.do")
	public String join(HttpServletRequest request,HttpServletResponse response ,Model model) {
		model.addAttribute("request",request);
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		memberJoinCommand.execute(sqlSession, model);
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
		memberLoginCommand.execute(sqlSession, model);
		return "redirect:index.do";
	}
	@GetMapping(value="logout.do")
	public String logout(HttpSession session,
						 Model model) {
		model.addAttribute("session", session);
		memberLogoutCommand.execute(sqlSession, model);
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
		memberFindIdCommand.execute(sqlSession, model);
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
		memberFindPwCommand.execute(sqlSession, model);
		return "member/findPwResult";
	}
	@GetMapping(value="deleteMember.do")
	public String leave(HttpSession session,
			HttpServletResponse response,Model model,HttpServletRequest request) {
		model.addAttribute("session", session);
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		memberDeleteCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	@PostMapping(value="updateMember.do")
	public String updateMember(HttpServletRequest request, 
			 Model model) {
		model.addAttribute("request", request);
		memberUpdateCommand.execute(sqlSession, model);
		return "member/memberMyPage";
	}
	
}
