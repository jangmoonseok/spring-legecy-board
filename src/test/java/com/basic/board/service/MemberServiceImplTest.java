package com.basic.board.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic.board.HomeController;
import com.basic.board.vo.MemberVO;

public class MemberServiceImplTest {

	@Test
	public void saveMemberTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HomeController.class);
		MemberServiceImpl service = ac.getBean(MemberServiceImpl.class);
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id("mimi");
		memVo.setMem_name("mimi");
		memVo.setMem_pass("mimi");
		memVo.setMem_email("dsad@dasda.com");
		
		String result = service.saveMember(memVo);
		
		System.out.println(result);
	}
	
	@Test
	public void loginTest() {
		ApplicationContext ac =  new AnnotationConfigApplicationContext(HomeController.class);
		MemberServiceImpl service = ac.getBean(MemberServiceImpl.class);
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id("dasds");
		memVo.setMem_pass("mimi");
		String result = service.login(memVo);
		
		System.out.println(result);
	}

}
