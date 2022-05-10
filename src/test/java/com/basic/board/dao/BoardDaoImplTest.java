package com.basic.board.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic.board.HomeController;
import com.basic.board.vo.BoardVO;

public class BoardDaoImplTest {

	private ApplicationContext ac;
	
	@Before
	public void init() {
		ac = new AnnotationConfigApplicationContext(HomeController.class);
	}
	
	@Test
	public void singletonTest() {
		IBoardDao boardDao1 = ac.getBean(IBoardDao.class);
		IBoardDao boardDao2 = ac.getBean(IBoardDao.class);
		
		Assert.assertEquals(boardDao1, boardDao2);
	}
	
	@Test
	public void insertBoardTest() {
		IBoardDao boardDao = ac.getBean(IBoardDao.class);
		
		BoardVO vo = new BoardVO();
		vo.setBoard_no(1);
		vo.setBoard_title("mimi1");
		vo.setBoard_content("dasmdasufasd");
		vo.setBoard_writer("mimi");
		int cnt = 0;
		try {
			cnt = boardDao.insertBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void updateBoardTest() {
		IBoardDao boardDao = ac.getBean(IBoardDao.class);
		
		BoardVO vo = new BoardVO();
		vo.setBoard_no(1);
		vo.setBoard_title("fsdcngf");
		vo.setBoard_content("fdghdfnle");
		
		int cnt = 0;
		try {
			cnt = boardDao.updateBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void deleteBoardTest() {
		IBoardDao boardDao = ac.getBean(IBoardDao.class);
		
		int cnt = 0;
		try {
			cnt = boardDao.deleteBoard(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void selectBoardListTest() {
		IBoardDao boardDao = ac.getBean(IBoardDao.class);
		
		List<BoardVO> list = null;
		
		try {
			list = boardDao.selectBoardList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(BoardVO vo : list) {
			System.out.println(vo.getBoard_no());
			System.out.println(vo.getBoard_title());
		}
		Assert.assertEquals(2, list.size());
	}
	
	@Test
	public void selectBoardDetailTest() {
		IBoardDao boardDao = ac.getBean(IBoardDao.class);
		
		BoardVO vo = null;
		try {
			vo = boardDao.selectBoardDetail(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(vo.getBoard_title());
		
		Assert.assertEquals("mimi1", vo.getBoard_title());
	}
}
