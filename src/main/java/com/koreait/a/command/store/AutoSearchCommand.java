package com.koreait.a.command.store;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.springframework.ui.Model;

import com.koreait.a.command.store.StoreCommand;
import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.StoreDTO;
import com.koreait.a.dto.StoreQueryDTO;

public class AutoSearchCommand implements StoreCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		StoreQueryDTO queryDTO = (StoreQueryDTO)map.get("queryDTO");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		List<StoreDTO> list = storeDAO.autoComplete(queryDTO);
		
	
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (list.size() == 0) {
			resultMap.put("status", 500);
			resultMap.put("list", null);
		} else {
			resultMap.put("status", 200);
			resultMap.put("list", list);
		}
		
		/* response */
		try {
			response.setContentType("text/html; charset=utf-8");
			JSONObject obj = new JSONObject(resultMap);
			response.getWriter().println(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
