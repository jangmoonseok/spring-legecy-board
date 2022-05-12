package com.basic.board.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.board.dao.IBoardDao;
import com.basic.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements IBoardService {
	private final IBoardDao dao;
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		int cnt = 0;
		
		try {
			int bno = dao.selectBoardNum();
			boardVo.setBoard_no(bno + 1);
			cnt = dao.insertBoard(boardVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		int cnt = 0;
		
		try {
			cnt = dao.updateBoard(boardVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> selectBoardList() {
		List<BoardVO> boardList = null;
		
		try {
			boardList = dao.selectBoardList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return boardList;
	}

	@Override
	public BoardVO selectBoardDetail(int bno) {
		BoardVO boardVo = null;
		
		try {
			boardVo = dao.selectBoardDetail(bno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return boardVo;
	}

	@Override
	public int deleteBoard(int bno) {
		int cnt = 0;
		
		try {
			cnt = dao.deleteBoard(bno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

}
