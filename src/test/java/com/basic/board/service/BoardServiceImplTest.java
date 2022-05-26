package com.basic.board.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic.board.HomeController;
import com.basic.board.command.SearchCriteria;
import com.basic.board.util.MybatisSqlSessionFactory;
import com.basic.board.vo.BoardVO;

import junit.framework.Assert;

public class BoardServiceImplTest {

	private ApplicationContext ac;
	private SqlSessionFactory factory;
	
	@Before
	public void init() {
		ac = new AnnotationConfigApplicationContext(HomeController.class);
		factory = new MybatisSqlSessionFactory();
	}
	
	@Test
	public void getSearchBoardList() {
		BoardServiceImpl service = ac.getBean(BoardServiceImpl.class);
		
		SearchCriteria cri = new SearchCriteria();
		cri.setSearchType("t");
		cri.setKeyword("1");
		
		try {
			Map<String, Object> dataMap = service.getBoardListForPage(cri);
			List<BoardVO> boardList = (List<BoardVO>)dataMap.get("boardList");
			
			for(BoardVO board : boardList) {
				System.out.println(board.getBoard_title());
			}
			Assert.assertEquals(2, boardList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
