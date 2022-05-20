package com.basic.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.basic.board.command.Criteria;
import com.basic.board.service.IBoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardListController {
	private final IBoardService service;
	
	@GetMapping(value="list")
	public String boardList(@RequestParam Map<String, Object> paramMap) {
		String page = (String)paramMap.get("page");
		String perPageNum = (String)paramMap.get("perPageNum");
		
		Criteria cri = new Criteria();
		
		boolean criFlag = true;
		
		criFlag = criFlag && page != null
						  && !page.isEmpty()
						  && perPageNum != null
						  && !perPageNum.isEmpty();
		
		if(criFlag) {
			try {
				cri.setPage(Integer.parseInt(page));
				cri.setPerPageNum(Integer.parseInt(perPageNum));
			} catch (Exception e) {
				
			}
			
		}
		return null;
	}
}