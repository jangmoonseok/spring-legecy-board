package com.basic.board.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.basic.board.vo.MemberVO;

public interface IMemberDao {
	//회원가입
	void insertMember(SqlSession session,  MemberVO memVo) throws SQLException;
	
	//아이디중복확인
	int idCheck(SqlSession session, String memId) throws SQLException;
	
	String login(SqlSession session, MemberVO memVo) throws SQLException;
}
