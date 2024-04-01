package com.example.demo.announcement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {

	@GetMapping("/announcement/board")
	public String showboardPage() {
		return "html/announcement/board";
		
	}
}