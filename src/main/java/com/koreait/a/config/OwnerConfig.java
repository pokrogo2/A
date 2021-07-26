package com.koreait.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.owner.JoinCommand;
import com.koreait.a.command.owner.NoCheckCommand;
import com.koreait.a.command.owner.OwnerDeleteCommand;
import com.koreait.a.command.owner.OwnerEmailCheckCommand;
import com.koreait.a.command.owner.OwnerFindPwCommand;
import com.koreait.a.command.owner.OwnerLoginCommand;
import com.koreait.a.command.owner.OwnerLogoutCommand;
@Configuration
public class OwnerConfig {
	
	@Bean
	public JoinCommand joinCommand() {
		return new JoinCommand();
	}

	@Bean
	public OwnerEmailCheckCommand ownerEmailCheckCommand() {
		return new OwnerEmailCheckCommand();
	}
	@Bean
	public NoCheckCommand noCheckCommand() {
		return new NoCheckCommand();
		
	}
	@Bean
	public OwnerFindPwCommand ownerPwCommand() {
		return new OwnerFindPwCommand();
	}
	@Bean
	public OwnerLoginCommand loginCommand() {
		return new OwnerLoginCommand();
	}
	@Bean
	public OwnerLogoutCommand logoutCommand() {
		return new OwnerLogoutCommand();
	}
	@Bean
	public OwnerDeleteCommand deleteCommand() {
		return new OwnerDeleteCommand();
	}
}
