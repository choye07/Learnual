package com.learn.bbs.crs.apphstr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.bbs.crs.apphstr.service.AppHstrService;
import com.learn.bbs.crs.apphstr.vo.AppHstrReadResponseVO;
import com.learn.bbs.crs.apphstr.vo.AppHstrRegistRequestVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.exceptions.AccessDeniedException;

import jakarta.servlet.http.HttpSession;


/**
 * @author 최예진
 * 신청 내역
 */
@Controller
public class AppHstrController {

    @Autowired
    private AppHstrService appHstrService;
    
    @ResponseBody
    @PostMapping("/insttn/usr/detail/{crsInfId}/register")
    public String doRegisterCourse(@PathVariable String crsInfId, HttpSession session) {
        UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");

        if (usrVO == null) {
            throw new AccessDeniedException();
        }

        AppHstrRegistRequestVO appHstrRegistRequestVO = new AppHstrRegistRequestVO();
        appHstrRegistRequestVO.setCrsInfId(crsInfId);
        appHstrRegistRequestVO.setUsrMl(usrVO.getUsrMl());
        appHstrRegistRequestVO.setInsttnId(usrVO.getInsttnId());

        boolean isSuccess = this.appHstrService.insertOneAppHstr(appHstrRegistRequestVO);

        return isSuccess ? "OK" : "FULL";
    }
    
    @GetMapping("/insttn/pltad/current/{crsInfId}")
    public String showCurrentUserInCourse(@PathVariable String crsInfId, Model model, HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

        if (pltadmVO == null) {
            throw new AccessDeniedException();
        }
        
        List<AppHstrReadResponseVO> currentUsers = this.appHstrService.selectCurrentUserInCourse(crsInfId, pltadmVO.getInsttnId());
        
        String courseName = this.appHstrService.selectCourseName(crsInfId, pltadmVO.getInsttnId());
        
        model.addAttribute("currentUsers", currentUsers);
        model.addAttribute("courseName", courseName);
        
    	return "/bbs/crs/coursecurrent";
    }
}