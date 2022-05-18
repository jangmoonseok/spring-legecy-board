package com.basic.util;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.basic.board.vo.BoardVO;

public class MybatisSqlSessionFactoryTest {

	private SqlSessionFactory sessionFactory = new MybatisSqlSessionFactory();
	private SqlSession session;
	
	@Before
	public void init() {
		session = sessionFactory.openSession();
	}
	
	@Test
	public void sessionFactoryTest() {
		Assert.assertNotNull(sessionFactory);
	}
	
	@Test
	public void testSqlSession() throws Exception{
		Collection<String> mapNames = session.getConfiguration().getMappedStatementNames();
		
		Assert.assertTrue(mapNames.contains("board.selectBoardList"));
	}
	
	@Test
	public void selectBoardListTest() {
		List<BoardVO> selectList = session.selectList("board.selectBoardList");
		
		Assert.assertEquals(4, selectList.size());
	}
	
	@After
	public void close() {
		session.close();
	}
}
