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
import com.koreait.a.utils.PagingUtils;

public class StoreListAllCommand implements StoreCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		int totalRecord = storeDAO.storeTotalCount();
		int recordPerPage = 5;   // 1 페이지당 5개 목록 
		int pagePerBlock = 5;	// 1 블록당 5개 페이지   
		
		PagingDTO pagingDTO = PagingUtils.getPage(recordPerPage, pagePerBlock, totalRecord, page);
		
		List<StoreDTO> list = storeDAO.storeList(pagingDTO);
		String paging = PagingUtils.getPaging("storeList.do", page);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		model.addAttribute("totalRecord", totalRecord);
		
		
	}

}