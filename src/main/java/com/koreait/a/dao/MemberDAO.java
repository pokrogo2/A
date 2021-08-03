package com.koreait.a.dao;

import com.koreait.a.dto.MemberDTO;

public interface MemberDAO {
	public int join(MemberDTO member);
	
	public int idCheck(String id);
	public MemberDTO login(MemberDTO member);
	public int emailCheck(String email);
	public MemberDTO findId(String email);
	public MemberDTO findPw(String email);
	public int deleteChild(long no);
	public int delete(long no);
	public int updateMember(MemberDTO member);
	
}
