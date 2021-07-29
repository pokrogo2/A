package com.koreait.a.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.koreait.a.command.reservation.ResDeleteCommand;
import com.koreait.a.command.reservation.ResInsertCommand;
import com.koreait.a.command.reservation.ResViewCommand;
import com.koreait.a.command.store.AutoSearchCommand;
import com.koreait.a.command.store.SearchLineUpCommand;
import com.koreait.a.command.store.SearchQueryCommand;
import com.koreait.a.command.store.StoreDeleteCommand;
import com.koreait.a.command.store.StoreInsertCommand;
import com.koreait.a.command.store.StoreListCommand;
import com.koreait.a.command.store.StoreUpdateCommand;
import com.koreait.a.command.store.StoreViewCommand;
import com.koreait.a.dto.MemberDTO;
import com.koreait.a.dto.StoreDTO;
import com.koreait.a.dto.StoreQueryDTO;


@Controller
public class StoreController {

	// field
		private SqlSession sqlSession;
		private StoreInsertCommand storeInsertCommand;
		private StoreListCommand storeListCommand;
		private StoreViewCommand storeViewCommand;
		private StoreUpdateCommand storeUpdateCommand;
		private StoreDeleteCommand storeDeleteCommand;
		private AutoSearchCommand autoSearchCommand;
		private SearchQueryCommand searchQueryCommand;
		private SearchLineUpCommand searchLineUpCommand;
		
		private ResInsertCommand resInsertCommand;
		private ResViewCommand resViewCommand;
		private ResDeleteCommand resDeleteCommand;

		// constructor
		@Autowired
		public StoreController(SqlSession sqlSession, 
				  			   StoreInsertCommand storeInsertCommand,
				  			   StoreListCommand storeListCommand, 
				  			   StoreViewCommand storeViewCommand,
				  			   StoreUpdateCommand storeUpdateCommand,
				  			   StoreDeleteCommand storeDeleteCommand,
				  			   AutoSearchCommand autoSearchCommand,
				  			   SearchQueryCommand searchQueryCommand,
				  			   SearchLineUpCommand searchLineUpCommand,
				  			   ResInsertCommand resInsertCommand,
				  			   ResViewCommand resViewCommand,
				  			   ResDeleteCommand resDeleteCommand) {
			super();
			this.sqlSession = sqlSession;
			this.storeInsertCommand = storeInsertCommand;
			this.storeListCommand = storeListCommand;
			this.storeViewCommand = storeViewCommand;
			this.storeUpdateCommand = storeUpdateCommand;
			this.storeDeleteCommand = storeDeleteCommand;
			this.autoSearchCommand = autoSearchCommand;
			this.searchQueryCommand = searchQueryCommand;
			this.searchLineUpCommand = searchLineUpCommand;
			this.resInsertCommand = resInsertCommand;
			this.resViewCommand = resViewCommand;
			this.resDeleteCommand = resDeleteCommand;
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
		public void insertStore(MultipartRequest multipartRequest,
								  HttpServletResponse response,
								  Model model) {
			model.addAttribute("multipartRequest", multipartRequest);
			model.addAttribute("response", response);
			storeInsertCommand.execute(sqlSession, model);
		}
		
		
		// 가게 리스트 
		@GetMapping(value="storeList.do")
		public String storeList(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			storeListCommand.execute(sqlSession, model);
			return "store/storeList";
		} 
		
		
		
		// 가게 검색
		
		@PostMapping(value = "autoSearch.do")
		@ResponseBody
		public void autoComplete(@RequestBody StoreQueryDTO queryDTO, HttpServletResponse response, Model model) {
			model.addAttribute("queryDTO", queryDTO);
			model.addAttribute("response", response);
			autoSearchCommand.execute(sqlSession, model);
		}

		@PostMapping(value = "storeSearch.do")
		public String search(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			searchQueryCommand.execute(sqlSession, model);
			return "store/storeList";
		}
		
		// 조회수, 등록순 가게 검색
		@PostMapping(value="searchLineUp.do", produces="application/json; charset=UTF-8")
		@ResponseBody
		public Map<String, Object> searchLineUp(HttpServletRequest request, 
												HttpServletResponse response,
												Model model) {
			model.addAttribute("request", request);
			model.addAttribute("response", response);
			return searchLineUpCommand.execute(sqlSession, model);
		}
		
		
		
		
		// 가게 view 
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
		public String storeUpdate(MultipartHttpServletRequest multipartRequest,
								HttpServletResponse response,
								Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		model.addAttribute("response", response);
		storeUpdateCommand.execute(sqlSession, model);
		return "redirect:storeView.do?storeNo=" + multipartRequest.getParameter("storeNo");
		}
		
		// 가게 등록 삭제
		@PostMapping(value="storeDelete.do")
		public void storeDelete(MultipartHttpServletRequest multipartRequest,
								HttpServletResponse response, 
								Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		model.addAttribute("response", response);
		storeDeleteCommand.execute(sqlSession, model);
		}
		
		
		
		/******** 예약 ********/
		
		// 가게 예약 페이지
		@PostMapping(value="storeResPage.do")
		public String storeRes(@ModelAttribute StoreDTO storeDTO, 
								@ModelAttribute MemberDTO memberDTO) { 
			return "reservation/resInsert";
		}
		
		// 예약 등록 
		@PostMapping(value="resInsert.do")
		public void resInsert(HttpServletRequest request,
							  HttpServletResponse response,
				              Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		resInsertCommand.execute(sqlSession, model);
		} 
		
		// 예약 내역 보기
		@GetMapping(value="resView.do")
		public String resView(HttpServletRequest request,
							  Model model) {
			model.addAttribute("request", request);
			resViewCommand.execute(sqlSession, model);
			return "reservation/resView";
		}
		@GetMapping(value="resDelete.do")
		public String deleteBoard(HttpServletRequest request,
								  Model model) {
			model.addAttribute("request", request);
			resDeleteCommand.execute(sqlSession, model);
			return "redirect:memberMyPage.do";
		}
		
	}