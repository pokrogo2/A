package com.koreait.a.command.fBoard;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.a.dao.FBoardDAO;
import com.koreait.a.dto.FBoardDTO;

public class FBoardUpdateCommand implements FBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)map.get("multipartRequest");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		long no = Long.parseLong(multipartRequest.getParameter("no"));
		String writer = multipartRequest.getParameter("writer");
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		String contentType = multipartRequest.getParameter("contentType");	
		contentType =  contentType == null ? "" : contentType;
		String filename0 = multipartRequest.getParameter("filename0");	
		String fileDelete = multipartRequest.getParameter("fileDelete");	
		FBoardDTO fBoardDTO = new  FBoardDTO();
		fBoardDTO.setNo(no);
		fBoardDTO.setWriter(writer);
		fBoardDTO.setTitle(title);
		fBoardDTO.setContent(content);
		fBoardDTO.setContentType(contentType);
		FBoardDAO fBoardDAO = sqlSession.getMapper(FBoardDAO.class);
		int result = 0; //결과 확인
		
		MultipartFile uploadFile = multipartRequest.getFile("file");
		// 저장할 위치 생성
		String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");
		File archive = new File(realPath);
		if (!archive.exists()) {
			archive.mkdirs();
		} 
		// 업로드할 파일이 있다면 시작하겠다.
		if (uploadFile != null && !uploadFile.isEmpty()) {
			// 저장할 파일 이름명 
			String originalFilename = uploadFile.getOriginalFilename();
			String extension = originalFilename.substring( originalFilename.lastIndexOf('.') + 1 );
			String filename = originalFilename.substring(0, originalFilename.lastIndexOf("."));
			String uploadFilename = filename + "_" + System.currentTimeMillis() + "." + extension;
			
			// 이전의 파일 삭제
			File beforeFile = new File(realPath, filename0);
			if (beforeFile != null ) {
				if (beforeFile.exists()) {
					beforeFile.delete();
				}
			}

			// 서버에 첨부파일 저장
			File attach = new File(archive, uploadFilename);
			try {
				uploadFile.transferTo(attach);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			// DB에 저장 할 때 파일명 인코딩 (한글로된 파일이 있을 수 있다.)
			try {
				uploadFilename = URLEncoder.encode(uploadFilename, "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			// DB에 저장
			fBoardDTO.setFilename1(uploadFilename);
			result = fBoardDAO.fBoardUpdate(fBoardDTO);
			
		} else if (fileDelete.equals("true")) {
			// 현재 저장되어 있는 파일을 삭제하고 저장.
			// 이전의 파일 삭제
			File beforeFile = new File(realPath, filename0);
			if (beforeFile != null ) {
				if (beforeFile.exists()) {
					beforeFile.delete();
				}
			}
			// DB에 저장
			fBoardDTO.setFilename1("");
			result = fBoardDAO.fBoardUpdate(fBoardDTO);
		
		} else {
			// DB에 저장
			// 첨부파일이 없다.
			fBoardDTO.setFilename1(filename0);
			result = fBoardDAO.fBoardUpdate(fBoardDTO);
			
		}
		
		
		// response 
		response.setContentType("text/html; charset=UTF-8");
		try {
			if (result > 0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('글 수정을 완료하였습니다.')");
				response.getWriter().println("location.href='fBoardView.do?no="+no+"'");
				response.getWriter().println("</script>");
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('글 수정을 처리하는 도중에 오류가 발생했습니다.')");
				response.getWriter().println("history.back()");
				response.getWriter().println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
