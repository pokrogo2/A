package com.koreait.a.command.fBoard;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession; 
import org.springframework.ui.Model;

import com.koreait.a.dao.FBoardDAO;
import com.koreait.a.dto.FBoard;
import com.koreait.a.dto.FBoardQueryDTO;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.util.PagingUtil_paramFour;

public class FBoardSearchListCommand {

	
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		FBoardDAO fBoardDAO = sqlSession.getMapper(FBoardDAO.class);
		
		String column = request.getParameter("column");
		String query = request.getParameter("query");
		String strPage = request.getParameter("page");
		int page = Integer.parseInt(strPage);
			
		
		FBoardQueryDTO fBoardQueryDTO = new FBoardQueryDTO();
		fBoardQueryDTO.setColumn(column);
		fBoardQueryDTO.setQuery(query);
		
		
		int totalRecord = fBoardDAO.fBoardSearchTotal(fBoardQueryDTO);		
		totalRecord = totalRecord > 0 ? totalRecord : 1;
		
		
		int recordPerPage = 10;
		int pagePerBlock = 5;
		
		PagingDTO pagingDTO = PagingUtil_paramFour.getPage(recordPerPage, pagePerBlock, totalRecord, page);
		fBoardQueryDTO.setBeginRecord(pagingDTO.getBeginRecord());
		fBoardQueryDTO.setEndRecord(pagingDTO.getEndRecord());
		
		
		List<FBoard> list = fBoardDAO.fBoardSearch(fBoardQueryDTO);
		
		Map<String, Object> resultMap = new HashMap<>();
		if (list.size() > 0) {
			resultMap.put("list", list);
			resultMap.put("paging", pagingDTO);
			resultMap.put("searchTotal", totalRecord);
			resultMap.put("status", 200);
		} else {
			resultMap.put("list", null);
			resultMap.put("paging", pagingDTO);
			resultMap.put("searchTotal", 0);
			resultMap.put("status", 500);
		}

		return resultMap;

		
	}
}