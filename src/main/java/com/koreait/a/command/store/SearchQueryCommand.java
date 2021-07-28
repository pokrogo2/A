package com.koreait.a.command.store;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.dto.StoreDTO;
import com.koreait.a.dto.StoreQueryDTO;
import com.koreait.a.utils.PagingUtils;

public class SearchQueryCommand implements StoreCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		
		String column = request.getParameter("column");
		String query = request.getParameter("query");
		
		StoreQueryDTO queryDTO = new StoreQueryDTO();
		queryDTO.setColumn(column);
		queryDTO.setQuery(query);
		
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		int searchRecord = storeDAO.storeSearchRecord(queryDTO);
		int totalRecord = storeDAO.storeTotalCount();
		int recordPerPage = 5;   // 1 페이지당 5개 목록 
		int pagePerBlock = 5;	// 1 블록당 5개 페이지   
		
		
		PagingDTO pagingDTO = PagingUtils.getPage(recordPerPage, pagePerBlock, totalRecord, page);
		
		queryDTO.setBeginRecord(pagingDTO.getBeginPage());
		queryDTO.setEndRecord(pagingDTO.getEndPage());

		
		
		
		
		
		
		
		List<StoreDTO> list = storeDAO.storeSearch(queryDTO);
		
		String paging = null;
		
			paging = PagingUtils.getPaging("storeSearch.do?column=" + column + "&query=" + query, page);			
	
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);

	}

}
