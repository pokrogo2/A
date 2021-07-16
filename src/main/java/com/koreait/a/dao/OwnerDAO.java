package com.koreait.a.dao;

import com.koreait.a.dto.OwnerDTO;

public interface OwnerDAO {
	public int join(OwnerDTO owner);
	public int emailCheck(String email);
	public int noCheck(String no);
}