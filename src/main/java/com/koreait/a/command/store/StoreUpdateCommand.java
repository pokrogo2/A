package com.koreait.a.command.store;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.support.SQLExceptionSubclassTranslator;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.StoreDTO;

public class StoreUpdateCommand implements StoreCommand {

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
	
		
		String originFilename = multipartRequest.getParameter("originFilename");
		String saveFilename = multipartRequest.getParameter("saveFilename");
		
		MultipartFile newFile = multipartRequest.getFile("newFile");
		
		try {
			
			if (newFile != null && !newFile.isEmpty()) {  // 새로운 파일 첨부가 있을 때
				
				String newOriginFilename = newFile.getOriginalFilename();
				
				String extension = newOriginFilename.substring( newOriginFilename.lastIndexOf(".") );
				String newSaveFilename = UUID.randomUUID().toString().replaceAll("-", "") + extension;
				
				// 첨부파일을 저장할 서버 위치
				String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");

				// 서버에 새 첨부파일 저장하기
				File newSaveFile = new File(realPath, newSaveFilename);
				try {
					newFile.transferTo(newSaveFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// 기존 첨부파일과 새로운 첨부파일이 모두 존재할 시, 기존 첨부 지우기 
				File file = new File(realPath, saveFilename);  
				if (file != null) {
					// 기존 첨부 지우기
					if (file.exists()) {
						file.delete();
					}
				}
				
				storeDTO.setOriginFilename(newOriginFilename);
				storeDTO.setSaveFilename(newSaveFilename);
				
				
			} else {	// 새 첨부파일이 없을 때, 기존 파일 유지
				
				storeDTO.setOriginFilename(originFilename);
				storeDTO.setSaveFilename(saveFilename);
				
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// DB에 데이터 저장
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		storeDAO.storeUpdate(storeDTO);
	
		
		
	}
		
		
		
		

	

}