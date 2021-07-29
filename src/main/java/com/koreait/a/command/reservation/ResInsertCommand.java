package com.koreait.a.command.reservation;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.ReservationDAO;
import com.koreait.a.dto.StoreResDTO;

public class ResInsertCommand implements ReservationCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");

		
		StoreResDTO res = new StoreResDTO();
		res.setStoreNo(Long.parseLong(request.getParameter("storeNo")));
		res.setMemberNo(Long.parseLong(request.getParameter("memberNo")));
		res.setResDate(request.getParameter("resDate"));
		res.setResHours(request.getParameter("resHours"));
		res.setResPeople(request.getParameter("resPeople"));
		res.setResNote(request.getParameter("resNote"));
		
		ReservationDAO resDAO = sqlSession.getMapper(ReservationDAO.class);

		/* response */
		response.setContentType("text/html; charset=utf-8"); 
		
		int count = resDAO.resInsert(res);
		long resNo = 0;

		try {
		if (count > 0) {  
			resNo = resDAO.findResNoRecentlyInserted();
			response.getWriter().println("<script>");
			response.getWriter().println("alert('예약이 완료되었습니다.')");
			response.getWriter().println("location.href = 'resView.do?resNo=" + resNo +"'");
			response.getWriter().println("</script>");
		} else {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('예약 중 오류가 발생했습니다.')");
			response.getWriter().println("history.back()");
			response.getWriter().println("</script>");
		}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

}
