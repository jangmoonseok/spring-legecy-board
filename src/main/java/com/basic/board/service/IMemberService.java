package com.basic.board.service;

import org.springframework.stereotype.Service;

import com.basic.board.vo.MemberVO;

public interface IMemberService {
	//ȸ������
	public String insertMember(MemberVO memVo);
	
	//���̵� �ߺ� Ȯ��
	public int idCheck(String memId);
	
	//�α���
	public String login(MemberVO memVo);
}
