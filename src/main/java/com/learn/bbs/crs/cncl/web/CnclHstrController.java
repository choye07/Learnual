package com.learn.bbs.crs.cncl.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.crs.cncl.service.CnclHstrService;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author 최예진
 * 취소 내역
 */
@Controller
public class CnclHstrController {

    @Autowired
    private CnclHstrService cnclHstrService;

    @PostMapping("/insttn/usr/detail/{crsInfId}/cancel")
    public String doCancelCourse(@PathVariable String crsInfId, Model model) {
        String usrId = "USR-20250419-000002"; // 로그인된 유저의 ID <- session에서 가져오면 될거같아요
        boolean isCancelled = this.cnclHstrService.insertCancelledAppHstr(crsInfId, usrId);

        return "redirect:/insttn/usr/detail/{crsInfId}";
    }
}