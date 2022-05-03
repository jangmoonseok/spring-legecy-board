package com.basic.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String postLogin(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		System.out.println(id + "," + pwd);
		return null;
	}
}
