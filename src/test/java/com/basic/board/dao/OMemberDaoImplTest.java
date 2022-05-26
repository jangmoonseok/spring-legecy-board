package com.basic.board.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic.board.HomeController;
import com.basic.board.util.MybatisSqlSessionFactory;
import com.basic.board.vo.MemberVO;

public class OMemberDaoImplTest {

	
	@Test
	public void singletonTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(OMemberDaoImpl.class);
		OMemberDaoImpl bean1 = ac.getBean(OMemberDaoImpl.class);
		OMemberDaoImpl bean2 = ac.getBean(OMemberDaoImpl.class);
		
		System.out.println("bean1 = " + bean1);
		System.out.println("bean2 = " + bean2);
	}
	
	@Test
	public void insertMemberTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HomeController.class);
		OMemberDaoImpl dao = ac.getBean(OMemberDaoImpl.class);
		SqlSessionFactory sessionFactory = new MybatisSqlSessionFactory();
		
		SqlSession session = sessionFactory.openSession();
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id("dasd");
		memVo.setMem_name("mimi");
		memVo.setMem_pass("mimi");
		memVo.setMem_email("dsad@dasda.com");
		String id = "";
		try {
			dao.insertMember(session,memVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HomeController.class);
		OMemberDaoImpl dao = ac.getBean(OMemberDaoImpl.class);
		SqlSessionFactory sessionFactory = new MybatisSqlSessionFactory();
		
		SqlSession session = sessionFactory.openSession();
		
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id("dasd");
		memVo.setMem_pass("mimi");
		
		String result = "";
		try {
			result = dao.login(session,memVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(result);
	}

}
