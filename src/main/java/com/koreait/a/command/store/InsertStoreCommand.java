package com.koreait.a.command.store;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.StoreDAO;
import com.koreait.a.dto.Store;

public class InsertStoreCommand implements StoreCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String storeName = request.getParameter("storeName");
		String storeContent = request.getParameter("storeContent");
		int storeTable = (Integer.parseInt(request.getParameter("storeTable")));
		String storeTel = request.getParameter("storeTel");
		String storeAddr = request.getParameter("storeAddr");
		String storeTime = request.getParameter("storeTime");

		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		storeDAO.insertStore(storeName, storeContent, storeTable, storeTel, storeAddr, storeTime);
		
		
		/*
		List<MultipartFile> files = multipartRequest.getFiles("files");
		
		for (MultipartFile file : files) {
			
		
			if (file != null && !file.isEmpty()) {
				
				// 올릴 때 파일명
				String originalFilename = file.getOriginalFilename();
				
				// 서버에 저장할 파일명(파일명_올린시간.확장자)
				String extension = originalFilename.substring( originalFilename.lastIndexOf(".") + 1 );	
											
				String filename = originalFilename.substring( 0, originalFilename.lastIndexOf(".") );	
																
				String uploadFilename = filename + "_" + System.currentTimeMillis() + "." + extension;
				
				// 첨부파일 저장할 서버 
				String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");
				 														
				// archive 디렉터리 생성
				File archive = new File(realPath);
				if ( !archive.exists() ) {
					archive.mkdirs();
				}
				
				// 서버에 첨부파일 저장
				File attach = new File(archive, uploadFilename);	
				try {
					file.transferTo(attach); 					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// DB에 넣는 파일명 인코딩 처리
				try {
					uploadFilename = URLEncoder.encode(uploadFilename, "utf-8");
				} catch (Exception e) { }
				
				// DB에 데이터 저장 
				StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
				storeDAO.insertStore(store);
				
			} 
			
		}	// for 완료

		*/

	}

}
