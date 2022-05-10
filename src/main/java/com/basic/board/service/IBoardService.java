package com.basic.board.service;

import java.sql.SQLException;
import java.util.List;

import com.basic.board.vo.BoardVO;

public interface IBoardService {
	//�� ���
	public int insertBoard(BoardVO boardVo);
	
	//�� ����
	public int updateBoard(BoardVO boardVo);
	
	//�� ���
	public List<BoardVO> selectBoardList();
	
	//�� �󼼺���
	public BoardVO selectBoardDetail(int bno);
	
	//�� ����
	public int deleteBoard(int bno);
}
