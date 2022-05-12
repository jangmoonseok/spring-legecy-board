package com.basic.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.basic.board.vo.BoardVO;

public interface IBoardDao {
	//�� ���
	public int insertBoard(BoardVO boardVo) throws SQLException;
	
	//�� ����
	public int updateBoard(BoardVO boardVo) throws SQLException;
	
	//�� ���
	public List<BoardVO> selectBoardList() throws SQLException;
	
	//�� �󼼺���
	public BoardVO selectBoardDetail(int bno) throws SQLException;
	
	//�� ����
	public int deleteBoard(int bno) throws SQLException;
	
	//�� ��ȣ ��ȸ
	public int selectBoardNum() throws SQLException;
}
