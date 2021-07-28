package com.koreait.a.command.reservation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.ReservationDAO;
import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.StoreDTO;
import com.koreait.a.dto.StoreResDTO;

public class ResViewCommand implements ReservationCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		// 전달받은 데이터 옮겨주기
		long resNo = Long.parseLong(request.getParameter("resNo"));	
		// long storeNo = Long.parseLong(request.getParameter("storeNo"));
		
		ReservationDAO resDAO = sqlSession.getMapper(ReservationDAO.class);

		// 예약 불러오기
		StoreResDTO res = resDAO.resView(resNo);
		
		// storeResDTO 전달 
		model.addAttribute("res", res);
				
		
		
		
	}

}
