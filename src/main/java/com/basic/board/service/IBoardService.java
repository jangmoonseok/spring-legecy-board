package com.basic.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.basic.board.command.Criteria;
import com.basic.board.vo.BoardVO;

public interface IBoardService {
	//�� ���
	public void insertBoard(BoardVO boardVo) throws Exception;
	
	//�� ����
	public void updateBoard(BoardVO boardVo) throws Exception;
	
	//�� ���
	public List<BoardVO> selectBoardList() throws Exception;
	public List<BoardVO> selectBoardList(Criteria cri) throws Exception;
	public Map<String, Object> getBoardListForPage(Criteria cri) throws Exception;
	//�� �󼼺���
	public BoardVO selectBoardDetail(int bno) throws Exception;
	
	//�� ����
	public void deleteBoard(int bno) throws Exception;
}
