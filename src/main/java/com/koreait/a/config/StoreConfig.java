package com.koreait.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.store.AutoSearchCommand;
import com.koreait.a.command.store.SearchOrderCommand;
import com.koreait.a.command.store.SearchQueryCommand;
import com.koreait.a.command.store.StoreDeleteCommand;
import com.koreait.a.command.store.StoreInsertCommand;
import com.koreait.a.command.store.StoreListCommand;
import com.koreait.a.command.store.StoreUpdateCommand;
import com.koreait.a.command.store.StoreViewCommand;


@Configuration
public class StoreConfig {
	
	@Bean
	public StoreInsertCommand storeInsertCommand() {
		return new StoreInsertCommand();
	}
	
	@Bean
	public StoreListCommand storeListCommand() {
		return new StoreListCommand();
	}
	

	@Bean
	public AutoSearchCommand autoCompleteCommand() {
		return new AutoSearchCommand();
	}
	
	@Bean
	public SearchQueryCommand searchQueryCommand() {
		return new SearchQueryCommand();
	}
	
	
	@Bean
	public StoreViewCommand storeViewCommand() {
		return new StoreViewCommand();
	}
	
	@Bean
	public StoreUpdateCommand storeUpdateCommand() {
		return new StoreUpdateCommand();
	}
	
	@Bean
	public StoreDeleteCommand storeDeleteCommand() {
		return new StoreDeleteCommand();
	}
	
	@Bean
	public SearchOrderCommand searchOrderCommand() {
		return new SearchOrderCommand();
	}
	
	

	
}