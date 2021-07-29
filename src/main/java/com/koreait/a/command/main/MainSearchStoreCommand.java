package com.koreait.a.command.main;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.MainDAO;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.dto.SearchStoreQueryDTO;
import com.koreait.a.dto.StoreDTO;
import com.koreait.a.utils.PagingUtils;

public class MainSearchStoreCommand {

	public void execute(SqlSession sqlSession, Model model) {
		
		// 전달받은 파라미터 
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String zone = request.getParameter("zone");
		String local = request.getParameter("local");
		String catg = request.getParameter("catg");
		String query = request.getParameter("query");
		
		// 검색에 필요한 파라미터를 담아 줄 DTO
		SearchStoreQueryDTO queryDTO = new SearchStoreQueryDTO();
		queryDTO.setZone(zone);
		queryDTO.setLocal(local);
		queryDTO.setCatg(catg);
		queryDTO.setQuery(query);
		
		MainDAO mainDAO = sqlSession.getMapper(MainDAO.class);
		
		// 페이징 처리
		int totalRecord = mainDAO.searchStoreTotal(queryDTO);
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		int recordPerPage = 5;   // 1 페이지당 5개 목록 
		int pagePerBlock = 5;	// 1 블록당 5개 페이지   
		
		PagingDTO pagingDTO = PagingUtils.getPage(recordPerPage, pagePerBlock, totalRecord, page);
		//beginRecord와 endRecord를 DTO에 담아준다.
		queryDTO.setBeginRecord(pagingDTO.getBeginRecord());
		queryDTO.setEndRecord(pagingDTO.getEndRecord());
		
		
		// 검색결과의 음식점 리스트 및 페이징 
		List<StoreDTO> list = mainDAO.searchStore(queryDTO);
		String paging = PagingUtils.getPaging("storeList.do", page);
		
		// model에 담고 view에 뿌려준다
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		model.addAttribute("totalRecord", totalRecord);
		
	}
	
}
