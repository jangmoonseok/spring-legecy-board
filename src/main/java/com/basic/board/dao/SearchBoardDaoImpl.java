package com.basic.board.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.basic.board.command.SearchCriteria;
import com.basic.board.vo.BoardVO;

@Repository
@Primary
public class SearchBoardDaoImpl extends BoardDaoImpl implements ISearchBoardDao{

	@Override
	public List<BoardVO> selectSearchBoardList(SqlSession session, SearchCriteria cri) throws Exception {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<BoardVO> boardList = session.selectList("board.selectSearchBoardList", cri, rowBounds);
		
		return boardList;
	}

	@Override
	public int getSearchBoardListCount(SqlSession session, SearchCriteria cri) throws Exception {
		int cnt = 0;
		
		cnt = session.selectOne("board.getSearchBoardListCount", cri);
		return cnt;
	}

}
