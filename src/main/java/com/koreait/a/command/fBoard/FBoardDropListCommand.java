package com.koreait.a.command.fBoard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession; 
import org.springframework.ui.Model;

import com.koreait.a.dao.FBoardDAO;
import com.koreait.a.dto.FBoardDTO;
import com.koreait.a.dto.FBoardQueryDTO;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.utils.PagingUtils;

public class FBoardDropListCommand {

	
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		FBoardDAO fBoardDAO = sqlSession.getMapper(FBoardDAO.class);
		
		String drop = request.getParameter("drop");
		int page = Integer.parseInt(request.getParameter("page"));
			
		
		FBoardQueryDTO fBoardQueryDTO = new FBoardQueryDTO();
		fBoardQueryDTO.setDrop(drop);
		
		
		int totalRecord = fBoardDAO.fBoardDropTotal(fBoardQueryDTO);
		totalRecord = totalRecord > 0 ? totalRecord : 1;
		
		int recordPerPage = 10;
		int pagePerBlock = 5;
		
		PagingDTO pagingDTO = PagingUtils.getPage(recordPerPage, pagePerBlock, totalRecord, page);
		fBoardQueryDTO.setBeginRecord(pagingDTO.getBeginRecord());
		fBoardQueryDTO.setEndRecord(pagingDTO.getEndRecord());
		
		
		List<FBoardDTO> list = fBoardDAO.fBoardDrop(fBoardQueryDTO);
		
		Map<String, Object> resultMap = new HashMap<>();
		if (list.size() > 0) {
			resultMap.put("list", list);
			resultMap.put("paging", pagingDTO);
			resultMap.put("dropTotal", totalRecord);
			resultMap.put("status", 200);
		} else {
			resultMap.put("list", null);
			resultMap.put("paging", pagingDTO);
			resultMap.put("dropTotal", 0);
			resultMap.put("status", 500);
		}

		return resultMap;

		
	}
}