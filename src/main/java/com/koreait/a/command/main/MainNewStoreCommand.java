package com.koreait.a.command.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.MainDAO;
import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.MainStoreDTO;
import com.koreait.a.dto.StoreDTO;

public class MainNewStoreCommand implements MainCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		// 전달받는 파라미터가 없음
		
		// 전체 음식점 개수 (total)
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		int totalStore = storeDAO.storeTotalCount();
		long rnBegin = 1 ;
		long rnEnd = 4;
		rnEnd = rnEnd > totalStore ? totalStore : rnEnd;
		
		// 가장 최근에 등록된 음식점 4개 호출
		MainDAO mainDAO = sqlSession.getMapper(MainDAO.class);
		List<MainStoreDTO> list = mainDAO.mainStoreNew(rnBegin, rnEnd); 
		
		// json 데이터로 전달
		Map<String, Object> resultMap = new HashMap<>();
		
		if (list.size() > 0) {
			resultMap.put("newStore", list);
			resultMap.put("status", 200);
		} else {
			resultMap.put("newStore", null);
			resultMap.put("status", 500);
		}
		return resultMap;
		
	}

}
