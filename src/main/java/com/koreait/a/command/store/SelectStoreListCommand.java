package com.koreait.a.command.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.Page;
import com.koreait.a.dto.Store;
import com.koreait.a.util.PagingUtils;

public class SelectStoreListCommand {


	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		int page = (int)map.get("page");
		
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		int totalRecord = storeDAO.getTotalStoreCount();
		
		Page paging = PagingUtils.getPage(totalRecord, page);
		
		List<Store> list = storeDAO.selectStoreList(paging);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("list", list);
		resultMap.put("paging", paging);
		return resultMap;
		
		
		
	}

}
