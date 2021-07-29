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

import com.koreait.a.command.main.LocalSelectCommand;
import com.koreait.a.command.main.MainNewStoreCommand;
import com.koreait.a.command.main.MainRecommandStoreCommand;
import com.koreait.a.command.main.MainStoreExistCommand;
import com.koreait.a.command.main.ZoneSelectCommand;

@Controller
public class MainController {
	private SqlSession sqlSession;
	private MainStoreExistCommand mainStoreExistCommand;
	private MainRecommandStoreCommand mainRecommandStoreCommand;
	private MainNewStoreCommand mainNewStoreCommand;
	private ZoneSelectCommand zoneSelectCommand;
	private LocalSelectCommand localSelectCommand;

	@Autowired
	public MainController(SqlSession sqlSession,
						  MainStoreExistCommand mainStoreExistCommand,
						  MainRecommandStoreCommand mainRecommandStoreCommand,
						  MainNewStoreCommand mainNewStoreCommand,
						  ZoneSelectCommand zoneSelectCommand,
						  LocalSelectCommand localSelectCommand) {
		super();
		this.sqlSession = sqlSession;
		this.mainStoreExistCommand = mainStoreExistCommand;
		this.mainRecommandStoreCommand = mainRecommandStoreCommand;
		this.mainNewStoreCommand = mainNewStoreCommand;
		this.zoneSelectCommand = zoneSelectCommand;
		this.localSelectCommand = localSelectCommand;
	}

	
	
	/* 검색에 필요한 지역 정보를 불러온다 (select) */
	@GetMapping(value="zoneSelect.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> zoneSelect(Model model) {
		return zoneSelectCommand.execute(sqlSession, model);
	}
	
	/* 검색에 필요한 구의 정보를 불러온다 (select) */
	@GetMapping(value="localSelect.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> localSelect(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			return localSelectCommand.execute(sqlSession, model);
	}
	
	
	/* 음식점 검색 : 전달하는 칼럼 (zone, local, catg, query) */
	@GetMapping(value="searchStore.do")
	public String searchStore(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return "";
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
