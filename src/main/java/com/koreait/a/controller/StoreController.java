package com.koreait.a.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.a.command.store.InsertStoreCommand;
import com.koreait.a.command.store.SelectStoreByNoCommand;
import com.koreait.a.command.store.SelectStoreListCommand;
import com.koreait.a.dto.Page;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class StoreController {

	private SqlSession sqlSession;
	private InsertStoreCommand insertStoreCommand;
	private SelectStoreListCommand selectStoreListCommand;
	private SelectStoreByNoCommand selectStoreByNoCommand;

	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value="insertStorePage.do")
	public String insertStorePage() {
		return "store/insertStore";
	}
	
	@PostMapping(value="insertStore.do")
	public void insertStore(HttpServletRequest request,
							HttpServletResponse response,
							  Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		insertStoreCommand.execute(sqlSession, model);
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
	
	@GetMapping(value="selectStoreByNo.do")
	public String selectStoreByNo(HttpServletRequest request,
								  HttpServletResponse response,
								  Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		selectStoreByNoCommand.execute(sqlSession, model);
		return "store/viewStore";
	}
	

	
	
	
}
