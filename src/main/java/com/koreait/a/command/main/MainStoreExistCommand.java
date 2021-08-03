package com.koreait.a.command.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.MainDAO;
import com.koreait.a.dto.MainStoreDTO;

public class MainStoreExistCommand implements MainCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		long ownerNo = Long.parseLong(request.getParameter("ownerNo"));
		
		MainDAO mainDAO = sqlSession.getMapper(MainDAO.class);
		int result = mainDAO.storeExist(ownerNo);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", result);
		
		if (result > 0) {
			MainStoreDTO storeDTO = mainDAO.storeExistStoreNo(ownerNo);
			resultMap.put("view", "storeView.do?storeNo="+storeDTO.getStoreNo());
		} else {
			resultMap.put("view", "storeInsertPage.do");
		}
			
		return resultMap;
		
	}

}
