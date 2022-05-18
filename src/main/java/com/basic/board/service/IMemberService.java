package com.basic.board.service;

import org.springframework.stereotype.Service;

import com.basic.board.vo.MemberVO;

public interface IMemberService {
	//회원가입
	public String saveMember(MemberVO memVo) throws Exception;
	
	//로그인
	public String login(MemberVO memVo) throws Exception;
}
