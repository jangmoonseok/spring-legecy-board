package com.basic.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.basic.board.command.Criteria;
import com.basic.board.vo.BoardVO;

public interface IBoardService {
	//글 등록
	public void insertBoard(BoardVO boardVo) throws Exception;
	
	//글 수정
	public void updateBoard(BoardVO boardVo) throws Exception;
	
	//글 목록
	public List<BoardVO> selectBoardList() throws Exception;
	public List<BoardVO> selectBoardList(Criteria cri) throws Exception;
	public Map<String, Object> getBoardListForPage(Criteria cri) throws Exception;
	//글 상세보기
	public BoardVO selectBoardDetail(int bno) throws Exception;
	
	//글 삭제
	public void deleteBoard(int bno) throws Exception;
}
