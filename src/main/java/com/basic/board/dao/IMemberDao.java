package com.basic.board.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.basic.board.vo.MemberVO;

public interface IMemberDao {
	//ȸ������
	void insertMember(SqlSession session,  MemberVO memVo) throws SQLException;
	
	//���̵��ߺ�Ȯ��
	int idCheck(SqlSession session, String memId) throws SQLException;
	
	String login(SqlSession session, MemberVO memVo) throws SQLException;
}
