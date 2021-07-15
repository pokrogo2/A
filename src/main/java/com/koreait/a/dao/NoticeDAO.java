package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.Notice;
import com.koreait.a.dto.PagingDTO;

public interface NoticeDAO {

	public List<Notice> selectNoticeList(PagingDTO pagingDTO);
	public int noticeTotalCount();
	public Notice noticeView(long no);
	public int noticeUpdate(Notice notice);
	public int hitUp(long no);
	public int noticeInsert(Notice notice);
	public int noticeDelete(long no);
}
