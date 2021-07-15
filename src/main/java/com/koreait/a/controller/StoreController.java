package com.koreait.a.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StoreController {

	private SqlSession sqlSession;
	// private InsertStoreCommand insertStoreCommand;
	// private SelectStoreListCommand selectStoreListCommand;
	public StoreController(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	
	
	@GetMapping(value="insertStorePage.do")
	public String insertStorePage() {
		return "store/insertStore";
	}
	
	/*
	@PostMapping(value="insertStore.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String insertStore(@RequestBody Store store, 
											MultipartRequest multipartRequest,
											Model model) {
		model.addAttribute("store", store);
		model.addAttribute("MultipartRequest", multipartRequest);
		insertStoreCommand.execute(sqlSession, model);
		return "redirect:storeList";	
	}
	*/
	
	
	

	@GetMapping(value="storeListPage.do")
	public String storeListPage() {
		return "store/storeList";
	}
	
	/* @GetMapping(value="storeList.do")
	public String storeList(Model model) {
		selectStoreListCommand.execute(sqlSession, model);
		return "store/storeList";
	} */
	
	@GetMapping(value="viewStorePage.do")
	public String viewStorePage() {
		return "store/viewStore";
	}
	
}
