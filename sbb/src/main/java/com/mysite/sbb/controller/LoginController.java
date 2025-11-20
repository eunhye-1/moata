package com.mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final UserService userService;
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	/*
	@PostMapping("/login")
	    public String loginProcess(@RequestParam("userId") String userId,
	                               @RequestParam("password") String password,
	                               HttpSession session,
	                               Model model) {

	        try {
	            SiteUser user = userService.login(userId, password);
	            session.setAttribute("loginUser", user);   // 로그인 유지
	            return "redirect:/";  // 성공하면 메인으로 이동
	        } catch (RuntimeException e) {
	            model.addAttribute("error", e.getMessage());
	            return "login";  // 실패하면 그대로 login.html
	        }
	 }
	 */
}
