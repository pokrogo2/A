package com.koreait.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.reservation.ResDeleteCommand;
import com.koreait.a.command.reservation.ResInsertCommand;
import com.koreait.a.command.reservation.ResMyPageCommand;
import com.koreait.a.command.reservation.ResViewCommand;

@Configuration
public class ResConfig {

	@Bean
	public ResInsertCommand resInsertCommand() {
		return new ResInsertCommand();
	}
	
	@Bean
	public ResViewCommand resViewCommand() {
		return new ResViewCommand();
	}
	@Bean
	public ResMyPageCommand resMyPageCommand() {
		return new ResMyPageCommand();
	}
	@Bean
	public ResDeleteCommand resDeleteCommand() {
		return new ResDeleteCommand();
	}
}
