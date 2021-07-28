package com.koreait.a.command.store;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
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
		HttpServletResponse response = (HttpServletResponse)map.get("response");		
		
		StoreDTO storeDTO = new StoreDTO();
		storeDTO.setStoreNo(Long.parseLong(multipartRequest.getParameter("storeNo")));
		storeDTO.setStoreName(multipartRequest.getParameter("storeName"));
		storeDTO.setStoreContent(multipartRequest.getParameter("storeContent"));
		storeDTO.setStoreTable( (Integer.parseInt(multipartRequest.getParameter("storeTable"))) );
		storeDTO.setStoreTel(multipartRequest.getParameter("storeTel"));
		storeDTO.setStoreAddr1(multipartRequest.getParameter("storeAddr1"));
		storeDTO.setStoreAddr2(multipartRequest.getParameter("storeAddr2"));
		storeDTO.setStoreAddr3(multipartRequest.getParameter("storeAddr3"));
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
	
		
		/* response */
		response.setContentType("text/html; charset=utf-8"); 
		int count = storeDAO.storeUpdate(storeDTO);
	
		try {
			if (count > 0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('가게 수정을 완료했습니다.')");
				response.getWriter().println("location.href='storeList.do'");
				response.getWriter().println("</script>");
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('수정 중 오류가 발생했습니다.')");
				response.getWriter().println("history.back()");
				response.getWriter().println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
			
			
		
	}

}