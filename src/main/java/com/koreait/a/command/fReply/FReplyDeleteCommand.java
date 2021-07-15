package com.koreait.a.command.fReply;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.FReplyDAO;

public class FReplyDeleteCommand {

	public Map<String, Object> execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		long fno = Long.parseLong(request.getParameter("fno"));
		
		FReplyDAO fReplyDAO = sqlSession.getMapper(FReplyDAO.class);
		// 공지사항 새글작성
		int result = fReplyDAO.fReplyDelete(fno);
		
		Map<String, Object> resultMap = new HashMap<>();
		if (result > 0) {
			resultMap.put("message", "댓글 삭제 완료");
		} else {
			resultMap.put("message", "댓글 삭제 실패");
		}
			
		return resultMap;

	}

}
