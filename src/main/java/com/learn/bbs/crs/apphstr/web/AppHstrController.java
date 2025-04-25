package com.learn.bbs.crs.apphstr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.crs.apphstr.service.AppHstrService;
import com.learn.bbs.crs.apphstr.vo.AppHstrVO;
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
    
    @PostMapping("/insttn/usr/detail/{crsInfId}/register")
    public String doRegisterCourse(@PathVariable String crsInfId,
                                    Model model,
                                    HttpSession session) {
        UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
        
        if (usrVO == null) {
            throw new AccessDeniedException();
        }

        String usrMl = usrVO.getUsrMl();
        
        // '강좌 신청 시' 정원 초과 체크
        boolean isCourseFull = this.appHstrService.insertOneAppHstr(crsInfId, usrMl);

        // 정원 초과일 경우
        if (!isCourseFull) {
            model.addAttribute("isCourseFull", true);
            return "insttn/usr/detail/" + crsInfId;
        }

        // 정원 초과 아닐 경우
        this.appHstrService.insertOneAppHstr(crsInfId, usrMl);
        
        model.addAttribute("isCourseFull", false);
        return "insttn/usr/detail/" + crsInfId;
    }
}