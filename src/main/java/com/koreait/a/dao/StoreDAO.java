package com.koreait.a.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.a.dto.Page;
import com.koreait.a.dto.Store;

@Repository
public interface StoreDAO {

	public List<Store> selectStoreList(Page paging);
	public int getTotalStoreCount();
	public int insertStore(String storeName, String storeContent, int storeTable, 
						   String storeTel, String storeAddr, String storeTime);
	public Store selectStoreByNo(long storeNo);
	
}
