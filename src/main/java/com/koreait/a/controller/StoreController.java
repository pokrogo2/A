package com.koreait.a.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartRequest;

import com.koreait.a.command.store.SelectStoreListCommand;
import com.koreait.a.command.store.StoreInsertCommand;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class StoreController {

	private SqlSession sqlSession;
	private StoreInsertCommand storeInsertCommand;
	private SelectStoreListCommand selectStoreListCommand;
	

	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value="storeInsertPage.do")
	public String storeInsertPage() {
		return "store/storeInsert";
	}
	
	@PostMapping(value="storeInsert.do")
	public String storeInsert(MultipartRequest multipartRequest,
							Model model) {
		model.addAttribute("MultipartRequest", multipartRequest);
		storeInsertCommand.execute(sqlSession, model);
		return "redirect:storeList.do";
	}
	
	@GetMapping(value="storeListPage.do")
	public String storeListPage() {
		return "store/storeList";
	}
	
	@GetMapping(value="storeList.do")
	public String storeList(Model model) {
		selectStoreListCommand.execute(sqlSession, model);
		return "store/storeList";
	}
	
	@GetMapping(value="storeViewPage.do")
	public String storeViewPage() {
		return "store/storeView";
	}
	
}
