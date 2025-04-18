package com.learn.main.ntc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.main.ntc.service.MainNtcService;
import com.learn.main.ntc.vo.NtcListVO;

@RestController
public class MainNtcRestController {
	
    @Autowired
    private MainNtcService mainNtcService;
    
    // 메인 화면에서 공지사항 widget 에서 메인 공지사항 list 보기
    @GetMapping("/api/ntc/list") // API 경로 설정
    public NtcListVO getMainNoticeListByAjax() {
        return this.mainNtcService.getAllMainNotice();
    }
}
