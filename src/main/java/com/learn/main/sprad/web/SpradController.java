package com.learn.main.sprad.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.pltad.service.PltAdService;
import com.learn.bbs.pltad.vo.PltadRegistRequestVO;
import com.learn.bbs.pltad.vo.PltadmLoginRequestVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.common.vo.LoginRequestVO;
import com.learn.main.sprad.service.SpradService;
import com.learn.main.sprad.vo.SpradLoginRequestVO;
import com.learn.main.sprad.vo.SpradmVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class SpradController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpradController.class);

	
    @Autowired
    private SpradService spradService;
    
	@PostMapping("/sprad/login")
	public String doLogin(@Valid @ModelAttribute LoginRequestVO loginRequestVO, BindingResult bindingResult,
			@RequestParam(required = false, defaultValue = "/learnual") String nextUrl, Model model, HttpSession session,
			HttpServletRequest request) {
		
		String userIp = request.getRemoteAddr();
		LOGGER.debug(userIp);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginInput", loginRequestVO);
			return "/main/mainlogin";
		}

		SpradLoginRequestVO spradLoginRequestVO = new SpradLoginRequestVO();
		spradLoginRequestVO.setSpradmLgnId(loginRequestVO.getLgnId());
		spradLoginRequestVO.setSpradmLgnPw(loginRequestVO.getLgnPw());

		SpradmVO spradmVO = this.spradService.doLogin(spradLoginRequestVO);
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("__LOGIN_SPRAD__", spradmVO);

		return "redirect:" + nextUrl;
	}

    @GetMapping("/sprad/logout") 
    public String doLogout(HttpSession session) { 
    	SpradmVO spradmVO = (SpradmVO) session.getAttribute("__LOGIN_SPRAD__");
    	 
    	this.spradService.doLogout(spradmVO.getSpradmLgnId());
    	
    	// 세션 폐기 (로그아웃)
    	session.invalidate(); 
    	return "redirect:/learnual";
    }

}