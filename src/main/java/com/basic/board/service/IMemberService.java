package com.basic.board.service;

import org.springframework.stereotype.Service;

import com.basic.board.vo.MemberVO;

public interface IMemberService {
	//ȸ������
	public String saveMember(MemberVO memVo) throws Exception;
	
	//�α���
	public String login(MemberVO memVo) throws Exception;
}
