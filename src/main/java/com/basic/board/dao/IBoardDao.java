package com.basic.board.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.board.vo.BoardVO;

public interface IBoardDao {
	//�� ���
	public void insertBoard(SqlSession session, BoardVO boardVo) throws SQLException;
	
	//�� ����
	public void updateBoard(SqlSession session, BoardVO boardVo) throws SQLException;
	
	//�� ���
	public List<BoardVO> selectBoardList(SqlSession session) throws SQLException;
	
	//�� �󼼺���
	public BoardVO selectBoardDetail(SqlSession session, int bno) throws SQLException;
	
	//�� ����
	public void deleteBoard(SqlSession session, int bno) throws SQLException;
	
	//�� ��ȣ ��ȸ
	public int selectBoardNum(SqlSession session) throws SQLException;
}
