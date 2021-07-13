package com.koreait.a.command.review;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.ReviewDAO;
import com.koreait.a.dto.PageDTO;
import com.koreait.a.dto.ReviewDTO;
import com.koreait.a.utils.PagingUtils;

public class SelectReviewListCommand implements ReviewCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		/*
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		ReviewDAO reviewDAO = sqlSession.getMapper(ReviewDAO.class);
		int totalRecord = reviewDAO.getTotalRecord();
		String loginId = request.getParameter("loginId");
		PageDTO pageDTO = PagingUtils.getPage(loginId,totalRecord, page);
		
		List<ReviewDTO> list = reviewDAO.searchAll(pageDTO);
		String paging = PagingUtils.getPaging("reviewPage.do", page);
		*/
	
		ReviewDAO reviewDAO = sqlSession.getMapper(ReviewDAO.class);
		String loginId= request.getParameter("loginId");
		List<ReviewDTO> list = reviewDAO.selectOne(loginId);
		
		model.addAttribute("list", list);
		//model.addAttribute("paging", paging);

	}

}
