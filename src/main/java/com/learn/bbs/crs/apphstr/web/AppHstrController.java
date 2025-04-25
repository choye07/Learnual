package com.learn.bbs.crs.apphstr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.bbs.crs.apphstr.service.AppHstrService;
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
    public String doRegisterCourse(@PathVariable String crsInfId,
                                   HttpSession session) {
        UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
        
        if (usrVO == null) {
            throw new AccessDeniedException();
        }

        String usrMl = usrVO.getUsrMl();
        
        boolean isSuccess = this.appHstrService.insertOneAppHstr(crsInfId, usrMl);

        if (!isSuccess) {
            return "FULL"; // 정원 초과
        }

        return "OK"; // 신청 완료
    }
}