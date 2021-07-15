package com.koreait.a.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.a.command.store.InsertStoreCommand;
import com.koreait.a.command.store.SelectStoreListCommand;
import com.koreait.a.dto.Page;
import com.koreait.a.dto.Store;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class StoreController {

	private SqlSession sqlSession;
	private InsertStoreCommand insertStoreCommand;
	private SelectStoreListCommand selectStoreListCommand;
	

	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value="insertStorePage.do")
	public String insertStorePage() {
		return "store/insertStore";
	}
	
	@PostMapping(value="insertStore.do")
	public String insertStore(HttpServletRequest request ,
							  Model model) {
		model.addAttribute("request", request);
		insertStoreCommand.execute(sqlSession, model);
		return "redirect:storelist.do";	
	}
	
	@GetMapping(value="storeListPage.do")
	public String storeListPage() {
		return "store/storeList";
	}
	
	@PostMapping(value="storeList.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> storeList(@RequestBody Page page,
										 Model model) {
		model.addAttribute("page", page.getPage());
		return selectStoreListCommand.execute(sqlSession, model);
		
	} 
	
	@GetMapping(value="viewStorePage.do")
	public String viewStorePage() {
		return "store/viewStore";
	}
	
}
