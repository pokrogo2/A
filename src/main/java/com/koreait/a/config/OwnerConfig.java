package com.koreait.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.owner.OwnerEmailCheckCommand;
import com.koreait.a.command.owner.JoinCommand;
import com.koreait.a.command.owner.NoCheckCommand;
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
}
