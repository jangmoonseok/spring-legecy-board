package com.basic.board.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic.board.HomeController;

public class MemberControllerTest {

	@SuppressWarnings("resource")
	@Test
	public void registMemberTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HomeController.class);
		MemberController controller = ac.getBean(MemberController.class);
	}

}
