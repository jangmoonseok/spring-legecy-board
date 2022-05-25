package com.basic.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic.board.HomeController;
import com.basic.board.command.SearchCriteria;
import com.basic.board.vo.BoardVO;
import com.basic.util.MybatisSqlSessionFactory;

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

		
		try {
			List<BoardVO> selectSearchBoardList = dao.selectSearchBoardList(session, cri);
			System.out.println(selectSearchBoardList);
			
			Assert.assertEquals(1, selectSearchBoardList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
