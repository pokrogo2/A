package com.koreait.a.command.store;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.StoreDAO;

public class InsertStoreCommand implements StoreCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		String storeName = request.getParameter("storeName");
		String storeContent = request.getParameter("storeContent");
		int storeTable = (Integer.parseInt(request.getParameter("storeTable")));
		String storeTel = request.getParameter("storeTel");
		String storeAddr = request.getParameter("storeAddr");
		String storeTime = request.getParameter("storeTime");
		
		StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);
		
		int result = storeDAO.insertStore(storeName, storeContent, storeTable, storeTel, storeAddr, storeTime);
		
		try {
			response.setContentType("text/html; charset=utf-8");
			if (result > 0) {
				response.getWriter().append("<script>");
				response.getWriter().append("alert('가게가 등록되었습니다.');");
				response.getWriter().append("location.href='storeList.do';");
				response.getWriter().append("</script>");
			} else {
				response.getWriter().append("<script>");
				response.getWriter().append("alert('가게 등록이 실패하였습니다.');");
				response.getWriter().append("history.back();");
				response.getWriter().append("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
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
