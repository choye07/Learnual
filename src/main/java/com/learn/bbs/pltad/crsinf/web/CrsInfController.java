package com.learn.bbs.pltad.crsinf.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.crs.sbj.service.SbjService;
import com.learn.bbs.crs.sbj.vo.SbjVO;
import com.learn.bbs.pltad.crsinf.service.CrsInfService;
import com.learn.bbs.pltad.crsinf.vo.CrsInfRegistRequestVO;

import jakarta.validation.Valid;


/**
 * @author 최예진
 * 강좌 정보
 */
@Controller
public class CrsInfController {
//	private static final Logger LOGGER = Logger.getClass(CrsInfController.class);
    
    @Autowired
    private CrsInfService crsInfService;
    
    @Autowired
    private SbjService sbjService; 

    @PostMapping("/insttn/pltad/create")
    public String registerCourse(@Valid CrsInfRegistRequestVO crsInfRegistRequestVO,
    							 BindingResult bindingResult,
    							 Model model) {
        List<SbjVO> subjectList = sbjService.selectAllSubjects();
        
    	if(bindingResult.hasErrors()) {
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("subjectList", subjectList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/insttn/coursecreate";
    	}
    	
        if (this.crsInfService.countCourseName(crsInfRegistRequestVO.getCrsInfNm())) {
            model.addAttribute("duplicateTitleError", "이미 등록된 강좌 이름입니다. 다른 이름을 입력해주세요.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
            
            return "/insttn/coursecreate";
        }
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    	
    	LocalDateTime crsInfStDt = LocalDateTime.parse(crsInfRegistRequestVO.getCrsInfStDt(), formatter);
    	LocalDateTime crsInfEndDt = LocalDateTime.parse(crsInfRegistRequestVO.getCrsInfEndDt(), formatter);
    	LocalDateTime crsInfAppDt = LocalDateTime.parse(crsInfRegistRequestVO.getCrsInfAppDt(), formatter);
    	LocalDateTime crsInfDdlnDt = LocalDateTime.parse(crsInfRegistRequestVO.getCrsInfDdlnDt(), formatter);
    	
    	LocalDateTime today = LocalDateTime.now();
    	
    	if(crsInfStDt.isBefore(today)) {
    		model.addAttribute("crsInfStDtThanToday", "강좌 시작일은 오늘 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("subjectList", subjectList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/insttn/coursecreate";
    	}
    	
    	if(crsInfEndDt.isBefore(today)) {
    		model.addAttribute("crsInfEndDtThanToday", "강좌 종료일은 오늘 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("subjectList", subjectList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/insttn/coursecreate";
    	}
    	
    	if(crsInfAppDt.isBefore(today)) {
    		model.addAttribute("crsInfAppDtThanToday", "강좌 신청일은 오늘 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("subjectList", subjectList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/insttn/coursecreate";
    	}
    	
    	if(crsInfDdlnDt.isBefore(today)) {
    		model.addAttribute("crsInfDdlnDtThanToday", "강좌 마감일은 오늘 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("subjectList", subjectList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/insttn/coursecreate";
    	}
    	
    	if(crsInfEndDt.isBefore(crsInfStDt)) {
        	if(crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 시작/신청 시작일이 둘다 느림
        		model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
        		model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
                model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
                model.addAttribute("subjectList", subjectList);
        		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
        		
        		return "/insttn/coursecreate";
        	}
        	// 강좌 시작일만 느림
        	model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("subjectList", subjectList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/insttn/coursecreate";
    	} else {
        	if(crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 신청일만 느림
        		model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
                model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
                model.addAttribute("subjectList", subjectList);
        		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
        		
        		return "/insttn/coursecreate";
        	}
    	}
    	
    	if(crsInfDdlnDt.isAfter(crsInfStDt)) {
    		model.addAttribute("appDtAfterThanStDt", "강좌 시작일은 신청 마감일 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("subjectList", subjectList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/insttn/coursecreate";
    	}
    	
    	DateTimeFormatter resetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	
    	crsInfRegistRequestVO.setCrsInfStDt(crsInfStDt.format(resetFormatter));
    	crsInfRegistRequestVO.setCrsInfEndDt(crsInfEndDt.format(resetFormatter));
    	crsInfRegistRequestVO.setCrsInfAppDt(crsInfAppDt.format(resetFormatter)); 
    	crsInfRegistRequestVO.setCrsInfDdlnDt(crsInfDdlnDt.format(resetFormatter));
    	
    	this.crsInfService.insertOneCourse(crsInfRegistRequestVO);
    	
        return "redirect:/insttn/pltad";
    }
}
