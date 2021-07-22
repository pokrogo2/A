package com.koreait.a.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.koreait.a.command.store.StoreDeleteCommand;
import com.koreait.a.command.store.StoreInsertCommand;
import com.koreait.a.command.store.StoreListCommand;
import com.koreait.a.command.store.StoreUpdateCommand;
import com.koreait.a.command.store.StoreViewCommand;
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
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("utf-8");
		multipartResolver.setMaxUploadSize(1024 * 1024 * 10);  
		return multipartResolver;
	}
	
	
	@Bean
	public StoreInsertCommand storeInsertCommand() {
		return new StoreInsertCommand();
	}
	
	@Bean
	public StoreListCommand storeListCommand() {
		return new StoreListCommand();
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
	

	
}
