package com.koreait.a.dao;

import java.util.List;

import com.koreait.a.dto.QnaBoardDTO;

public interface QnaBoardDAO {
	
	public List<QnaBoardDTO> selectQnaBoardList();
	public int qnaBoardTotalCount();
	public QnaBoardDTO qnaBoardView(long no);
	public int qnaBoardUpdate(QnaBoardDTO qnaBoard);
	public int qnaBoardInsert(QnaBoardDTO qnaBoard);
	public int qnaBoardDelete(long no);
	

}
