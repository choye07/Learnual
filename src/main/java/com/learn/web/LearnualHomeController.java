package com.learn.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LearnualHomeController {
	
	@GetMapping("/")
	public String leanualHome() {
		return "home";
	}
}
