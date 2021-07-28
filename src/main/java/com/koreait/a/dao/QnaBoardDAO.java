package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.PagingDTO;
import com.koreait.a.dto.QnaBoardDTO;

public interface QnaBoardDAO {
	
	public List<QnaBoardDTO> selectQnaBoardList(PagingDTO pagingDTO);
	public int qnaBoardTotalCount();
	public QnaBoardDTO qnaBoardView(long no);
	public int qnaBoardUpdate(QnaBoardDTO qnaBoard);
	public int qnaBoardInsert(QnaBoardDTO qnaBoard);
	public int qnaBoardDelete(long no);
	

}
