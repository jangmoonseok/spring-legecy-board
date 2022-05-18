package com.basic.board.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.basic.board.vo.BoardVO;
import com.basic.util.SqlMapClientFactory;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class BoardDaoImpl implements IBoardDao {

	@Override
	public void insertBoard(SqlSession session, BoardVO boardVo) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateBoard(SqlSession session, BoardVO boardVo) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<BoardVO> selectBoardList(SqlSession session) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO selectBoardDetail(SqlSession session, int bno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoard(SqlSession session, int bno) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public int selectBoardNum(SqlSession session) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
