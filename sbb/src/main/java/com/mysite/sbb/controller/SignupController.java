package com.mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import com.mysite.sbb.user.UserService;

@Controller
@RequiredArgsConstructor
public class SignupController {
	
	private final UserService userService;
	
	@GetMapping("/signup")
	public String signupPage() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signupProcess(@RequestParam("userId") String userId,
            						@RequestParam("password") String password,
            						@RequestParam("phoneNumber") String phoneNumber,
            						@RequestParam("passwordRe") String passwordRe,
            						Model model) {
		try {
			userService.signup(userId,password,phoneNumber,passwordRe);
			return "redirect:/login"; // 회원가입 성공하면 로그인 화면으로 이동
		} catch (RuntimeException e) {
			model.addAttribute("error",e.getMessage());
			return "signup";
		}
		
	}
	
}
