package com.koreait.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.member.EmailAuthCommand;
import com.koreait.a.command.member.EmailCheckCommand;
import com.koreait.a.command.member.MemberDeleteCommand;
import com.koreait.a.command.member.MemberFindIdCommand;
import com.koreait.a.command.member.MemberFindPwCommand;
import com.koreait.a.command.member.MemberIdCheckCommand;
import com.koreait.a.command.member.MemberJoinCommand;
import com.koreait.a.command.member.MemberLoginCommand;
import com.koreait.a.command.member.MemberLogoutCommand;
import com.koreait.a.command.member.MemberUpdateCommand;

@Configuration
public class MemberConfig {
	//memberBean
			@Bean
			public MemberJoinCommand joinCommand() {
				return new MemberJoinCommand();
			}
			@Bean
			public EmailAuthCommand emailAuthCommand() {
				return new EmailAuthCommand();
			}
			@Bean
			public MemberIdCheckCommand idCheckCommand() {
				return new MemberIdCheckCommand();
			}
			@Bean
			public MemberLoginCommand loginCommand() {
				return new MemberLoginCommand();
			}
			@Bean
			public MemberLogoutCommand logoutCommand() {
				return new MemberLogoutCommand();
			}
			@Bean
			public EmailCheckCommand emailCheckCommand() {
				return new EmailCheckCommand();
			}
			@Bean
			public MemberFindIdCommand findIdCommand() {
				return new MemberFindIdCommand();
			}
			@Bean
			public MemberFindPwCommand findPwCommand() {
				return new MemberFindPwCommand();
			}
			@Bean
			public MemberDeleteCommand deleteCommand() {
				return new MemberDeleteCommand();
			}
			@Bean
			public MemberUpdateCommand memberUpdateCommand() {
				return new MemberUpdateCommand();
			}
			
}
