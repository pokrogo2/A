package com.koreait.a.command.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.MainDAO;
import com.koreait.a.dto.LocationDTO;

public class LocalSelectCommand implements MainCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {

		// 받아온 파라미터 
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String zone = request.getParameter("zone");
		
		// 지역에 따라 해당하는 구의 리스트를 가져온다. & json 데이터로 전달해준다
		MainDAO mainDAO = sqlSession.getMapper(MainDAO.class);
		
		Map<String, Object> resultMap = new HashMap<>();

		if (zone !=null && !zone.equals("")) {
			List<LocationDTO> list = mainDAO.localSelect(zone);
			if (list.size() > 0) {
				resultMap.put("localList", list);
				resultMap.put("status", 200);
			} else {
				resultMap.put("status", 500);
			}
		}
		
		return resultMap;
	}

}
