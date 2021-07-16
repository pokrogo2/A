package com.koreait.a.command.Qnaboard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.a.dao.QnaBoardDAO;
import com.koreait.a.dto.QnaBoardDTO;

@Component
public class QnaBoardInsertCommand implements QnaBoardCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Map<String, Object> modelMap = model.asMap();
		HttpServletRequest request = (HttpServletRequest)modelMap.get("request");
		QnaBoardDTO qnaBoardDTO = new QnaBoardDTO();
		qnaBoardDTO.setId(((Member)request.getSession().getAttribute("loginMember")).getId());
		String content = request.getParameter("content");
		qnaBoardDTO.setContent(content);
		
		QnaBoardDAO dao = sqlSession.getMapper(QnaBoardDAO.class);
		dao.QnaBoardInsertCommand(qnaBoardDTO);
		return null;
		
	}

}
