package com.learn.bbs.crs.crsinf.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.crs.apphstr.vo.AppHstrVO;
import com.learn.bbs.crs.crsinf.service.CrsInfService;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.crs.sbj.service.SbjService;
import com.learn.bbs.crs.sbj.vo.SbjVO;

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

    @GetMapping("/insttn/pltad")
    public String showAllCourses(Model model) {
        List<CrsInfPltadReadResponseVO> activeCourses = this.crsInfService.selectAllCourseForPltad();
        List<CrsInfPltadFinishedReadResponseVO> inactiveCourses = this.crsInfService.selectAllFinishedCourseForPltad();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (CrsInfPltadReadResponseVO course : activeCourses) {
            LocalDate deadlineDate = LocalDate.parse(course.getCrsInfDdlnDt().substring(0, 10), formatter);
            course.setDeadlineToday(deadlineDate.isEqual(today));
        }

        model.addAttribute("activeCourses", activeCourses);
        model.addAttribute("inactiveCourses", inactiveCourses);

        return "/insttn/coursemanage";
    }
    
    @GetMapping("/insttn")
    public String showAvailableCourses(Model model) {
        List<CrsInfAvailableReadResponseVO> availableCourses = this.crsInfService.selectAvailableCourses();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (CrsInfAvailableReadResponseVO course : availableCourses) {
            LocalDate availableDate = LocalDate.parse(course.getCrsInfDdlnDt().substring(0, 10), formatter);
            course.setAvailableToday(availableDate.isEqual(today));
        }

        model.addAttribute("availableCourses", availableCourses);

        return "/insttn/maininsttn";
    }
    
    @GetMapping("/insttn/usr")
    public String showAvailableCoursesForUser(Model model) {
        List<CrsInfAvailableReadResponseVO> availableCourses = this.crsInfService.selectAvailableCourses();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (CrsInfAvailableReadResponseVO course : availableCourses) {
            LocalDate availableDate = LocalDate.parse(course.getCrsInfDdlnDt().substring(0, 10), formatter);
            course.setAvailableToday(availableDate.isEqual(today));
        }

        model.addAttribute("availableCourses", availableCourses);

        return "/insttn/courseregist";
    }
    
    @GetMapping("/insttn/usr/detail/{crsInfId}")
    public String showAllAvailableForUser(@PathVariable String crsInfId,
    									  Model model) {
    	String usrId = "USR_20250419_000002"; // 로그인된 유저의 ID <- 여기서 session 사용하시면 될듯!
    	
        boolean showCancelButton = crsInfService.isAppliedOrCancelled(crsInfId, usrId);
        
        model.addAttribute("showCancelButton", showCancelButton);
        
    	model.addAttribute("courseDetail", this.crsInfService.selectCourseDetail(crsInfId));
    	
    	return "/insttn/coursedetail";
    }
    
    @GetMapping("/insttn/pltad/detail/{crsInfId}")
    public String showAllAvailableForPltAd(@PathVariable String crsInfId,
    									   Model model) {
    	model.addAttribute("courseDetail", this.crsInfService.selectCourseDetail(crsInfId));
    	
		return "/insttn/coursedetail";
}
    
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
    
    @GetMapping("/insttn/pltad/modify/{crsInfId}")
    public String goModifyCourse(@PathVariable String crsInfId, Model model) {
        CrsInfModifyRequestVO courseInfo = this.crsInfService.selectAllInfoFromOneCourse(crsInfId);
        List<SbjVO> subjectList = sbjService.selectAllSubjects();

        model.addAttribute("userRegistInfo", courseInfo);
        model.addAttribute("selectedSubjects", courseInfo.getSubjects());
        model.addAttribute("subjectList", subjectList);

        return "/insttn/coursemodify";
    }
    
    @PostMapping("/insttn/pltad/modify/{crsInfId}")
    public String doModifyCourse(@Valid CrsInfModifyRequestVO crsInfModifyRequestVO,
								 BindingResult bindingResult,
								 Model model) {
		List<SbjVO> subjectList = sbjService.selectAllSubjects();
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
			
			return "/insttn/coursemodify";
		}
		
		String newName = crsInfModifyRequestVO.getCrsInfNm();
		String currentName = crsInfService.selectCourseName(crsInfModifyRequestVO.getCrsInfId());

		// 동일한 강좌 이름이 존재하나, 그것이 현재의 강좌 이름이 아닐 경우 중복
		if (crsInfService.countCourseName(newName) && !newName.equals(currentName)) {
		    model.addAttribute("duplicateTitleError", "이미 등록된 강좌 이름입니다. 다른 이름을 입력해주세요.");
		    model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		    model.addAttribute("subjectList", subjectList);
		    model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

		    return "/insttn/coursemodify";
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		
		LocalDateTime crsInfStDt = LocalDateTime.parse(crsInfModifyRequestVO.getCrsInfStDt(), formatter);
		LocalDateTime crsInfEndDt = LocalDateTime.parse(crsInfModifyRequestVO.getCrsInfEndDt(), formatter);
		LocalDateTime crsInfAppDt = LocalDateTime.parse(crsInfModifyRequestVO.getCrsInfAppDt(), formatter);
		LocalDateTime crsInfDdlnDt = LocalDateTime.parse(crsInfModifyRequestVO.getCrsInfDdlnDt(), formatter);
		
		LocalDateTime today = LocalDateTime.now();
		
		if(crsInfStDt.isBefore(today)) {
		model.addAttribute("crsInfStDtThanToday", "강좌 시작일은 오늘 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/insttn/coursemodify";
		}
		
		if(crsInfEndDt.isBefore(today)) {
		model.addAttribute("crsInfEndDtThanToday", "강좌 종료일은 오늘 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/insttn/coursemodify";
		}
		
		if(crsInfAppDt.isBefore(today)) {
		model.addAttribute("crsInfAppDtThanToday", "강좌 신청일은 오늘 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/insttn/coursemodify";
		}
		
		if(crsInfDdlnDt.isBefore(today)) {
		model.addAttribute("crsInfDdlnDtThanToday", "강좌 마감일은 오늘 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/insttn/coursemodify";
		}
		
		if(crsInfEndDt.isBefore(crsInfStDt)) {
		if(crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 시작/신청 시작일이 둘다 느림
		model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
		model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/insttn/coursemodify";
		}
		// 강좌 시작일만 느림
		model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/insttn/coursemodify";
		} else {
		if(crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 신청일만 느림
		model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/insttn/coursemodify";
		}
		}
		
		if(crsInfDdlnDt.isAfter(crsInfStDt)) {
		model.addAttribute("appDtAfterThanStDt", "강좌 시작일은 신청 마감일 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/insttn/coursemodify";
		}
		
		DateTimeFormatter resetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		crsInfModifyRequestVO.setCrsInfStDt(crsInfStDt.format(resetFormatter));
		crsInfModifyRequestVO.setCrsInfEndDt(crsInfEndDt.format(resetFormatter));
		crsInfModifyRequestVO.setCrsInfAppDt(crsInfAppDt.format(resetFormatter)); 
		crsInfModifyRequestVO.setCrsInfDdlnDt(crsInfDdlnDt.format(resetFormatter));
		
		this.crsInfService.updateOneCourse(crsInfModifyRequestVO);
		
		return "redirect:/insttn/pltad";
	}
    
    @PostMapping("/insttn/pltad/delete/{crsInfId}")
    public String doDeleteCourse(@PathVariable String crsInfId) {
    	this.crsInfService.deleteOneCourse(crsInfId);
    	
    	return "redirect:/insttn/pltad";
    }
}
