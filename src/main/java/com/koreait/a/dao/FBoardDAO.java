package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.FBoardDTO;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.dto.FBoardQueryDTO;

public interface FBoardDAO {

	// 자유 게시판 리스트 결과
	public List<FBoardDTO> fBoardList(PagingDTO pagingDTO);
	public int fBoardTotalCount();
	
	// 자유 게시판 생성
	public int fBoardInsert(FBoardDTO fBoardDTO);

	// 자유게시판 한개 결과
	public FBoardDTO fBoardView(long no);
	
	// 자유 게시판 조회수 중가
	public int fBoardHitUp(long no);
	
	// 자유 게시판 수정
	public int fBoardUpdate(FBoardDTO fBoardDTO);

	// 자유 게시판 삭제
	public int fBoardDelete(long no);
	
	// 자유 게시판 검색
	public List<FBoardDTO> fBoardSearch(FBoardQueryDTO fBoardQueryDTO);
	public int fBoardSearchTotal (FBoardQueryDTO fBoardQueryDTO);

	// 자유게시판 드롭에 따른 결과
	public List<FBoardDTO> fBoardDrop(FBoardQueryDTO fBoardQueryDTO);
	public int fBoardDropTotal (FBoardQueryDTO fBoardQueryDTO);

}
