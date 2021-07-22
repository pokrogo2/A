package com.koreait.a.command.store;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.StoreDTO;

public class StoreInsertCommand implements StoreCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)map.get("multipartRequest");
		
		
		StoreDTO storeDTO = new StoreDTO();
		storeDTO.setStoreName(multipartRequest.getParameter("storeName"));
		storeDTO.setStoreContent(multipartRequest.getParameter("storeContent"));
		storeDTO.setStoreTable( (Integer.parseInt(multipartRequest.getParameter("storeTable"))) );
		storeDTO.setStoreTel(multipartRequest.getParameter("storeTel"));
		storeDTO.setStoreAddr(multipartRequest.getParameter("storeAddr"));
		storeDTO.setStoreTime(multipartRequest.getParameter("storeTime"));
		storeDTO.setStoreSns(multipartRequest.getParameter("storeSns"));
		storeDTO.setStoreCategory(multipartRequest.getParameter("storeCategory"));
		storeDTO.setStoreMenu(multipartRequest.getParameter("storeMenu"));
	
		
		MultipartFile file = multipartRequest.getFile("file");
		
		try {	
			
			if (file != null && !file.isEmpty()) {  

				String originFilename = file.getOriginalFilename();
				
				// 서버에 저장할 파일명
				// UUID : Universally Unique IDentifier - 범용 고유 식별자
				// 550e8400-e29b-41d4-a716-446655440000 : 하이픈(-) 제외 32자리
				String extension = originFilename.substring( originFilename.lastIndexOf(".") );
				String saveFilename = UUID.randomUUID().toString().replaceAll("-", "") + extension;
				
				// 첨부파일을 저장할 서버 위치
				String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");  
				
				// archive 디렉터리 생성
				File archive = new File(realPath);
				if ( !archive.exists() ) {
					archive.mkdirs();
				}
				
				// 서버에 첨부파일 저장
				File saveFile = new File(archive, saveFilename);
				try {
					file.transferTo(saveFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				storeDTO.setOriginFilename(originFilename);
				storeDTO.setSaveFilename(saveFilename);
		
			} else {
				storeDTO.setOriginFilename("");
				storeDTO.setSaveFilename("");
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		// DB에 데이터 저장
		
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		storeDAO.storeInsert(storeDTO);
		
	}
		
		
		

	

}