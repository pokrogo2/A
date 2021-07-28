package com.koreait.a.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.a.command.QnaBoard.QnaBoardDeleteCommand;
import com.koreait.a.command.QnaBoard.QnaBoardInsertCommand;
import com.koreait.a.command.QnaBoard.QnaBoardListCommand;
import com.koreait.a.command.QnaBoard.QnaBoardUpdateCommand;
import com.koreait.a.command.QnaBoard.QnaBoardViewCommand;

@Controller
public class QnaBoardController {
	
	private SqlSession sqlSession;
	private QnaBoardListCommand selectQnaBoardListCommand;
	private QnaBoardViewCommand qnaBoardViewCommand;
	private QnaBoardUpdateCommand qnaBoardUpdateCommand;
	private QnaBoardDeleteCommand qnaBoardDeleteCommand;
	private QnaBoardInsertCommand qnaBoardInsertCommand;
	
	@Autowired
	public QnaBoardController(SqlSession sqlSession, QnaBoardListCommand selectQnaBoardListCommand
							, QnaBoardViewCommand qnaBoardViewCommand
							, QnaBoardUpdateCommand qnaBoardUpdateCommand
							, QnaBoardDeleteCommand qnaBoardDeleteCommand
							, QnaBoardInsertCommand qnaBoardInsertCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectQnaBoardListCommand = selectQnaBoardListCommand;
		this.qnaBoardViewCommand = qnaBoardViewCommand;
		this.qnaBoardUpdateCommand = qnaBoardUpdateCommand;
		this.qnaBoardDeleteCommand = qnaBoardDeleteCommand;
		this.qnaBoardInsertCommand = qnaBoardInsertCommand;
	}
	
	@GetMapping(value="qnaBoardPage.do")
	public String qnaBoardPage() {
		return "QnaBoard/QnaBoard";
	}
	
	@GetMapping(value="qnaBoardList.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> qnaBoardList(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return selectQnaBoardListCommand.execute(sqlSession, model);
	}
	
	@GetMapping(value="qnaBoardView.do")
	public String qnaboardView(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		qnaBoardViewCommand.execute(sqlSession, model);
		return "QnaBoard/QnaBoardView";
	}
	
	@GetMapping(value="qnaBoardUpdatePage.do")
	public String qnaBoardUpdatePage(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		qnaBoardViewCommand.execute(sqlSession, model);
		return "QnaBoard/QnaBoardUpdate";
	}
	@PostMapping(value="qnaBoardUpdate.do")
	public void qnaBoardUpdate(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		qnaBoardUpdateCommand.execute(sqlSession, model);
	}
	
	@GetMapping(value="qnaBoardDelete.do")
	public void qnaBoardDelete(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		qnaBoardDeleteCommand.execute(sqlSession, model);
	}
	
	@GetMapping(value="qnaBoardInsertPage.do")
	public String qnaBoardInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return "QnaBoard/QnaBoardInsert";
	}
	@PostMapping(value="qnaBoardInsert.do")
	public void qnaBoardInsert(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		qnaBoardInsertCommand.execute(sqlSession, model);
	}
	

}
