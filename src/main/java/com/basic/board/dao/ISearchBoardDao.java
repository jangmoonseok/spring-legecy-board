package com.basic.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.board.command.SearchCriteria;
import com.basic.board.vo.BoardVO;

public interface ISearchBoardDao extends IBoardDao {

	List<BoardVO> selectSearchBoardList(SqlSession session, SearchCriteria cri) throws Exception;
	int getSearchBoardListCount(SqlSession session, SearchCriteria cri) throws Exception;
}
