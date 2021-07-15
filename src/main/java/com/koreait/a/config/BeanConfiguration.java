package com.koreait.a.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.koreait.a.command.fBoard.FBoardDeleteCommand;
import com.koreait.a.command.fBoard.FBoardDropListCommand;
import com.koreait.a.command.fBoard.FBoardInsertCommand;
import com.koreait.a.command.fBoard.FBoardListCommand;
import com.koreait.a.command.fBoard.FBoardUpdateCommand;
import com.koreait.a.command.fBoard.FBoardViewCommand;
import com.koreait.a.command.fBoard.FBoardSearchListCommand;
import com.koreait.a.command.fReply.FReplyDeleteCommand;
import com.koreait.a.command.fReply.FReplyInsertCommand;
import com.koreait.a.command.fReply.FReplyListCommand;
import com.koreait.a.command.member.EmailAuthCommand;
import com.koreait.a.command.member.EmailCheckCommand;
import com.koreait.a.command.member.FindIdCommand;
import com.koreait.a.command.member.FindPwCommand;
import com.koreait.a.command.member.IdCheckCommand;
import com.koreait.a.command.member.JoinCommand;
import com.koreait.a.command.member.LoginCommand;
import com.koreait.a.command.member.LogoutCommand;
import com.koreait.a.command.notice.NoticeDeleteCommand;
import com.koreait.a.command.notice.NoticeInsertCommand;
import com.koreait.a.command.notice.NoticeUpdateCommand;
import com.koreait.a.command.notice.NoticeViewCommand;
import com.koreait.a.command.notice.SelectNoticeListCommand;
import com.koreait.a.command.review.SelectReviewListCommand;
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
	//reviewBean
	@Bean
	public SelectReviewListCommand selectReviewListCommand() {
		return new SelectReviewListCommand();
	}
	//memberBean
	@Bean
	public JoinCommand joinCommand() {
		return new JoinCommand();
	}
	@Bean
	public EmailAuthCommand emailAuthCommand() {
		return new EmailAuthCommand();
	}
	@Bean
	public IdCheckCommand idCheckCommand() {
		return new IdCheckCommand();
	}
	@Bean
	public LoginCommand loginCommand() {
		return new LoginCommand();
	}
	@Bean
	public LogoutCommand logoutCommand() {
		return new LogoutCommand();
	}
	@Bean
	public EmailCheckCommand emailCheckCommand() {
		return new EmailCheckCommand();
	}
	@Bean
	public FindIdCommand findIdCommand() {
		return new FindIdCommand();
	}
	@Bean
	public FindPwCommand findPwCommand() {
		return new FindPwCommand();
	}
	
	
	
	
	/* Command - (Notice) Bean생성  */
	@Bean
	public SelectNoticeListCommand selectNoticeListCommand() {
		return new SelectNoticeListCommand();
	}
	@Bean
	public NoticeViewCommand noticeViewCommand() {
		return new NoticeViewCommand();
	}
	@Bean
	public NoticeUpdateCommand noticeUpdateCommand() {
		return new NoticeUpdateCommand();
	}
	@Bean
	public NoticeDeleteCommand noticeDeleteCommand() {
		return new NoticeDeleteCommand();
	}
	@Bean
	public NoticeInsertCommand noticeInsertCommand() {
		return new NoticeInsertCommand();
	}

	
	/* Command - (FBoard) Bean생성  */
	@Bean
	public FBoardListCommand fBoardListCommand() {
		return new FBoardListCommand();
	}
	@Bean
	public FBoardInsertCommand fBoardInsertCommand() {
		return new FBoardInsertCommand();
	}
	@Bean
	public FBoardViewCommand fBoardViewCommand() {
		return new FBoardViewCommand();
	}
	@Bean
	public FBoardUpdateCommand fBoardUpdateCommand() {
		return new FBoardUpdateCommand();
	}
	@Bean
	public FBoardDeleteCommand fBoardDeleteCommand() {
		return new FBoardDeleteCommand();
	}
	@Bean
	public FBoardSearchListCommand FBoardSearchListCommand() {
		return new FBoardSearchListCommand();
	}
	@Bean
	public FBoardDropListCommand fBoardDropListCommand() {
		return new FBoardDropListCommand();
	}
	
	
	/* Command - (FReply) Bean생성  */
	@Bean
	public FReplyListCommand fReplyListCommand() {
		return new FReplyListCommand();
	}
	@Bean
	public FReplyInsertCommand fReplyInsertCommand() {
		return new FReplyInsertCommand();
	}
	@Bean
	public FReplyDeleteCommand fReplyDeleteCommand() {
		return new FReplyDeleteCommand();
	}
	//Store Bean생성
	/* 
	@Bean
	public InsertStoreCommand insertStoreCommand() {
		return new InsertStoreCommand();
	}
	
	@Bean
	public SelectStoreListCommand selectStoreListCommand() {
		return new SelectStoreListCommand();
	}
	*/
	
	
}
