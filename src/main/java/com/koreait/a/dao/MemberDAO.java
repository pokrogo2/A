package com.koreait.a.dao;

import com.koreait.a.dto.MemberDTO;

public interface MemberDAO {
	public int join(MemberDTO member);
	
	public int idCheck(String id);
}
