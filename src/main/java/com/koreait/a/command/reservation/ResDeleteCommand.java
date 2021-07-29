package com.koreait.a.command.reservation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.ReservationDAO;
import com.koreait.a.dao.ReviewDAO;

public class ResDeleteCommand implements ReservationCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		long resNo = Long.parseLong(request.getParameter("resNo"));
		
		ReservationDAO resDAO = sqlSession.getMapper(ReservationDAO.class);
		resDAO.resDelete(resNo);
	}

}
