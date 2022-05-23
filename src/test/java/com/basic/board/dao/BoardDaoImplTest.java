package com.basic.board.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic.board.HomeController;
import com.basic.board.vo.BoardVO;
import com.basic.util.MybatisSqlSessionFactory;

public class BoardDaoImplTest {

	private ApplicationContext ac;
	private SqlSessionFactory factory;
	
	@Before
	public void init() {
		ac = new AnnotationConfigApplicationContext(HomeController.class);
		factory = new MybatisSqlSessionFactory();
	}
	
	@Test
	public void singletonTest() {
		IBoardDao boardDao1 = ac.getBean(IBoardDao.class);
		IBoardDao boardDao2 = ac.getBean(IBoardDao.class);
		
		Assert.assertEquals(boardDao1, boardDao2);
	}
	
	@Test
	public void getBoardListCountTest()  {
		IBoardDao dao = ac.getBean(IBoardDao.class);
		SqlSession session = factory.openSession();
		
		try {
			int cnt = dao.getBoardListCount(session);
			System.out.println(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
