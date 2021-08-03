package com.koreait.a.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.koreait.a.command.reservation.ResMyPageCommand;
import com.koreait.a.command.review.ReviewDeleteCommand;
import com.koreait.a.command.review.ReviewInsertCommand;
import com.koreait.a.command.review.ReviewListCommand;
import com.koreait.a.command.review.ReviewUpdateCommand;
import com.koreait.a.command.review.ReviewUpdatePageCommand;

@Controller
public class ReviewController {
	private SqlSession sqlSession;
	private ReviewListCommand selectReviewListCommand;
	private ReviewInsertCommand reviewInsertCommand;
	private ReviewDeleteCommand reviewDeleteCommand;
	private ReviewUpdatePageCommand reviewUpdatePageCommand;
	private ReviewUpdateCommand reviewUpdateCommand;
	private ResMyPageCommand resMyPageCommand;
	@Autowired
	public ReviewController(SqlSession sqlSession, ReviewListCommand selectReviewListCommand,
			ReviewInsertCommand reviewInsertCommand,ReviewDeleteCommand reviewDeleteCommand,
			ReviewUpdatePageCommand reviewUpdatePageCommand,ReviewUpdateCommand reviewUpdateCommand,
			ResMyPageCommand resMyPageCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectReviewListCommand = selectReviewListCommand;
		this.reviewInsertCommand =reviewInsertCommand;
		this.reviewDeleteCommand = reviewDeleteCommand;
		this.reviewUpdatePageCommand =reviewUpdatePageCommand;
		this.reviewUpdateCommand = reviewUpdateCommand;
		this.resMyPageCommand = resMyPageCommand;
	}
	
	

	@GetMapping(value="memberMyPage.do")
	public String review(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		selectReviewListCommand.execute(sqlSession, model);
		resMyPageCommand.execute(sqlSession, model);
		return "member/memberMyPage";
	}
	@PostMapping(value="insertReview.do")
	public String insertBoard(MultipartHttpServletRequest multipartRequest,
			  Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		reviewInsertCommand.execute(sqlSession, model);
		return "redirect:memberMyPage.do";
	}
	
	
	
	@GetMapping(value="deleteReview.do")
	public void deleteBoard(HttpServletRequest request,HttpServletResponse response,
							  Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		reviewDeleteCommand.execute(sqlSession, model);
		//return "redirect:memberMyPage.do";
	}
	@GetMapping(value="updateReviewPage.do")
	public String updateBoardPage(HttpServletRequest request,
								  Model model) {
		model.addAttribute("request", request);
		reviewUpdatePageCommand.execute(sqlSession, model);

		return "review/reviewUpdate";
	}
	@PostMapping(value="updateReview.do")
	public String updateBoard(MultipartHttpServletRequest multipartRequest,
			  Model model) {
	model.addAttribute("multipartRequest", multipartRequest);
	reviewUpdateCommand.execute(sqlSession, model);
	return "redirect:memberMyPage.do";
}
	
	
}
