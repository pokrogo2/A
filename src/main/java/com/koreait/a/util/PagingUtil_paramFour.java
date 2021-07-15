package com.koreait.a.util;

import com.koreait.a.dto.PagingDTO;

public class PagingUtil_paramFour {


	public static int beginRecord;
	public static int endRecord;

	public static int totalPage;
	public static int beginPage;
	public static int endPage;

	
	public static PagingDTO getPage(int recordPerPage, int pagePerBlock, int totalRecord, int page) {
		beginRecord = (page - 1) * recordPerPage + 1;
		endRecord = beginRecord + recordPerPage - 1;
		endRecord = endRecord > totalRecord ? totalRecord : endRecord;
		
		totalPage = (totalRecord / recordPerPage) + (totalRecord % recordPerPage > 0 ? 1 : 0);
		beginPage = ( (page - 1) / pagePerBlock ) * pagePerBlock + 1;
		endPage = beginPage + pagePerBlock - 1;
		endPage = endPage > totalPage ? totalPage : endPage;
		
		System.out.println(page);
		
		PagingDTO pagingDTO = new PagingDTO();
		pagingDTO.setPage(page);
		pagingDTO.setTotalRecord(totalRecord);
		pagingDTO.setRecordPerPage(recordPerPage);
		pagingDTO.setPagePerBlock(pagePerBlock);
		pagingDTO.setBeginRecord(beginRecord);
		pagingDTO.setEndRecord(endRecord);
		pagingDTO.setTotalPage(totalPage);
		pagingDTO.setBeginPage(beginPage);
		pagingDTO.setEndPage(endPage);
		
		return pagingDTO;
		
	}
	
}
