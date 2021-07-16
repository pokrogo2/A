package com.koreait.a.command.store;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.Store;

public class SelectStoreByNoCommand implements StoreCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		long storeNo = Long.parseLong(request.getParameter("storeNo"));
		
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		Store store = storeDAO.selectStoreByNo(storeNo);
		
		model.addAttribute("store", store);
	
		

	}

}
