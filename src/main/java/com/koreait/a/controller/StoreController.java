package com.koreait.a.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.koreait.a.command.store.StoreDeleteCommand;
import com.koreait.a.command.store.StoreInsertCommand;
import com.koreait.a.command.store.StoreListCommand;
import com.koreait.a.command.store.StoreUpdateCommand;
import com.koreait.a.command.store.StoreViewCommand;

import lombok.AllArgsConstructor;

@Controller
public class StoreController {

	// field
	private SqlSession sqlSession;
	private StoreInsertCommand storeInsertCommand;
	private StoreListCommand storeListCommand;
	private StoreViewCommand storeViewCommand;
	private StoreUpdateCommand storeUpdateCommand;
	private StoreDeleteCommand storeDeleteCommand;

	// constructor
	@Autowired
	public StoreController(SqlSession sqlSession, 
			  			   StoreInsertCommand storeInsertCommand,
			  			   StoreListCommand storeListCommand, 
			  			   StoreViewCommand storeViewCommand,
			  			   StoreUpdateCommand storeUpdateCommand,
			  			   StoreDeleteCommand storeDeleteCommand) {
		super();
		this.sqlSession = sqlSession;
		this.storeInsertCommand = storeInsertCommand;
		this.storeListCommand = storeListCommand;
		this.storeViewCommand = storeViewCommand;
		this.storeUpdateCommand = storeUpdateCommand;
		this.storeDeleteCommand = storeDeleteCommand;
	}
	
	
	// index 페이지 
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	

	// 가게 등록 
	@GetMapping(value="storeInsertPage.do")
	public String insertStorePage() {
		return "store/storeInsert";
	}
	
	@PostMapping(value="storeInsert.do")
	public String insertStore(MultipartRequest multipartRequest,
							  Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		storeInsertCommand.execute(sqlSession, model);
		return "redirect:storeList.do";
	}
	
	/*
	@GetMapping(value="storeListPage.do")
	public String storeListPage() {
		return "store/storeList";
	}
	*/
	
	
	// 가게 리스트 
	@GetMapping(value="storeList.do")
	public String storeList(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		storeListCommand.execute(sqlSession, model);
		return "store/storeList";
	} 
	
	
	// 가게 view 
	
	@GetMapping(value="storeViewPage.do")
	public String viewStorePage() {
		return "store/storeView";
	}
		
	@GetMapping(value="storeView.do")
	public String selectStoreByNo(HttpServletRequest request,
								  Model model) {
		model.addAttribute("request", request);
		storeViewCommand.execute(sqlSession, model);
		return "store/storeView";
	}
	
	// 가게 Update Page
	@GetMapping(value="storeUpdatePage.do")
	public String storeUpdatePage(HttpServletRequest request, 
									HttpServletResponse response, 
									Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		storeViewCommand.execute(sqlSession, model);
		return "store/storeUpdate";
	}
	
	// 가게 Update
	@PostMapping(value="storeUpdate.do")
	public String storeUpdate(MultipartRequest multipartRequest,Model model) {
	model.addAttribute("multipartRequest", multipartRequest);
	storeUpdateCommand.execute(sqlSession, model);
	return "redirect:storeList.do";
	}
	
	// 가게 등록 삭제
	@PostMapping(value="storeDelete.do")
	public String storeDelete(MultipartHttpServletRequest multipartRequest,
							HttpServletResponse response, 
							Model model) {
	model.addAttribute("multipartRequest", multipartRequest);
	model.addAttribute("response", response);
	storeDeleteCommand.execute(sqlSession, model);
	return "redirect:storeList.do";
	}
}
