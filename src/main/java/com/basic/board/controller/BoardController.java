package com.basic.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.basic.board.service.IBoardService;
import com.basic.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final IBoardService service;

	@GetMapping(value = "detail")
	public String selectBoardDetail(@RequestParam String bno, Model model) {
		int boardNo = Integer.parseInt(bno);
		
		BoardVO boardDetail = service.selectBoardDetail(boardNo);
		
		model.addAttribute("board", boardDetail);
		return "detail";
	}
}
