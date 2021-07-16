package com.koreait.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.a.command.review.ReviewListCommand;
@Configuration
public class ReviewConfig {

	//reviewBean
		@Bean
		public ReviewListCommand selectReviewListCommand() {
			return new ReviewListCommand();
		}
		
}
