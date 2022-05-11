package com.basic.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basic.board.service.IBoardService;
import com.basic.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final IBoardService service;

	@GetMapping(value = "detail")
	public String selectBoardDetail(@RequestParam String bno, Model model) {
		BoardVO board = getBoard(bno);
		
		if(board == null) {
			model.addAttribute("error", "500");
			return "error";
		}
		
		model.addAttribute("board", board);
		return "detail";
	}
	
	@GetMapping(value="update")
	public String getUpdateBoard(@RequestParam String bno, Model model) {
		BoardVO board = getBoard(bno);
		
		if(board == null) {
			model.addAttribute("error", "500");
			return "error";
		}
		
		model.addAttribute("board", board);
		return "update";
	}
	
	@PostMapping(value="update")
	@ResponseBody
	public String postUpdateBoard(@RequestParam Map<String, Object> paramMap) {
		int bno = Integer.parseInt((String)paramMap.get("boardNo"));
		String title = (String)paramMap.get("title");
		String content = (String)paramMap.get("content");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_no(bno);
		boardVO.setBoard_title(title);
		boardVO.setBoard_content(content);
		
		int cnt = service.updateBoard(boardVO);
		
		return "" + cnt;
	}
	
	@PostMapping(value="delete")
	@ResponseBody
	public String deleteBoard(@RequestParam String bno) {
		int boardNO = Integer.parseInt(bno);
		
		int cnt = service.deleteBoard(boardNO);
		
		return "" + cnt;
	}
	
	private BoardVO getBoard(String bno) {
		int boardNo = Integer.parseInt(bno);
		BoardVO boardDetail = null;
		
		boardDetail = service.selectBoardDetail(boardNo);
		
		return boardDetail;
	}
}
