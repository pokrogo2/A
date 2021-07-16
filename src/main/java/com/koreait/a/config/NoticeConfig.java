package com.koreait.a.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.notice.NoticeDeleteCommand;
import com.koreait.a.command.notice.NoticeInsertCommand;
import com.koreait.a.command.notice.NoticeUpdateCommand;
import com.koreait.a.command.notice.NoticeViewCommand;
import com.koreait.a.command.notice.NoticeListCommand;
@Configuration
public class NoticeConfig {

	/* Command - (Notice) Bean생성  */
	@Bean
	public NoticeListCommand selectNoticeListCommand() {
		return new NoticeListCommand();
	}
	@Bean
	public NoticeViewCommand noticeViewCommand() {
		return new NoticeViewCommand();
	}
	@Bean
	public NoticeUpdateCommand noticeUpdateCommand() {
		return new NoticeUpdateCommand();
	}
	@Bean
	public NoticeDeleteCommand noticeDeleteCommand() {
		return new NoticeDeleteCommand();
	}
	@Bean
	public NoticeInsertCommand noticeInsertCommand() {
		return new NoticeInsertCommand();
	}
}
