package com.basic.board.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.basic.board.vo.MemberVO;
import com.basic.util.SqlMapClientFactory;
import com.ibatis.sqlmap.client.SqlMapClient;

import lombok.RequiredArgsConstructor;

@Repository
public class OMemberDaoImpl implements IMemberDao {
	

	@Override
	public void insertMember(SqlSession session, MemberVO memVo) throws SQLException {
		session.insert("member.insertMember", memVo);
	}

	@Override
	public int idCheck(SqlSession session, String memId) throws SQLException {
		int cnt = 0;
		
		cnt = session.selectOne("member.idCheck", memId);
				
		return cnt;
	}

	@Override
	public String login(SqlSession session, MemberVO memVo) throws SQLException {
		String result = "";
		
		result = session.selectOne("member.login", memVo);

		return result;
	}

}
