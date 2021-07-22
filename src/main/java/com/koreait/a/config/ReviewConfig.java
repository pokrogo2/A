package com.koreait.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.review.ReviewDeleteCommand;
import com.koreait.a.command.review.ReviewInsertCommand;
import com.koreait.a.command.review.ReviewListCommand;
import com.koreait.a.command.review.ReviewUpdateCommand;
import com.koreait.a.command.review.ReviewUpdatePageCommand;
@Configuration
public class ReviewConfig {

	//reviewBean
		@Bean
		public ReviewListCommand reviewListCommand() {
			return new ReviewListCommand();
		}
		@Bean
		public ReviewInsertCommand reviewInsertCommand() {
			return new ReviewInsertCommand();
		}
		@Bean
		public ReviewDeleteCommand reviewDeleteCommand() {
			return new ReviewDeleteCommand();
		}
		@Bean
		public ReviewUpdatePageCommand reviewUpdatePageCommand() {
			return new ReviewUpdatePageCommand();
		}
		@Bean
		public ReviewUpdateCommand reviewUpdateCommand() {
			return new ReviewUpdateCommand();
		}
}
