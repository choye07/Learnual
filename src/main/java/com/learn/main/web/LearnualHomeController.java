package com.learn.main.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/learnual")
public class LearnualHomeController {
	
	@GetMapping("/")
	public String leanualHome() {
		return "mainhome";
	}
}
