package com.koreait.a.command.store;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.a.dao.StoreDAO;

public class StoreDeleteCommand implements StoreCommand {

		@Override
		public void execute(SqlSession sqlSession, Model model) {
			
			Map<String, Object> map = model.asMap();
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)map.get("multipartRequest");
			HttpServletResponse response = (HttpServletResponse)map.get("response");
			
			// DB 삭제
			long storeNo = Long.parseLong(multipartRequest.getParameter("storeNo"));
			StoreDAO storeDAO = sqlSession.getMapper(StoreDAO.class);	
			
			// 첨부 삭제
					String saveFilename = multipartRequest.getParameter("saveFilename");
					String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");
					File file = new File(realPath, saveFilename);
					if (file != null) {
						if (file.exists()) {
							file.delete();
						}
					}
			
			
			/* response */
			response.setContentType("text/html; charset=utf-8"); 
			int count = storeDAO.storeDelete(storeNo);
		
			try {
				if (count > 0) {
					response.getWriter().println("<script>");
					response.getWriter().println("alert('가게 등록을 삭제했습니다.')");
					response.getWriter().println("location.href='storeList2.do'");
					response.getWriter().println("</script>");
				} else {
					response.getWriter().println("<script>");
					response.getWriter().println("alert('삭제 중 오류가 발생했습니다.')");
					response.getWriter().println("history.back()");
					response.getWriter().println("</script>");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
				
				
			

		}

	}