package com.koreait.a.command.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.NoticeDAO;
import com.koreait.a.dto.Notice;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.util.PagingUtil_paramFour;

public class SelectNoticeListCommand {

	
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		NoticeDAO noticeDAO = sqlSession.getMapper(NoticeDAO.class);
		
		int page = Integer.parseInt(request.getParameter("page"));
		int totalRecord = noticeDAO.noticeTotalCount();
		int recordPerPage = 10;
		int pagePerBlock = 5;
		
		PagingDTO pagingDTO = PagingUtil_paramFour.getPage(recordPerPage, pagePerBlock, totalRecord, page);
		List<Notice> list = noticeDAO.selectNoticeList(pagingDTO);
		
		
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