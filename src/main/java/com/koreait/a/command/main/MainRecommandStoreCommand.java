package com.koreait.a.command.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.MainDAO;
import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.MainStoreDTO;

public class MainRecommandStoreCommand implements MainCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		// 전달받는 파라미터가 없다
		
		// 전체 음식점 개수 (total)
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		int totalStore = storeDAO.storeTotalCount();
		
		// 음식점 정보를 담을 수 있는 list 생성 
		List<MainStoreDTO> list = new ArrayList<>();

		// json 데이터로 전달
		Map<String, Object> resultMap = new HashMap<>();
		
		// 등록된 음식점이 존재하면
		if (totalStore > 0) {
			// 랜덤으로 뽑은 (추천음식점 2개)
			MainDAO mainDAO = sqlSession.getMapper(MainDAO.class);
			// 랜덤의 숫자 만들어주기
			double reviewAvg = 0.0;
			long storeNo = 0; // STORENO : 랜덤으로 작성하고자 함
			for (int n = 1; n <= 2 ; n++) {
				int ranN = (int)(Math.random() * totalStore) + 1;
				// 중복 숫자 체크
				while (storeNo == ranN) {
					ranN = (int)(Math.random() * totalStore) + 1;
				}
				storeNo = ranN;
				MainStoreDTO mainStoreDTO = mainDAO.mainStoreView(storeNo);
				
				if (mainDAO.reviewStoreExist(storeNo) > 0) {
					reviewAvg = mainDAO.reviewAvg(storeNo);
					mainStoreDTO.setReviewAvg(reviewAvg);
				} else {
					mainStoreDTO.setReviewAvg(0.0);
				}
				list.add(mainStoreDTO);	
			}
			
			// view에 전달할 json 데이터 저장
			resultMap.put("recommandStore", list);
			resultMap.put("status", 200);
			
		} else {
			// 등록된 음식점이 없다면 저장되는 데이터값
			// view에 전달할 json 데이터 저장
			resultMap.put("recommandStore", null);
			resultMap.put("status", 500);
		}
		
		
		return resultMap;
	}

}
