package com.koreait.a.dao;

import java.util.List;
import java.util.Map;

import com.koreait.a.dto.QnaBoardDTO;

public class QnaBoardDAO {
	
	
	public int countBoard(Map<String, Object> map);
	public List<QnaBoardDTO> selectListQnaBoard(Map<String, Object> map);
	public QnaBoardDTO selectOneQnaBoard(long no);
	public int QnaBoardInsertCommand(QnaBoardDTO qnaBoard);
	public int insertCommentQnaBoard(QnaBoardDTO qnaBoard);
	public int deleteQnaBoard(QnaBoardDTO qnaBoard);
	public int updateQnaBoard(QnaBoardDTO qnaBoard);

}
