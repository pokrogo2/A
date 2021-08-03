package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.LocationDTO;
import com.koreait.a.dto.MainStoreDTO;
import com.koreait.a.dto.SearchStoreQueryDTO;
import com.koreait.a.dto.StoreDTO;

public interface MainDAO {

	// 검색과 가게등록시 필요한 지역을 선택할 수 있도록 
	public List<LocationDTO> zoneSelect();
	public List<LocationDTO> localSelect(String zone);
	
	// 음식점 검색 결과 : 개수 및 리스트
	public int searchStoreTotal(SearchStoreQueryDTO searchStoreQueryDTO);
	public List<StoreDTO> searchStore(SearchStoreQueryDTO searchStoreQueryDTO);
	
	// 가게 사장님 이름으로 가게 등록이 되어있는지 여부
	public int storeExist(long ownerNo);
	// 로그인한 가게 사장님이 등록한 가게 번호
	public MainStoreDTO storeExistStoreNo (long ownerNo);
	
	// 음식점에 리뷰가 존재하는지 확인
	public int reviewStoreExist(long storeNo);
	// 추천 음식점 리스트
	public MainStoreDTO mainStoreView(long storeNo);
	// 리뷰 평점 평균 구하기
	public double reviewAvg(long storeNo);
	// 신규 음식점 리스트
	public List<MainStoreDTO> mainStoreNew(long rnBegin, long rnEnd);
}
