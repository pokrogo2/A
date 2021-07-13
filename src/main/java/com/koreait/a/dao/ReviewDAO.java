package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.PageDTO;
import com.koreait.a.dto.ReviewDTO;

public interface ReviewDAO {

	public int getTotalRecord();
	//public List<ReviewDTO> searchAll(PageDTO pageDTO);
	public List<ReviewDTO> selectOne(String loginId);
}
