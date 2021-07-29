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
import com.koreait.a.command.main.LocalSelectCommand;
import com.koreait.a.command.main.MainCommand;
import com.koreait.a.command.main.MainNewStoreCommand;
import com.koreait.a.command.main.MainRecommandStoreCommand;
import com.koreait.a.command.main.MainSearchStoreCommand;
import com.koreait.a.command.main.MainStoreExistCommand;
import com.koreait.a.command.main.ZoneSelectCommand;
@Configuration
public class MainConfig {
	
	/* Command - (Main) Bean생성  */
	@Bean
	public ZoneSelectCommand zoneSelectCommand() {
		return new ZoneSelectCommand();
	}
	
	@Bean
	public LocalSelectCommand localSelectCommand() {
		return new LocalSelectCommand();
	}
	
	@Bean
	public MainSearchStoreCommand mainSearchStoreCommand() {
		return new MainSearchStoreCommand();
	}
	
	@Bean
	public MainStoreExistCommand mainStoreExistCommand() {
		return new MainStoreExistCommand();
	}
	
	@Bean
	public MainRecommandStoreCommand mainRecommandStoreCommand() {
		return new MainRecommandStoreCommand();
	}
	
	@Bean
	public MainNewStoreCommand mainNewStoreCommand() {
		return new MainNewStoreCommand();
	}
	
}
