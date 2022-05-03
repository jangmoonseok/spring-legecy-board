package com.basic.board.dao;

import java.sql.SQLException;

import com.basic.board.vo.MemberVO;

public interface IMemberDao {
	//회원가입
	String insertMember(MemberVO memVo) throws SQLException;
	
	//아이디중복확인
	int idCheck(String memId) throws SQLException;
}
