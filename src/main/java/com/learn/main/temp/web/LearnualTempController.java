package com.learn.main.temp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LearnualTempController {
	
	@GetMapping("/test1")
	public String viewTest1() {
		return "/bbs/crs/maincourse";
	}
	
	@GetMapping("/test2")
	public String viewTest2() {
		return "/bbs/crs/coursecreate";
	}
	
	@GetMapping("/test3")
	public String viewTest3() {
		return "/bbs/crs/coursedetail";
	}
	
	@GetMapping("/test4")
	public String viewTest4() {
		return "/bbs/crs/courseconfirm";
	}
	
	@GetMapping("/test5")
	public String viewTest5() {
		return "/bbs/crs/courseregist";
	}
	
	@GetMapping("/test6")
	public String viewTest6() {
		return "/bbs/crs/coursemanage";
	}
	
	@GetMapping("/test7")
	public String viewTest7() {
		return "/bbs/crs/coursemodify";
	}
	
	@GetMapping("/test8")
	public String viewTest8() {
		return "/bbs/tst/tstboardediteduad";
	}
	
	@GetMapping("/test9")
	public String viewTest9() {
		return "/bbs/tst/tstboardwriteeduad";
	}
	
	@GetMapping("/test10")
	public String viewTest10() {
		return "/insttn/maininsttn";
	}
	
	@GetMapping("/test11")
	public String viewTest11() {
		return "bbs/super/managepltadwrite";
	}
	
}
