package com.basic.board.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic.board.vo.MemberVO;

public class OMemberDaoImplTest {

	
	@SuppressWarnings("resource")
	@Test
	public void singletonTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(OMemberDaoImpl.class);
		OMemberDaoImpl bean1 = ac.getBean(OMemberDaoImpl.class);
		OMemberDaoImpl bean2 = ac.getBean(OMemberDaoImpl.class);
		
		System.out.println("bean1 = " + bean1);
		System.out.println("bean2 = " + bean2);
	}
	
	@SuppressWarnings("resource")
	@Test
	public void insertMemberTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(OMemberDaoImpl.class);
		OMemberDaoImpl dao = ac.getBean(OMemberDaoImpl.class);
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id("mimi");
		memVo.setMem_pass("mimi");
		memVo.setMem_email("dasd@ddasd.com");
		memVo.setMem_name("mimi");
		
		String id = "";
		try {
			id = dao.insertMember(memVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(id);
	}

}
