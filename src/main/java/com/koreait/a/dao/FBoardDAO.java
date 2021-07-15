package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.FBoard;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.dto.FBoardQueryDTO;

public interface FBoardDAO {

	// 자유 게시판 리스트 결과
	public List<FBoard> fBoardList(PagingDTO pagingDTO);
	public int fBoardTotalCount();
	
	// 자유 게시판 생성
	public int fBoardInsert(String writer, String contentType, String title, String content, String filename1);

	// 자유게시판 한개 결과
	public FBoard fBoardView(long no);
	
	// 자유 게시판 조회수 중가
	public int fBoardHitUp(long no);
	
	// 자유 게시판 수정
	public int fBoardUpdate(String contentType, String title, String content, String filename1, long no);

	// 자유 게시판 삭제
	public int fBoardDelete(long no);
	
	// 자유 게시판 검색
	public List<FBoard> fBoardSearch(FBoardQueryDTO fBoardQueryDTO);
	public int fBoardSearchTotal (FBoardQueryDTO fBoardQueryDTO);

	// 자유게시판 드롭에 따른 결과
	public List<FBoard> fBoardDrop(FBoardQueryDTO fBoardQueryDTO);
	public int fBoardDropTotal (FBoardQueryDTO fBoardQueryDTO);

}
