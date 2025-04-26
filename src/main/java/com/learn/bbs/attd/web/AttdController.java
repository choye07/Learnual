package com.learn.bbs.attd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.learn.bbs.attd.service.AttdService;
import com.learn.bbs.attd.vo.AttdRegistRequestVO;
import com.learn.bbs.usr.vo.UsrVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


/**
 * @author 최예진
 * 신청 내역
 */
@Controller
public class AttdController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AttdController.class);

    @Autowired
    private AttdService attdService;
    
	@PostMapping("/attd/regist")
    public ResponseEntity<AttdRegistRequestVO> doUsrAttdRegist(
    		@Valid @RequestBody AttdRegistRequestVO attdRegistRequestVO, 
    		BindingResult bindingResult,
    		HttpSession session, 
    		Model model
		) {
		
		// 회원의 정보를 Session 에서 가져온다. (__LOGIN_USER__) => UsrVO
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
    	
		attdRegistRequestVO.setUsrMl(usrVO.getUsrMl());
    	
    	// 이상 없으면 Service 호출
    	//this.attdService.createNewUsrAttd(attdRegistRequestVO);
		this.attdService.doUsrAttd(attdRegistRequestVO);
		
		// 클라이언트가 필요한 데이터를 JSON으로 반환
		// 출석 / 지각 판단 여부 때문에 필요. 
	    return ResponseEntity.ok(attdRegistRequestVO);
    }
	
	
	@PostMapping("/attd/current")
    public ResponseEntity<AttdRegistRequestVO> doUsrAttdCurrentUpdate(
    		@Valid @RequestBody AttdRegistRequestVO attdRegistRequestVO, 
    		BindingResult bindingResult,
    		HttpSession session, 
    		Model model
		) {

		// 회원의 정보를 Session 에서 가져온다. (__LOGIN_USER__) => UsrVO
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		
		attdRegistRequestVO.setUsrMl(usrVO.getUsrMl());
		
		this.attdService.updateUsrAttdCurrent(attdRegistRequestVO);
    	return ResponseEntity.ok(attdRegistRequestVO);
    }
}