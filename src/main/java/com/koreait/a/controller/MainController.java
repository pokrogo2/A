package com.koreait.a.controller;

import java.util.List;
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

import com.koreait.a.command.main.MainNewStoreCommand;
import com.koreait.a.command.main.MainRecommandStoreCommand;
import com.koreait.a.command.main.MainStoreExistCommand;
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
import com.koreait.a.dto.MainStoreDTO;

@Controller
public class MainController {
	private SqlSession sqlSession;
	private MainStoreExistCommand mainStoreExistCommand;
	private MainRecommandStoreCommand mainRecommandStoreCommand;
	private MainNewStoreCommand mainNewStoreCommand;

	@Autowired
	public MainController(SqlSession sqlSession,
						  MainStoreExistCommand mainStoreExistCommand,
						  MainRecommandStoreCommand mainRecommandStoreCommand,
						  MainNewStoreCommand mainNewStoreCommand) {
		super();
		this.sqlSession = sqlSession;
		this.mainStoreExistCommand = mainStoreExistCommand;
		this.mainRecommandStoreCommand = mainRecommandStoreCommand;
		this.mainNewStoreCommand = mainNewStoreCommand;
	}

	

	/* 로그인 후 가게 관리로 넘어간다. (가게관리 배너) */
	@PostMapping(value="storeExist.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> storeExist(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return mainStoreExistCommand.execute(sqlSession, model);
	}
	
	/* 추천 음식점 */
	@GetMapping(value="recommandStore.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> recommandStore(Model model) {
		return mainRecommandStoreCommand.execute(sqlSession, model);
	}
	
	/* 신규 음식점 */
	@GetMapping(value="NewStore.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> NewStore(Model model) {
		return mainNewStoreCommand.execute(sqlSession, model);
	}
	
	
	
	
	
	
	
}
