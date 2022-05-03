package com.basic.board.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.basic.board.dao.IMemberDao;
import com.basic.board.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements IMemberService {
	private final IMemberDao dao;
	

	public String saveMember(MemberVO memVo) {
		String result = null;
		
		int idCheck = idCheck(memVo.getMem_id());
		if(idCheck > 0) {
			result = "이미 등록된 회원입니다.";
		}else {
			String memId = insertMember(memVo);
			result = memId + "님 회원가입되었습니다.";
		}
		
		return result; 
	}
	
	@Override
	public String insertMember(MemberVO memVo) {
		String result = null;
		
		try {
			result = dao.insertMember(memVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int idCheck(String memId) {
		int cnt = 0;
		
		try {
			cnt = dao.idCheck(memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String login(MemberVO memVo) {
		String result = null;
		
		try {
			result = dao.login(memVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
