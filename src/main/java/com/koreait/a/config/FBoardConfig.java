package com.koreait.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.fBoard.FBoardDeleteCommand;
import com.koreait.a.command.fBoard.FBoardDropListCommand;
import com.koreait.a.command.fBoard.FBoardInsertCommand;
import com.koreait.a.command.fBoard.FBoardListCommand;
import com.koreait.a.command.fBoard.FBoardSearchListCommand;
import com.koreait.a.command.fBoard.FBoardUpdateCommand;
import com.koreait.a.command.fBoard.FBoardViewCommand;
import com.koreait.a.command.fReply.FReplyDeleteCommand;
import com.koreait.a.command.fReply.FReplyInsertCommand;
import com.koreait.a.command.fReply.FReplyListCommand;
@Configuration
public class FBoardConfig {
	/* Command - (FBoard) Bean생성  */
	@Bean
	public FBoardListCommand fBoardListCommand() {
		return new FBoardListCommand();
	}
	@Bean
	public FBoardInsertCommand fBoardInsertCommand() {
		return new FBoardInsertCommand();
	}
	@Bean
	public FBoardViewCommand fBoardViewCommand() {
		return new FBoardViewCommand();
	}
	@Bean
	public FBoardUpdateCommand fBoardUpdateCommand() {
		return new FBoardUpdateCommand();
	}
	@Bean
	public FBoardDeleteCommand fBoardDeleteCommand() {
		return new FBoardDeleteCommand();
	}
	@Bean
	public FBoardSearchListCommand FBoardSearchListCommand() {
		return new FBoardSearchListCommand();
	}
	@Bean
	public FBoardDropListCommand fBoardDropListCommand() {
		return new FBoardDropListCommand();
	}
	
	
	/* Command - (FReply) Bean생성  */
	@Bean
	public FReplyListCommand fReplyListCommand() {
		return new FReplyListCommand();
	}
	@Bean
	public FReplyInsertCommand fReplyInsertCommand() {
		return new FReplyInsertCommand();
	}
	@Bean
	public FReplyDeleteCommand fReplyDeleteCommand() {
		return new FReplyDeleteCommand();
	}
}
