package com.koreait.a.command.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.MainDAO;
import com.koreait.a.dto.LocationDTO;

public class ZoneSelectCommand implements MainCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		// 전달받은 파라미터가 없다.
		
		// LOCATION 테이블의 지역 정보를 가지고 온다 (중복 값 체크)
		MainDAO mainDAO = sqlSession.getMapper(MainDAO.class);
		List<LocationDTO> list = mainDAO.zoneSelect();

		
		// json 데이터로 전달해주기 위해서 진행
		Map<String, Object> resultMap = new HashMap<>();
		if (list.size() > 0) {
			resultMap.put("zoneList", list);
			resultMap.put("status", 200);
		} else {
			resultMap.put("zoneList", null);
			resultMap.put("status", 500);			
		}
		
		
		return resultMap;
	}

}
