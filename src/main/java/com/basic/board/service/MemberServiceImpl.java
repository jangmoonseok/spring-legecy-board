package com.basic.board.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.basic.board.dao.IMemberDao;
import com.basic.board.vo.MemberVO;
import com.basic.util.MybatisSqlSessionFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements IMemberService {
	private final IMemberDao dao;
	private final SqlSessionFactory sessionFactory = new MybatisSqlSessionFactory();

	@Override
	public String login(MemberVO memVo) throws Exception{
		SqlSession session = sessionFactory.openSession();
		
		String result = null;
		
		try {
			result = dao.login(session, memVo);
		}finally {
			if(session != null) session.close();
		}
		
		return result;
	}

	@Override
	public String saveMember(MemberVO memVo) throws Exception{
		SqlSession session = sessionFactory.openSession();
		
		String result = "";
		
		try {
			int idCheck = dao.idCheck(session, memVo.getMem_id());
			if(idCheck > 0) {
				result = "false";
			}else {
				dao.insertMember(session, memVo);
				result = "success";
			}
			
		}finally {
			if(session != null) session.close();
		}
		
		return result;
		
	}

}
