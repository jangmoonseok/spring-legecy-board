package com.basic.board.service;

import java.sql.SQLException;
import java.util.List;

import com.basic.board.vo.BoardVO;

public interface IBoardService {
	//글 등록
	public int insertBoard(BoardVO boardVo);
	
	//글 수정
	public int updateBoard(BoardVO boardVo);
	
	//글 목록
	public List<BoardVO> selectBoardList();
	
	//글 상세보기
	public BoardVO selectBoardDetail(int bno);
	
	//글 삭제
	public int deleteBoard(int bno);
}
