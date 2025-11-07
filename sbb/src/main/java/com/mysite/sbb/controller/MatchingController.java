package com.mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MatchingController {
	
	@GetMapping("/matching")
	public String matchingPage() {
		return "matching";
	}
	
}
