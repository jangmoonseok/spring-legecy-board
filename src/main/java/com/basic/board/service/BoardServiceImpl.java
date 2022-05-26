package com.basic.board.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.board.command.Criteria;
import com.basic.board.command.PageMaker;
import com.basic.board.command.SearchCriteria;
import com.basic.board.dao.IBoardDao;
import com.basic.board.dao.ISearchBoardDao;
import com.basic.board.util.MybatisSqlSessionFactory;
import com.basic.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
public class BoardServiceImpl implements IBoardService {
	private final ISearchBoardDao dao;
	private final SqlSessionFactory sessionFactory;
	
	@Autowired
	public BoardServiceImpl(ISearchBoardDao dao, SqlSessionFactory sessionFactory) {
		this.dao = dao;
		this.sessionFactory = sessionFactory;
	}
	
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

	@Override
	public List<BoardVO> selectBoardList(Criteria cri) throws Exception {
		SqlSession session = sessionFactory.openSession();
		
		List<BoardVO> boardList = null;
		
		try {
			boardList = dao.selectBoardList(session,cri);
		} finally {
			if(session != null) session.close();
		}
		
		return boardList;
	}

	@Override
	public Map<String, Object> getBoardListForPage(Criteria cri) throws Exception {
		SqlSession session = sessionFactory.openSession();
		
		if(cri instanceof SearchCriteria) {
			SearchCriteria searchCri = (SearchCriteria) cri;
		
		
			Map<String, Object> dataMap = null;
			
			try {
				dataMap = new HashMap<String, Object>();
				
				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(dao.getSearchBoardListCount(session, searchCri));
				
				List<BoardVO> boardList = dao.selectSearchBoardList(session, searchCri);
				dataMap.put("pageMaker", pageMaker);
				dataMap.put("boardList", boardList);
			}finally {
				if(session != null) session.close();
			}
			
			return dataMap;
		}else {
			return null;
		}
		
	}

}
