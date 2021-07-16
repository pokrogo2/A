package com.koreait.a.utils;

import com.koreait.a.dto.PagingDTO;

public class PagingUtils {

	// field
	public static int recordPerPage;
	public static int beginRecord;
	public static int endRecord;
	
	public static int pagePerBlock;
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
	
	
	public static PagingDTO getLoginPage(String loginId,int totalRecord, int page) {
		
		beginRecord = (page - 1) * recordPerPage + 1;
		endRecord = beginRecord + recordPerPage - 1;
		endRecord = endRecord < totalRecord ? endRecord : totalRecord;
		
		totalPage = (totalRecord / recordPerPage) + (totalRecord % recordPerPage > 0 ? 1 : 0);
		beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
		endPage = beginPage + pagePerBlock - 1;
		endPage = endPage < totalPage ? endPage : totalPage;
		
		PagingDTO pagingDTO = new PagingDTO();
		pagingDTO.setPage(page);
		pagingDTO.setTotalRecord(totalRecord);
		pagingDTO.setRecordPerPage(recordPerPage);
		pagingDTO.setBeginRecord(beginRecord);
		pagingDTO.setEndRecord(endRecord);
		pagingDTO.setTotalPage(totalPage);
		pagingDTO.setPagePerBlock(pagePerBlock);
		pagingDTO.setBeginPage(beginPage);
		pagingDTO.setEndPage(endPage);
		pagingDTO.setLoginId(loginId);
		
		return pagingDTO;
		
	}
	
	// << 1 2 3 4 5 >> 반환
	public static String getPaging(String path, int page) {
		
		StringBuilder sb = new StringBuilder();
		
		if (beginPage <= pagePerBlock) {
			sb.append("◀&nbsp;");
		} else {
			sb.append("<a href=\"" + path + "?page=" + (beginPage - 1) + "\">◀</a>&nbsp;");
		}
		
		for (int p = beginPage; p <= endPage; p++) {
			if (p == page) {
				sb.append(p + "&nbsp;");
			} else {
				sb.append("<a href=\"" + path + "?page=" + p + "\">" + p + "</a>&nbsp;");
			}
		}
		
		if (endPage == totalPage) {
			sb.append("▶");
		} else {
			sb.append("<a href=\"" + path + "?page=" + (endPage + 1) + "\">▶</a>");
		}
		
		return sb.toString();
		
	}
	
}