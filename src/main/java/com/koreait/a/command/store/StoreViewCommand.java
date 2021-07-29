package com.koreait.a.command.store;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.StoreDTO;

public class StoreViewCommand implements StoreCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		// 전달받은 데이터 옮겨주기
		long storeNo = Long.parseLong(request.getParameter("storeNo"));	

		
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		
		// 조회수 증가
		storeDAO.storeHit(storeNo);

		// 가게 불러오기
		StoreDTO store = storeDAO.storeView(storeNo);
		// storeDTO 전달 
		model.addAttribute("store", store);
	
		
	}

}