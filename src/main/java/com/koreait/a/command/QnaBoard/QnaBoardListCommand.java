package com.koreait.a.command.QnaBoard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.QnaBoardDAO;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.dto.QnaBoardDTO;
import com.koreait.a.utils.PagingUtils;

public class QnaBoardListCommand{

	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		QnaBoardDAO qnaBoardDAO = sqlSession.getMapper(QnaBoardDAO.class);
		
		int page = Integer.parseInt(request.getParameter("page"));
		int totalRecord = qnaBoardDAO.qnaBoardTotalCount();
		int recordPerPage = 10;
		int pagePerBlock = 5;
		
		PagingDTO pagingDTO = PagingUtils.getPage(recordPerPage, pagePerBlock, totalRecord, page);
		List<QnaBoardDTO> list = qnaBoardDAO.selectQnaBoardList(pagingDTO);
		
		Map<String, Object> resultMap = new HashMap<>();
		if(list.size() > 0) {
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
