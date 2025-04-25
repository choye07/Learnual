package com.learn.bbs.crs.crsinf.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.crs.crsinf.service.CrsInfService;
import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfCourseListReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;
import com.learn.bbs.crs.sbj.vo.SbjVO;
import com.learn.bbs.pltad.cnfr.vo.CnfrHstrConfirmReadVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.exceptions.AccessDeniedException;
import com.learn.exceptions.CnfrHstrInsertException;

import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/insttn/pltad")
    public String showAllCourses(Model model, HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}
    	
        List<CrsInfPltadReadResponseVO> activeCourses = this.crsInfService.selectAllCourseForPltad();
        List<CrsInfPltadFinishedReadResponseVO> inactiveCourses = this.crsInfService.selectAllFinishedCourseForPltad();
        List<CrsInfAbandonReadResponseVO> abandonCourses = this.crsInfService.selectAbandonCourse();

        model.addAttribute("activeCourses", activeCourses);
        model.addAttribute("inactiveCourses", inactiveCourses);
        model.addAttribute("abandonCourses", abandonCourses);

        return "/bbs/crs/coursemanage";
    }
    

    @GetMapping("/insttn")
    public String showAvailableCourses(Model model, HttpSession session) {
        UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
        PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

        CrsInfCourseListReadResponseVO result = crsInfService.selectAvailableFourCoursesWithStatus(
            usrVO != null ? usrVO.getUsrMl() : null
        );

        model.addAttribute("availableCourses", result.getCourseList());
        model.addAttribute("isRegistered", result.getIsRegistered());

        model.addAttribute("isStudent", usrVO != null);
        model.addAttribute("isAdmin", pltadmVO != null);

        return "insttn/maininsttn";
    }
    
    // 신청 가능한 강좌들을 보여준다
    @GetMapping("/insttn/usr")
    public String showAvailableCoursesForUser(Model model) {
        List<CrsInfAvailableReadResponseVO> availableCourses = this.crsInfService.selectRegisterableCourses();

        model.addAttribute("availableCourses", availableCourses);

        return "/bbs/crs/courseregist";
    }
    
    @GetMapping("/insttn/usr/detail/{crsInfId}")
    public String showAllAvailableForUser(@PathVariable String crsInfId,
    									  Model model,
    									  HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	UsrVO userVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
        
        if (pltadmVO != null) {
            // 플랫폼 관리자일 경우; 신청 버튼 보여줄 필요 없다
            model.addAttribute("isPltadm", true);
        } else if (userVO != null) {
            // 일반 사용자일 경우; 어떤 버튼을 보여줘야 하는가 알려줘야함
            model.addAttribute("isPltadm", false);
            model.addAttribute("isLoginUser", true);
            String usrMl = userVO.getUsrMl();
            
            boolean showCancelButton = crsInfService.isAppliedOrCancelled(crsInfId, usrMl);
            model.addAttribute("showCancelButton", showCancelButton);
        } else {
            // 로그인 안 된 경우
            model.addAttribute("isPltadm", false);
            model.addAttribute("isLoginUser", false);
        }

        model.addAttribute("courseDetail", crsInfService.selectCourseDetail(crsInfId));
        model.addAttribute("instrName", crsInfService.selectOneInstrName(crsInfId));

        return "/bbs/crs/coursedetail";
    }
    
    @GetMapping("/insttn/pltad/detail/{crsInfId}")
    public String showAllAvailableForPltAd(@PathVariable String crsInfId,
    									   Model model,
    									   HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}
    	
        model.addAttribute("isPltadm", true);
    	model.addAttribute("courseDetail", this.crsInfService.selectCourseDetail(crsInfId));
    	model.addAttribute("instrName", this.crsInfService.selectOneInstrName(crsInfId));
    	
		return "/bbs/crs/coursedetail";
}
    @GetMapping("insttn/pltad/create")
    public String showSubjectList(Model model, HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}
    	
        List<SbjVO> subjectList = crsInfService.getSubjectList();
        List<InstrVO> instrList = crsInfService.getInstrList();
        
        model.addAttribute("subjectList", subjectList);
        model.addAttribute("instrList", instrList);
        
        return "bbs/crs/coursecreate";
    }
    
    @PostMapping("/insttn/pltad/create")
    public String registerCourse(@Valid CrsInfRegistRequestVO crsInfRegistRequestVO,
    							 BindingResult bindingResult,
    							 Model model,
    							 HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}

    	List<SbjVO> subjectList = crsInfService.getSubjectList();
        List<InstrVO> instrList = crsInfService.getInstrList();
        
    	if(bindingResult.hasErrors()) {
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("instrList", instrList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/bbs/crs/coursecreate";
    	}
    	
        if (this.crsInfService.countCourseName(crsInfRegistRequestVO.getCrsInfNm())) {
            model.addAttribute("duplicateTitleError", "이미 등록된 강좌 이름입니다. 다른 이름을 입력해주세요.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("instrList", instrList);
            model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
            
            return "/bbs/crs/coursecreate";
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
            model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("instrList", instrList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/bbs/crs/coursecreate";
    	}
    	
    	if(crsInfEndDt.isBefore(today)) {
    		model.addAttribute("crsInfEndDtThanToday", "강좌 종료일은 오늘 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("instrList", instrList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/bbs/crs/coursecreate";
    	}
    	
    	if(crsInfAppDt.isBefore(today)) {
    		model.addAttribute("crsInfAppDtThanToday", "강좌 신청일은 오늘 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("instrList", instrList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/bbs/crs/coursecreate";
    	}
    	
    	if(crsInfDdlnDt.isBefore(today)) {
    		model.addAttribute("crsInfDdlnDtThanToday", "강좌 마감일은 오늘 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("instrList", instrList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/bbs/crs/coursecreate";
    	}
    	
    	if(crsInfEndDt.isBefore(crsInfStDt)) {
        	if(crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 시작/신청 시작일이 둘다 느림
        		model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
        		model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
                model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
                model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
                model.addAttribute("subjectList", subjectList);
                model.addAttribute("instrList", instrList);
        		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
        		
        		return "/bbs/crs/coursecreate";
        	}
        	// 강좌 시작일만 느림
        	model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("instrList", instrList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/bbs/crs/coursecreate";
    	} else {
        	if(crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 신청일만 느림
        		model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
                model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
                model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
                model.addAttribute("subjectList", subjectList);
                model.addAttribute("instrList", instrList);
        		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
        		
        		return "/bbs/crs/coursecreate";
        	}
    	}
    	
    	if(crsInfDdlnDt.isAfter(crsInfStDt)) {
    		model.addAttribute("appDtAfterThanStDt", "강좌 시작일은 신청 마감일 이후여야 합니다.");
            model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
            model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("instrList", instrList);
    		model.addAttribute("userRegistInfo", crsInfRegistRequestVO);
    		
    		return "/bbs/crs/coursecreate";
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
    public String goModifyCourse(@PathVariable String crsInfId, 
    							 Model model,
    							 HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}
    	
        CrsInfModifyRequestVO courseInfo = this.crsInfService.selectAllInfoFromOneCourse(crsInfId);
        
        List<SbjVO> subjectList = this.crsInfService.getSubjectList();
        List<InstrVO> instrList = this.crsInfService.getInstrList();

        model.addAttribute("userRegistInfo", courseInfo);
        model.addAttribute("selectedSubjects", courseInfo.getSubjects());
        model.addAttribute("selectedInstr", courseInfo.getInstrId());
        model.addAttribute("subjectList", subjectList);
        model.addAttribute("instrList", instrList);

        return "/bbs/crs/coursemodify";
    }
    
    @PostMapping("/insttn/pltad/modify/{crsInfId}")
    public String doModifyCourse(@Valid CrsInfModifyRequestVO crsInfModifyRequestVO,
								 BindingResult bindingResult,
								 Model model,
								 HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}
    	
        List<SbjVO> subjectList = this.crsInfService.getSubjectList();
        List<InstrVO> instrList = this.crsInfService.getInstrList();
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
			
			return "/bbs/crs/coursemodify";
		}
		
		String newName = crsInfModifyRequestVO.getCrsInfNm();
		String currentName = crsInfService.selectCourseName(crsInfModifyRequestVO.getCrsInfId());

		// 동일한 강좌 이름이 존재하나, 그것이 현재의 강좌 이름이 아닐 경우 중복
		if (crsInfService.countCourseName(newName) && !newName.equals(currentName)) {
		    model.addAttribute("duplicateTitleError", "이미 등록된 강좌 이름입니다. 다른 이름을 입력해주세요.");
		    model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		    model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
		    model.addAttribute("subjectList", subjectList);
		    model.addAttribute("instrList", instrList);
		    model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

		    return "/bbs/crs/coursemodify";
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
		model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("instrList", instrList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/bbs/crs/coursemodify";
		}
		
		if(crsInfEndDt.isBefore(today)) {
		model.addAttribute("crsInfEndDtThanToday", "강좌 종료일은 오늘 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("instrList", instrList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/bbs/crs/coursemodify";
		}
		
		if(crsInfAppDt.isBefore(today)) {
		model.addAttribute("crsInfAppDtThanToday", "강좌 신청일은 오늘 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("instrList", instrList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/bbs/crs/coursemodify";
		}
		
		if(crsInfDdlnDt.isBefore(today)) {
		model.addAttribute("crsInfDdlnDtThanToday", "강좌 마감일은 오늘 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("instrList", instrList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/bbs/crs/coursemodify";
		}
		
		if(crsInfEndDt.isBefore(crsInfStDt)) {
		if(crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 시작/신청 시작일이 둘다 느림
		model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
		model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("instrList", instrList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/bbs/crs/coursemodify";
		}
		// 강좌 시작일만 느림
		model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("instrList", instrList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/bbs/crs/coursemodify";
		} else {
		if(crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 신청일만 느림
		model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("instrList", instrList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/bbs/crs/coursemodify";
		}
		}
		
		if(crsInfDdlnDt.isAfter(crsInfStDt)) {
		model.addAttribute("appDtAfterThanStDt", "강좌 시작일은 신청 마감일 이후여야 합니다.");
		model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
		model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("instrList", instrList);
		model.addAttribute("userRegistInfo", crsInfModifyRequestVO);
		
		return "/bbs/crs/coursemodify";
		}
		
		DateTimeFormatter resetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		crsInfModifyRequestVO.setCrsInfStDt(crsInfStDt.format(resetFormatter));
		crsInfModifyRequestVO.setCrsInfEndDt(crsInfEndDt.format(resetFormatter));
		crsInfModifyRequestVO.setCrsInfAppDt(crsInfAppDt.format(resetFormatter)); 
		crsInfModifyRequestVO.setCrsInfDdlnDt(crsInfDdlnDt.format(resetFormatter));
		
		this.crsInfService.updateOneCourse(crsInfModifyRequestVO);
		
		return "redirect:/insttn/pltad";
	}
    
    // 삭제
    @PostMapping("/insttn/pltad/delete/{crsInfId}")
    public String doDeleteCourse(@PathVariable String crsInfId, HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}
    	
    	this.crsInfService.deleteOneCourse(crsInfId);
    	
    	return "redirect:/insttn/pltad";
    }
    
    // 마감
    @PostMapping("/insttn/pltad/end/{crsInfId}")
    public String doEndCourse(@PathVariable String crsInfId, HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}
    	
    	this.crsInfService.endOneCourse(crsInfId);
    	
    	try {
            this.crsInfService.insertRegisteredUsers();
        } catch (CnfrHstrInsertException e) {

        }
    	
    	return "redirect:/insttn/pltad";
    }
    
    @GetMapping("/insttn/pltad/confirm/{crsInfId}")
    public String showConfirmedUsers(@PathVariable String crsInfId, 
    								 Model model,
    								 HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}
    	
        List<CnfrHstrConfirmReadVO> users = this.crsInfService.getConfirmedUsers(crsInfId);
        String crsInfNm = this.crsInfService.selectCourseName(crsInfId);
        model.addAttribute("courseName", crsInfNm);
        model.addAttribute("confirmedUsers", users);
        model.addAttribute("CrsPrattRegistRequestVO", new CrsPrattRegistRequestVO());
        
        return "bbs/crs/courseconfirm";
    }
    
    // 확정
    @PostMapping("/insttn/pltad/confirm/{crsInfId}")
    public String doSavingConfirmedUsersToPratt(@PathVariable String crsInfId,
    											@ModelAttribute CrsPrattRegistRequestVO crsPrattRegistRequestVO,
    											HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}
    	
        // 서비스에서 선택된 사용자만 처리하도록 호출
        this.crsInfService.saveConfirmedUsersToPratt(crsPrattRegistRequestVO);
        
        return "redirect:/insttn/pltad";
    }
    
    // 폐강
    @PostMapping("insttn/pltad/abandon/{crsInfId}")
    public String doAbandonCourse(@PathVariable String crsInfId, HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	
    	// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
    	if(pltadmVO == null) {
    		throw new AccessDeniedException();
    	}
    	
    	CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO = new CrsInfAbandonUpdateRequestVO();
    	
    	crsInfAbandonUpdateRequestVO.setLgnId("admin");
    	crsInfAbandonUpdateRequestVO.setCrsInfId(crsInfId);
    	
    	this.crsInfService.abandonOneCourse(crsInfAbandonUpdateRequestVO);
    	
    	return "redirect:/insttn/pltad";
    }
}
