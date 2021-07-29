package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.LocationDTO;
import com.koreait.a.dto.MainStoreDTO;

public interface MainDAO {

	// 검색과 가게등록시 필요한 지역을 선택할 수 있도록 
	public List<LocationDTO> zoneSelect();
	public List<LocationDTO> localSelect(String zone);
	
	// 가게 사장님 이름으로 가게 등록이 되어있는지 여부
	public int storeExist(long ownerNo);
	// 음식점에 리뷰가 존재하는지 확인
	public int reviewStoreExist(long storeNo);
	// 추천 음식점 리스트
	public MainStoreDTO mainStoreView(long storeNo);
	// 리뷰 평점 평균 구하기
	public double reviewAvg(long storeNo);
	// 신규 음식점 리스트
	public List<MainStoreDTO> mainStoreNew(long rnBegin, long rnEnd);
}
