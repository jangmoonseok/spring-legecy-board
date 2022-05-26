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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic.board.HomeController;
import com.basic.board.util.MybatisSqlSessionFactory;
import com.basic.board.vo.BoardVO;

public class MybatisSqlSessionFactoryTest {

	private ApplicationContext ac;
	
	@Before
	public void init() {
		ac = new AnnotationConfigApplicationContext(HomeController.class);
	}
	
	@Test
	public void factoryTest() {
		MybatisSqlSessionFactory bean = ac.getBean(MybatisSqlSessionFactory.class);
		
		Assert.assertNotNull(bean);
	}
	
}
