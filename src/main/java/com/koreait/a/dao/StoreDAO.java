package com.koreait.a.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.a.dto.Store;

@Repository
public interface StoreDAO {

	public List<Store> selectStoreList();
	public int insertStore(Store store);
	
}
