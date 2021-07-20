package com.koreait.a.command.fReply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.FReplyDAO;
import com.koreait.a.dto.FReplyDTO;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.utils.PagingUtils;

public class FReplyListCommand {

	
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		FReplyDAO fReplyDAO = sqlSession.getMapper(FReplyDAO.class);
		
		long no = Long.parseLong(request.getParameter("no"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		
		int totalRecord = fReplyDAO.fReplyTotalCount(no);
		totalRecord = totalRecord > 0 ? totalRecord : 1;
		int recordPerPage = 5;
		int pagePerBlock = 5;
		PagingDTO pagingDTO = PagingUtils.getPage(recordPerPage, pagePerBlock, totalRecord, page);
		List<FReplyDTO> list = fReplyDAO.fReplyList(no, pagingDTO.getBeginRecord(), pagingDTO.getEndRecord());
		
		Map<String, Object> resultMap = new HashMap<>();
		if (list.size() > 0) {
			resultMap.put("list", list);
			resultMap.put("paging", pagingDTO);
			resultMap.put("status", 200);
		} else {
			resultMap.put("list", null);
			resultMap.put("paging", pagingDTO);
			resultMap.put("status", 500);
		}

		return resultMap;

		
	}
}