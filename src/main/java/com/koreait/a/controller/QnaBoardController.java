package com.koreait.a.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.a.command.Qnaboard.QnaBoardInsertCommand;

@Controller
@RequestMapping
public class QnaBoardController {
	private SqlSession sqlSession;
	private QnaBoardInsertCommand qnaBoardInsertCommand;
	
	@Autowired
	public QnaBoardController(
			SqlSession sqlSession,
			QnaBoardInsertCommand qnaBoardInsertCommand
			) {
		super();
		this.sqlSession = sqlSession;
		this.qnaBoardInsertCommand = qnaBoardInsertCommand;
	}
	
	// 게시글 작성
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String insert(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		qnaBoardInsertCommand.execute(sqlSession, model);
		return "redirect:list.do";
	}

}
