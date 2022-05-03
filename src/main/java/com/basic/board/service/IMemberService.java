package com.basic.board.service;

import org.springframework.stereotype.Service;

import com.basic.board.vo.MemberVO;

public interface IMemberService {
	//회원가입
	public String insertMember(MemberVO memVo);
	
	//아이디 중복 확인
	public int idCheck(String memId);
	
	//로그인
	public String login(MemberVO memVo);
}
