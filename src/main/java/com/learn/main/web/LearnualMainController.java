package com.learn.main.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LearnualMainController {
	
	@GetMapping("/")
	public String goMain() {
		return "main/mainhome";
	}
	
	@GetMapping("/login")
	public String goMainLogin() {
		return "main/mainlogin";
	}
	
	@GetMapping("/regist")
	public String goMainRegist() {
		return "main/mainregist";
	}
	
	// 임시 대시보드 매핑
	@GetMapping("/dashboard/student")
	public String goStudentDashboard() {
		return "dashboard/dashboardstudent";
	}
	
	@GetMapping("/dashboard/tutor")
	public String goTutorDashboard() {
		return "dashboard/dashboardtutor";
	}
}
