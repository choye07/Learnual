package com.learn.bbs.eduad.crntc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.bbs.eduad.crntc.service.CrNtcService;
import com.learn.bbs.eduad.crntc.vo.CrntcListVO;

@RestController
public class CrntcRestController {
	
	@Autowired
	private CrNtcService crntcService;
	
    // 강좌 메인 화면의 공지사항 widget 에서 강좌 공지사항 list 보기
    @GetMapping("/api/crntc/list") // API 경로 설정
    public CrntcListVO getMainNoticeListByAjax() {
        return this.crntcService.getAllCourseNotice();
    }
}
