package com.learn.bbs.crs.apphstr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.crs.apphstr.service.AppHstrService;
import com.learn.bbs.crs.apphstr.vo.AppHstrVO;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author 최예진
 * 신청 내역
 */
@Controller
public class AppHstrController {

    @Autowired
    private AppHstrService appHstrService;
    
    @PostMapping("/insttn/usr/detail/{crsInfId}/register")
    public String doRegisterCourse(@PathVariable String crsInfId,
			  					   Model model) {
    	AppHstrVO appHstrVO = new AppHstrVO();
    	appHstrVO.setCrsInfId(crsInfId);
    	appHstrVO.setUsrId("USR_20250419_000002"); // 로그인된 유저의 ID <- 여기서 session 사용하시면 될듯!

    	this.appHstrService.insertOneAppHstr(appHstrVO);
    	
    	return "redirect:/insttn/usr/detail/{crsInfId}";
    }
}