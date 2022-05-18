package com.basic.board.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.board.vo.BoardVO;

public interface IBoardDao {
	//글 등록
	public void insertBoard(SqlSession session, BoardVO boardVo) throws SQLException;
	
	//글 수정
	public void updateBoard(SqlSession session, BoardVO boardVo) throws SQLException;
	
	//글 목록
	public List<BoardVO> selectBoardList(SqlSession session) throws SQLException;
	
	//글 상세보기
	public BoardVO selectBoardDetail(SqlSession session, int bno) throws SQLException;
	
	//글 삭제
	public void deleteBoard(SqlSession session, int bno) throws SQLException;
	
	//글 번호 조회
	public int selectBoardNum(SqlSession session) throws SQLException;
}
