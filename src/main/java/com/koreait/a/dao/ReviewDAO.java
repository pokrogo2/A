package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.PagingDTO;
import com.koreait.a.dto.ReviewDTO;

public interface ReviewDAO {

	public int getTotalRecord();
	//public List<ReviewDTO> searchAll(PagingDTO pageDTO);
	public List<ReviewDTO> selectOne(String writer);
	public int insertReview(ReviewDTO review);
	public int deleteReview(long no);
	public ReviewDTO updateSelect(long no);
	public int updateReview(ReviewDTO review);
}
