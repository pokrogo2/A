package com.koreait.a.command.reservation;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.ReservationDAO;
import com.koreait.a.dto.MemberDTO;
import com.koreait.a.dto.StoreResDTO;

public class ResMyPageCommand implements ReservationCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		
		
		MemberDTO loginUser =(MemberDTO)session.getAttribute("loginUser");
		ReservationDAO resDAO = sqlSession.getMapper(ReservationDAO.class);
		
		List<StoreResDTO> list = resDAO.memberMyPage(loginUser.getMemberNo());
		
		model.addAttribute("list1", list);
		
		
	}

}
