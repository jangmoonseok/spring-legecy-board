package com.basic.board.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.basic.board.command.Criteria;
import com.basic.board.util.SqlMapClientFactory;
import com.basic.board.vo.BoardVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class BoardDaoImpl implements IBoardDao {

	@Override
	public void insertBoard(SqlSession session, BoardVO boardVo) throws SQLException {
		session.insert("board.insertBoard", boardVo);
	}

	@Override
	public void updateBoard(SqlSession session, BoardVO boardVo) throws SQLException {
		session.update("board.updateBoard", boardVo);
	}

	@Override
	public List<BoardVO> selectBoardList(SqlSession session) throws SQLException {
		List<BoardVO> boardList = null;
		
		boardList = session.selectList("board.selectBoardList");
		
		return boardList;
	}

	@Override
	public BoardVO selectBoardDetail(SqlSession session, int bno) throws SQLException {
		BoardVO board = null;
		
		board = session.selectOne("board.selectBoardDetail", bno);
		
		return board;
	}

	@Override
	public void deleteBoard(SqlSession session, int bno) throws SQLException {
		session.delete("board.deleteBoard", bno);
	}

	@Override
	public int selectBoardNum(SqlSession session) throws SQLException {
		int bno = 0;
		
		bno = session.selectOne("board.selectBoardNum");
		
		return bno;
	}

	@Override
	public List<BoardVO> selectBoardList(SqlSession session, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<BoardVO> boardList = session.selectList("board.selectBoardList", null, rowBounds);
		
		return boardList;
	}

	@Override
	public int getBoardListCount(SqlSession session) throws SQLException {
		int cnt = 0;
		
		cnt = session.selectOne("board.getBoardListCount");
		
		return cnt;
	}
	
	

}
