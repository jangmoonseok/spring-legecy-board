package com.basic.board.dao;

import java.sql.SQLException;

import com.basic.board.vo.MemberVO;

public interface IMemberDao {
	//ȸ������
	String insertMember(MemberVO memVo) throws SQLException;
	
	//���̵��ߺ�Ȯ��
	int idCheck(String memId) throws SQLException;
}
