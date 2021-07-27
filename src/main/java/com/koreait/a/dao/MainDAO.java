package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.MainStoreDTO;

public interface MainDAO {

	// 가게 사장님 이름으로 가게 등록이 되어있는지 여부
	public int storeExist(long ownerNo);
	// 추천 음식점 리스트
	public MainStoreDTO mainStoreRecommand(long storeNo);
	// 리뷰 평점 평균 구하기
	public double reviewAvg(long storeNo);
	// 신규 음식점 리스트
	public List<MainStoreDTO> mainStoreNew(long rnBegin, long rnEnd);
}
