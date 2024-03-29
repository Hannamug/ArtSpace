package com.example.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.user.dto.UserDTO;
import com.example.demo.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 일반 회원가입 화면 띄움
	@GetMapping("/user/singin")
	public String showJoin() {
		return "html/login/loginjoin";
	}

	// 유저 데이터 insert 처리
	@PostMapping("/user/insert")
	public String insertUser(@ModelAttribute UserDTO userDTO) {
		
		userService.insert(userDTO);
		return "html/login/logincode";
	}
	
	
	// 회원가입 완료 페이지 오픈
	@PostMapping("user/welcome")
	public String welcome() {
		
		return "html/login/loginwelcome";
	}
	
	// 법인 회원가입인증 화면 띄움
	@GetMapping("/user/corporation")
	public String checkCor() {
		return "html/login/login_corporation";
	} 
	
	// 법인 데이터 회원가입 화면 띄움
	@PostMapping("/user/joincorporation")
	public String joinCor() {
		return "html/login/login_joincorporation";
	} 
	
	// 법인 회원가입인증코드 화면 띄움
	@PostMapping("/user/codecorporation")
	public String codeCor() {
		return "html/login/login_code_corporation";
	} 
	
	// 법인 회원가입 완료 화면 띄움
	@PostMapping("/user/welcomecorporation")
	public String welcomeCor() {
		return "html/login/login_welcome_corporation";
	} 
	
	
	

}
