package com.basic.board.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic.board.HomeController;
import com.basic.board.command.SearchCriteria;
import com.basic.board.util.MybatisSqlSessionFactory;
import com.basic.board.vo.BoardVO;

public class SearchBoardDaoImplTest {

	private ApplicationContext ac;
	private SqlSessionFactory factory;
	
	@Before
	public void init() {
		ac = new AnnotationConfigApplicationContext(HomeController.class);
		factory = new MybatisSqlSessionFactory();
	}
	
	@Test
	public void searchBoardListTest() {
		SearchBoardDaoImpl dao = ac.getBean(SearchBoardDaoImpl.class);
		
		SqlSession session = factory.openSession();
		
		SearchCriteria cri = new SearchCriteria();
		
		cri.setSearchType("t");
		cri.setKeyword("1");
		
		List<BoardVO> boardList = null;
		try {
			boardList = dao.selectSearchBoardList(session, cri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(2, boardList.size());
		
	}

	@Test
	public void getSearchBoardListTest() {
		SearchBoardDaoImpl dao = ac.getBean(SearchBoardDaoImpl.class);
		
		SqlSession session = factory.openSession();
		
		SearchCriteria cri = new SearchCriteria();
		
		cri.setSearchType("t");
		cri.setKeyword("1");
		
		int cnt = 0;
		try {
			cnt = dao.getSearchBoardListCount(session, cri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(2, cnt);
	}

}
