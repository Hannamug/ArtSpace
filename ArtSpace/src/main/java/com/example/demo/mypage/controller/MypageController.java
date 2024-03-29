package com.example.demo.mypage.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.hall.dto.HallDTO;
import com.example.demo.mypage.dto.PerformerDTO;
import com.example.demo.mypage.service.MypageService;
import com.example.demo.user.dto.UserDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("mypage")
public class MypageController {

	@Autowired
	MypageService mypageService;

	@Autowired
	HttpSession session;
	
	@GetMapping("")
	public String mypage(Model model, HttpSession session) {
		Integer id = (Integer) session.getAttribute("user_id");
		UserDTO myInfo = mypageService.findByID(id);
		model.addAttribute("my_info", myInfo);
		return "html/mypage/mypage";
	}

	// 공연자 정보 기본
	@GetMapping("/performer")
	public String performer() {
		return "html/mypage/performer_info";
	}

	// 로그인 회원 공연자 정보 조회
//	@GetMapping("/{id}/performer")
//	public String perform(Model model, @PathVariable("id") Integer id) {
//		UserDTO myInfo = mypageService.findByID(id);
//		PerformerDTO perfoInfo = mypageService.findByPID(id);
//		model.addAttribute("my_info", myInfo);
//		model.addAttribute("perfo_info", perfoInfo);
//		model.addAttribute("id", id);
//		return "html/mypage/performer_info";
//	}

	// 공연자 정보 등록 및 수정
//	@PostMapping("{id}/performer")
//	public String insertPerformer(@ModelAttribute PerformerDTO dto, @PathVariable("id") Integer id) {
//		dto.setUser_id(id);
//		mypageService.insert(dto);
//		return "redirect:/mypage/" + id + "/performer";
//	}

	// 내 즐겨찾기
	@GetMapping("/favorite")
	public String favorite() {
		return "html/mypage/my_favorites";
	}

	// 로그인 회원 내 즐겨찾기
//	@GetMapping("/{id}/favorite")
//	public String favor(Model model, @PathVariable("id") Integer id) {
//		UserDTO myInfo = mypageService.findByID(id);
//		model.addAttribute("my_info", myInfo);
//		model.addAttribute("id", id);
//		return "html/mypage/my_favorites";
//	}
	
	
	// 예약 내역
	@GetMapping("/reserve")
	public String reserve() {
		return "html/mypage/reservation_list";
	}

	// 이용 내역
	@GetMapping("/uselist")
	public String uselist() {
		return "html/mypage/use_list";
	}

	// 리뷰 작성 및 작성 내역
	@GetMapping("/review")
	public String review() {
		return "html/mypage/my_review";
	}

	
	// 닉네임 수정
	@PostMapping("/update/nickname")
    public String updateNickname(@ModelAttribute UserDTO dto) {
        
        Integer userId = (Integer) session.getAttribute("user_id");
        dto.setUser_id(userId); 
        mypageService.updateNickname(dto);
        return "redirect:/mypage";
    }
	
	// 닉네임 수정
//	@PostMapping("update/nickname")
//	public String updateNickname(@ModelAttribute UserDTO dto) {
//		mypageService.updateNickname(dto);
//		return "redirect:/mypage";
//	}

	// 패스워드 수정
	@PostMapping("update/pw")
	public String updatePw(@ModelAttribute UserDTO dto) {
		mypageService.updatePw(dto);
		return "redirect:/mypage";
	}

	
}
