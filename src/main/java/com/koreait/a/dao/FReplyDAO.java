package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.FReply;

public interface FReplyDAO {

	/*
	 		no : FBoard의 시퀀스
	 		fno : FReply의 시퀀스
	 */
	
	/*댓글 리스트 결과*/
	public List<FReply> fReplyList(long no, int beginRecord, int endRecord);
	public int fReplyTotalCount(long no);
	public int fReplyInsert(FReply fReply);
	public int fReplyDelete(long fno);
	
}
