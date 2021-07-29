package com.koreait.a.command.store;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.springframework.ui.Model;

import com.koreait.a.dao.FBoardDAO;
import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.FBoardDTO;
import com.koreait.a.dto.FBoardQueryDTO;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.dto.StoreDTO;
import com.koreait.a.dto.StoreQueryDTO;
import com.koreait.a.utils.PagingUtils;

public class SearchLineUpCommand {

	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
			
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		String searchLineUp = request.getParameter("searchLineUp");
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
			
		StoreQueryDTO queryDTO = new StoreQueryDTO();
		queryDTO.setSearchLineUp(searchLineUp);
		
		int searchRecord = storeDAO.storeSearchRecord(queryDTO);
		int totalRecord = storeDAO.storeTotalCount();
		int recordPerPage = 5;   // 1 페이지당 5개 목록 
		int pagePerBlock = 5;	// 1 블록당 5개 페이지   
		
		PagingDTO pagingDTO = PagingUtils.getPage(recordPerPage, pagePerBlock, totalRecord, page);
		
		queryDTO.setBeginRecord(pagingDTO.getBeginPage());
		queryDTO.setEndRecord(pagingDTO.getEndPage());
		
		
		List<StoreDTO> list = storeDAO.storeSearch(queryDTO);
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
		


		return resultMap;

	}
	
}
