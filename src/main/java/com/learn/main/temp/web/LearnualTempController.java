package com.learn.main.temp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LearnualTempController {
	
	@GetMapping("/test1")
	public String viewTest1() {
		return "/common/component/editmyinfo";
	}
	
	@GetMapping("/test2")
	public String viewTest2() {
		return "/common/component/viewmyinfo";
	}
	
	@GetMapping("/test3")
	public String viewTest3() {
		return "/bbs/eduad/manageeduad";
	}
	
	@GetMapping("/test4")
	public String viewTest4() {
		return "/bbs/tst/tstboardlisteduad";
	}
	
	@GetMapping("/test5")
	public String viewTest5() {
		return "/bbs/tst/tstboardlistusr";
	}
	
	@GetMapping("/test6")
	public String viewTest6() {
		return "/bbs/tst/tstboardvieweduad";
	}
	
	@GetMapping("/test7")
	public String viewTest7() {
		return "/bbs/tst/tstboardviewusr";
	}
	
	@GetMapping("/test8")
	public String viewTest8() {
		return "/bbs/tst/tstboardediteduad";
	}
	
	@GetMapping("/test9")
	public String viewTest9() {
		return "/bbs/tst/tstboardwriteeduad";
	}
	
}
