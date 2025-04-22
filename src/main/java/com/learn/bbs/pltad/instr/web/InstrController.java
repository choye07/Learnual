package com.learn.bbs.pltad.instr.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.bbs.pltad.instr.service.InstrService;
import com.learn.bbs.pltad.instr.vo.InstrLoginRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.common.vo.LoginRequestVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


/**
 * @TableName INSTR
 * @TableComment null
 * 강사
 */
@Controller
public class InstrController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InstrController.class);

    @Autowired
    private InstrService instrService;
    
    @PostMapping("pltad/instrmanage/regist")
    public String doInstrRegist(@Valid 
			@ModelAttribute  InstrRegistRequestVO instrRegistRequestVO,
			BindingResult bindingResult,
			Model model) {
    	
    	instrRegistRequestVO.setLgnId("admin");
    	
		boolean isCreated = this.instrService.createInstr(instrRegistRequestVO);
		
		if (isCreated) {
			return "/success";
		}

    	return"/fail";
    }
    
    @PostMapping("/instr/login")
	public String doLogin(@Valid @ModelAttribute LoginRequestVO loginRequestVO, BindingResult bindingResult,
			@RequestParam(required = false, defaultValue = "/") String nextUrl, Model model, HttpSession session,
			HttpServletRequest request) {

		// 사용자의 IP 를 가져올 때 HttpServeltRequest 가 사용.
		String userIp = request.getRemoteAddr();
		LOGGER.debug(userIp);
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginInput", loginRequestVO);
			return "/main/mainlogin";
		}

		InstrLoginRequestVO instrLoginRequestVO = new InstrLoginRequestVO();
		instrLoginRequestVO.setInstrLgnId(loginRequestVO.getLgnId());
		instrLoginRequestVO.setInstrLgnPw(loginRequestVO.getLgnPw());

		InstrVO instrVO = this.instrService.doLogin(instrLoginRequestVO);
		// 사이트에 접속했을 때 발급 받은 세션은 폐기(로그아웃)시킨다.
		session.invalidate();
		// 새로운 세션을 발급받는다.
		session = request.getSession(true);
		// 서버가 Session 에 회원 정보를 기록(기억) 한다.
		// 해당 사용자의 고유한 세션의 아이디를 브라우저에게 "Cookie" 로 보내준다.
		session.setAttribute("__LOGIN_INSTR__", instrVO);

		return "redirect:" + nextUrl;
	}
    
    @GetMapping("/instr/logout") 
    public String doLogout(HttpSession session) { 
    	// 회원의 정보를 Session 에서 가져온다. (__LOGIN_USER__) => UsrVO
    	InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
    	 
    	this.instrService.doLogout(instrVO.getInstrLgnId());
    	
    	// 세션 폐기 (로그아웃)
    	session.invalidate(); 
    	return "redirect:/";
    }

}