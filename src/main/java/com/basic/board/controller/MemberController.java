package com.basic.board.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basic.board.service.IMemberService;
import com.basic.board.service.MemberServiceImpl;
import com.basic.board.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor 
public class MemberController {
	private final IMemberService service;
	
	@GetMapping(value = "/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping(value="/login")
	@ResponseBody
	public String postLogin(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(id);
		memVo.setMem_pass(pwd);
		String result = service.login(memVo);
		
		if(result != null) {			
			Cookie user = new Cookie("user", id);
			response.addCookie(user);
			return result;
		}else {
			return "";			
		}
		
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("user")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
		return "redirect:/";
	}
	
	@GetMapping(value="/regist")
	public String getRegist() {
		return "regist";
	}
	
	@PostMapping(value="/regist")
	@ResponseBody
	public String postRegist(MemberForm form) {
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(form.getId());
		memVo.setMem_pass(form.getPwd());
		memVo.setMem_name(form.getName());
		memVo.setMem_email(form.getEmail());
		String result = service.saveMember(memVo);
		return result;
	}
	
}
