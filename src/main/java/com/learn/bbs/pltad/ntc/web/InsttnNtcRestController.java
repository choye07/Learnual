package com.learn.bbs.pltad.ntc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.bbs.pltad.ntc.service.InsttnNtcService;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcListVO;

@RestController
public class InsttnNtcRestController {
	
    @Autowired
    private InsttnNtcService insttnNtcService;
    
    // 학원 홈페이지 공지사항 widget 에서 학원 공지사항 list 보기
    @GetMapping("/api/insttnntc/list") // API 경로 설정
    public InsttnNtcListVO getMainNoticeListByAjax() {
        return this.insttnNtcService.getAllInsttnNotice();
    }
}
