package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.NoticeDTO;
import com.koreait.a.dto.PagingDTO;

public interface NoticeDAO {

	public List<NoticeDTO> selectNoticeList(PagingDTO pagingDTO);
	public int noticeTotalCount();
	public NoticeDTO noticeView(long no);
	public int noticeUpdate(NoticeDTO notice);
	public int hitUp(long no);
	public int noticeInsert(NoticeDTO notice);
	public int noticeDelete(long no);
}
