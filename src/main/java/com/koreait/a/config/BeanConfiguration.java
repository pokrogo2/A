package com.koreait.a.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.koreait.a.command.owner.EmailAuthCommand;
import com.koreait.a.command.owner.EmailCheckCommand;
import com.koreait.a.command.owner.JoinCommand;
import com.koreait.a.command.owner.NoCheckCommand;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class BeanConfiguration {

	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		hikariConfig.setUsername("projectA");
		hikariConfig.setPassword("1111");
		return hikariConfig;
	}
	
	@Bean(destroyMethod="close")
	public HikariDataSource hikariDataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(hikariDataSource());
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/koreait/a/dao/*.xml"));
		return sqlSessionFactory.getObject();
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("utf-8");
		multipartResolver.setMaxUploadSize(1024 * 1024 * 10);  // 바이트 단위(10MB)
		return multipartResolver;
	}
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	@Bean
	public JoinCommand joinCommand() {
		return new JoinCommand();
	}
	@Bean
	public EmailAuthCommand emailAuthCommand() {
		return new EmailAuthCommand();
	}
	@Bean
	public EmailCheckCommand emailCheckCommand() {
		return new EmailCheckCommand();
	}
	@Bean
	public NoCheckCommand noCheckCommand() {
		return new NoCheckCommand();
	}
	
}