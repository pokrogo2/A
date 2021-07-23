package com.koreait.a.command.fReply;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.FReplyDAO;
import com.koreait.a.dto.FReplyDTO;

public class FReplyInsertCommand implements FReplyCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		FReplyDTO fReply = new FReplyDTO();
		fReply.setNo(Long.parseLong(request.getParameter("fBoardNo")));
		fReply.setWriter(request.getParameter("writer"));
		fReply.setContent(request.getParameter("fReply_content"));
		
		FReplyDAO fReplyDAO = sqlSession.getMapper(FReplyDAO.class);
		// 공지사항 새글작성
		int result = fReplyDAO.fReplyInsert(fReply);
		
		Map<String, Object> resultMap = new HashMap<>();
		if (result > 0) {
			resultMap.put("message", "댓글 입력 완료");
		} else {
			resultMap.put("message", "댓글 입력 실패");
		}
			
		return resultMap;

	}

}
