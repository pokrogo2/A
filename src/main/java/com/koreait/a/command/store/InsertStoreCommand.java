package com.koreait.a.command.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public class InsertStoreCommand implements StoreCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		/*
		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)map.get("multipartRequest");
		
		Store store = new Store();
		
		// store.setOwenerName(multipartRequest.getParameter("storeOwnerName"));		
		
		store.setStoreName(multipartRequest.getParameter("storeName"));
		store.setStoreContent(multipartRequest.getParameter("storeContent"));
		store.setStoreTable((Integer.parseInt(multipartRequest.getParameter("storeTable"))));
		store.setStoreTel(multipartRequest.getParameter("storeTel"));
		store.setStoreAddr(multipartRequest.getParameter("storeAddr"));
		store.setStoreTime(multipartRequest.getParameter("storeTime"));
		store.setStoreSns(multipartRequest.getParameter("storeSns"));
		store.setStoreCategori(multipartRequest.getParameter("storeCategori"));
		store.setStoreMenu(multipartRequest.getParameter("storeMenu"));
		
		
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
