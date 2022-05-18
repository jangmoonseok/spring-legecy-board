package com.basic.board.service;

import java.sql.SQLException;
import java.util.List;

import com.basic.board.vo.BoardVO;

public interface IBoardService {
	//글 등록
	public void insertBoard(BoardVO boardVo) throws Exception;
	
	//글 수정
	public void updateBoard(BoardVO boardVo) throws Exception;
	
	//글 목록
	public List<BoardVO> selectBoardList() throws Exception;
	
	//글 상세보기
	public BoardVO selectBoardDetail(int bno) throws Exception;
	
	//글 삭제
	public void deleteBoard(int bno) throws Exception;
}
