package com.koreait.a.command.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.MainDAO;
import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.MainStoreDTO;
import com.koreait.a.dto.StoreDTO;

public class MainRecommandStoreCommand implements MainCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		// 전달받는 파라미터가 없음
		
		// 전체 음식점 개수 (total)
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		int totalStore = storeDAO.storeTotalCount();
		
		// 랜덤으로 뽑은 (추천음식점 2개)
		MainDAO mainDAO = sqlSession.getMapper(MainDAO.class);
		List<MainStoreDTO> list = null;
		long storeNo = 0; // STORENO : 랜덤으로 작성하고자 함
		for (int n = 1; n <= 2 ; n++) {
			storeNo = (int)(Math.random() * totalStore) + 1;
			MainStoreDTO mainStoreDTO = mainDAO.mainStoreRecommand(storeNo);
			mainStoreDTO.setReviewAvg(mainDAO.reviewAvg(storeNo));
			list.add(mainStoreDTO);		
		}
		
		System.out.println("storeList: " + list.toString());
		
		
		// model에 삽입
		model.addAttribute("recommandStore", list);
		
		
		return null;
	}

}
