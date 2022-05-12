package com.basic.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.basic.board.vo.BoardVO;

public interface IBoardDao {
	//글 등록
	public int insertBoard(BoardVO boardVo) throws SQLException;
	
	//글 수정
	public int updateBoard(BoardVO boardVo) throws SQLException;
	
	//글 목록
	public List<BoardVO> selectBoardList() throws SQLException;
	
	//글 상세보기
	public BoardVO selectBoardDetail(int bno) throws SQLException;
	
	//글 삭제
	public int deleteBoard(int bno) throws SQLException;
	
	//글 번호 조회
	public int selectBoardNum() throws SQLException;
}
