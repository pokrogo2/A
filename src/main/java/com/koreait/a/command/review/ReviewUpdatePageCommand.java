package com.koreait.a.command.review;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.ReviewDAO;
import com.koreait.a.dto.ReviewDTO;

public class ReviewUpdatePageCommand implements ReviewCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		long no = Long.parseLong(request.getParameter("no"));
		ReviewDAO reviewDAO = sqlSession.getMapper(ReviewDAO.class);
		ReviewDTO review = reviewDAO.updateSelect(no);
		model.addAttribute("review", review);
		try { 
			model.addAttribute("filename", URLDecoder.decode(review.getFilename(), "utf-8")); 
		} catch(Exception e) {
			
		}
		}
		
}
