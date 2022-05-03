package com.basic.board.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.basic.board.vo.MemberVO;
import com.basic.util.SqlMapClientFactory;
import com.ibatis.sqlmap.client.SqlMapClient;

import lombok.RequiredArgsConstructor;

@Repository
public class OMemberDaoImpl implements IMemberDao {
	private static SqlMapClient smc = SqlMapClientFactory.getsqlMapClient();
	
	@Override
	public String insertMember(MemberVO memVo) throws SQLException {
		String memId = (String)smc.insert("member.insertMember", memVo);
		return memId;
	}

	@Override
	public int idCheck(String memId) throws SQLException {
		int cnt = 0;
		cnt = (int)smc.queryForObject("member.idCheck", memId);
		return cnt;
	}

	@Override
	public String login(MemberVO memVo) throws SQLException {
		String result = "";
		result = (String)smc.queryForObject("member.login", memVo);
		return result;
	}

}
