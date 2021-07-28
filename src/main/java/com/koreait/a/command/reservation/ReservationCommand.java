package com.koreait.a.command.reservation;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface ReservationCommand {

	public void execute(SqlSession sqlSession, Model model);
}
