package com.basic.board.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.basic.board.vo.BoardVO;
import com.basic.util.SqlMapClientFactory;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class BoardDaoImpl implements IBoardDao {
	private static SqlMapClient smc = SqlMapClientFactory.getsqlMapClient();
	
	@Override
	public int insertBoard(BoardVO boardVo) throws SQLException {
		int cnt = 0;
		Object result = smc.insert("board.insertBoard", boardVo);
		if(result == null) cnt = 1;
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO boardVo) throws SQLException {
		int cnt = 0;
		cnt = smc.update("board.updateBoard", boardVo);
		return cnt;
	}

	@Override
	public List<BoardVO> selectBoardList() throws SQLException {
		List<BoardVO> boardList = null;
		boardList = smc.queryForList("board.selectBoardList");
		return boardList;
	}

	@Override
	public BoardVO selectBoardDetail(int bno) throws SQLException {
		BoardVO board = null;
		board = (BoardVO)smc.queryForObject("board.selectBoardDetail", bno);
		return board;
	}

	@Override
	public int deleteBoard(int bno) throws SQLException {
		int cnt = 0;
		cnt = smc.delete("board.deleteBoard", bno);
		return cnt;
	}

}
