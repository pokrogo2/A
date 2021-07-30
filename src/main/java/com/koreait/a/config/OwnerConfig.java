package com.koreait.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.owner.OwnerDeleteCommand;
import com.koreait.a.command.owner.OwnerEmailCheckCommand;
import com.koreait.a.command.owner.OwnerFindPwCommand;
import com.koreait.a.command.owner.OwnerJoinCommand;
import com.koreait.a.command.owner.OwnerLoginCommand;
import com.koreait.a.command.owner.OwnerLogoutCommand;
import com.koreait.a.command.owner.OwnerNoCheckCommand;
@Configuration
public class OwnerConfig {
	
	@Bean
	public OwnerJoinCommand ownerJoinCommand() {
		return new OwnerJoinCommand();
	}

	@Bean
	public OwnerEmailCheckCommand ownerEmailCheckCommand() {
		return new OwnerEmailCheckCommand();
	}
	@Bean
	public OwnerNoCheckCommand ownerNoCheckCommand() {
		return new OwnerNoCheckCommand();
		
	}
	@Bean
	public OwnerFindPwCommand ownerPwCommand() {
		return new OwnerFindPwCommand();
	}
	@Bean
	public OwnerLoginCommand ownerLoginCommand() {
		return new OwnerLoginCommand();
	}
	@Bean
	public OwnerLogoutCommand ownerLogoutCommand() {
		return new OwnerLogoutCommand();
	}
	@Bean
	public OwnerDeleteCommand ownerDeleteCommand() {
		return new OwnerDeleteCommand();
	}
}
