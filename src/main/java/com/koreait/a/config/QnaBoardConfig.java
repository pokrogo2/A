package com.koreait.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.QnaBoard.QnaBoardDeleteCommand;
import com.koreait.a.command.QnaBoard.QnaBoardInsertCommand;
import com.koreait.a.command.QnaBoard.QnaBoardListCommand;
import com.koreait.a.command.QnaBoard.QnaBoardUpdateCommand;
import com.koreait.a.command.QnaBoard.QnaBoardViewCommand;

@Configuration
public class QnaBoardConfig {
	
	@Bean
	public QnaBoardListCommand qnaBoardListCommand() {
		return new QnaBoardListCommand();		
	}
	
	@Bean
	public QnaBoardViewCommand qnaBoardViewCommand() {
		return new QnaBoardViewCommand();
	}
	
	@Bean
	public QnaBoardUpdateCommand qnaBoardUpdateCommand() {
		return new QnaBoardUpdateCommand();
	}
	
	@Bean
	public QnaBoardDeleteCommand qnaBoardDeleteCommand() {
		return new QnaBoardDeleteCommand();
	}
	
	@Bean
	public QnaBoardInsertCommand qnaBoardInsertCommand() {
		return new QnaBoardInsertCommand();
	}

}
