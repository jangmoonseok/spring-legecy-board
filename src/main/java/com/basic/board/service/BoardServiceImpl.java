package com.basic.board.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.basic.board.dao.IBoardDao;
import com.basic.board.vo.BoardVO;
import com.basic.util.MybatisSqlSessionFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements IBoardService {
	private final IBoardDao dao;
	private final SqlSessionFactory sessionFactory = new MybatisSqlSessionFactory();
	
	@Override
	public void insertBoard(BoardVO boardVo) throws Exception{
		SqlSession session = sessionFactory.openSession();
		
		
		try {
			int bno = dao.selectBoardNum(session);
			boardVo.setBoard_no(bno + 1);
			dao.insertBoard(session,boardVo);
		} finally {
			if(session != null) session.close();
		}
	}

	@Override
	public void updateBoard(BoardVO boardVo) throws Exception{
		SqlSession session = sessionFactory.openSession();
		
		try {
			dao.updateBoard(session,boardVo);
		} finally {
			if(session != null) session.close();
		}
		
	}

	@Override
	public List<BoardVO> selectBoardList() throws Exception{
		SqlSession session = sessionFactory.openSession();
		
		List<BoardVO> boardList = null;
		
		try {
			boardList = dao.selectBoardList(session);
		} finally {
			if(session != null) session.close();
		}
		
		return boardList;
	}

	@Override
	public BoardVO selectBoardDetail(int bno) throws Exception {
		SqlSession session = sessionFactory.openSession();
		
		BoardVO boardVo = null;
		
		try {
			boardVo = dao.selectBoardDetail(session,bno);
		} finally {
			if(session != null) session.close();
		}
		
		return boardVo;
	}

	@Override
	public void deleteBoard(int bno) throws Exception{
		SqlSession session = sessionFactory.openSession();
				
		try {
			dao.deleteBoard(session,bno);
		} finally {
			if(session != null) session.close();
		}
		
	}

}
