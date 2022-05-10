package com.basic.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basic.board.service.IBoardService;
import com.basic.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@ComponentScan
@Controller
@RequiredArgsConstructor
public class HomeController {
	private final IBoardService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping(value = "/")
	public String home(Locale locale, Model model) {
		List<BoardVO> boardList = service.selectBoardList();
		model.addAttribute("boardList", boardList);
		return "home";
	}
	

	
}
