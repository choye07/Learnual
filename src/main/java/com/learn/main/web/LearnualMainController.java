package com.learn.main.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.bbs.pltad.instr.service.InstrService;
import com.learn.bbs.pltad.instr.vo.InstrLoginRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.pltad.service.PltAdService;
import com.learn.bbs.pltad.vo.PltadmLoginRequestVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.service.UsrService;
import com.learn.bbs.usr.vo.UsrEditMyinformationVO;
import com.learn.bbs.usr.vo.UsrLoginRequestVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.AjaxResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LearnualMainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LearnualMainController.class);
	
	
	@Autowired
	private UsrService usrService;
	
	@Autowired
	private PltAdService pltAdService;
	
	@Autowired
	private InstrService instrService;

	@GetMapping("/")
	public String goMain() {
		return "main/mainhome";
	}

	@GetMapping("/login")
	public String goMainLogin() {
		return "main/mainlogin";
	}

	@GetMapping("/regist/agreement")
	public String goMainRegistAgreement() {
		return "main/mainagreement";
	}

	@GetMapping("/usr/regist")
	public String goMainRegist() {
		return "main/mainregist";
	}

	// 임시 대시보드 매핑
	@GetMapping("/dashboard/usr")
	public String goUsrDashboard() {
		return "dashboard/dashboardusr";
	}

	@GetMapping("/dashboard/eduad")
	public String goEduadDashboard() {
		return "dashboard/dashboardeduad";
	}

//	@GetMapping("/insttn")
//	public String goMainInsttn() {
//		return "insttn/maininsttn";
//	}

	// 학생의 강좌 신청 페이지
//	@GetMapping("/insttn/usr")
//	public String goRegistCourse() {
//		return "insttn/courseregist";
//	}
	
	@GetMapping("/insttn/usr/detail")
	public String goCourseDetail() {
		return "insttn/coursedetail";
	}

//	@GetMapping("/insttn/pltad")
//	public String goManageCourse() {ß
//		return "insttn/coursemanage";
//	}


	// 로그인 공통 Controller start 
	/**
	 * 사용자,강사, 플랫폼 관리자 공통으로 사용 controller start -lsh
	 */
	
//    @ResponseBody 
//    @GetMapping("/available")
//    public AjaxResponse checkAvailableEmail(@RequestParam String usrMl) {
//    	
//    	boolean duplicated = this.usrService.checkDuplicateEmail(usrMl);
//    	
//    	boolean pltAdDuplicated = this.pltAdService.checkDuplicateEmail(usrMl);
//    	
//    	boolean instrDuplicated = this.instrService.checkDuplicateEmail(usrMl);
//    	
//    	Map<String, Object> resultMap = new HashMap<>();
//    	resultMap.put("available", !duplicated);
//    	
//    	return new AjaxResponse(resultMap);
//    }
	
	@GetMapping("/viewmyinfo")
	public String goViewMyInformation(HttpSession session, Model model) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		// 사용자가 로그인 중이라면
		if (usrVO == null) {
			// 세션에 사용자가 없으면 로그인 페이지로 리다이렉트
			return "redirect:/usr/login";
		}

		model.addAttribute("userInputRegist", usrVO); // JSP에서 사용할 이름으로 모델 추가

		// TODO 강사 & 플랫폼관리자 추가하기

		return "common/component/viewmyinfo";
	}
	
	@GetMapping("/editmyinformation")
	public String goEditMyInformation(HttpSession session, Model model) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		// 사용자가 로그인 중이라면
		if (usrVO == null) {
			// 세션에 사용자가 없으면 로그인 페이지로 리다이렉트
			return "redirect:/usr/login";
		}

		model.addAttribute("userInputRegist", usrVO); // JSP에서 사용할 이름으로 모델 추가

		// TODO 강사 & 플랫폼관리자 추가하기

		return "common/component/editmyinformation";
	}

	@PostMapping("/editmyinformation")
	public String doEditMyInformation(@Valid @ModelAttribute UsrEditMyinformationVO usrEditMyinformationVO,
			BindingResult bindingResult, Model model, // jsp 로 유효성 검사 에러를 보내기 위해 작성.
			HttpSession session) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		usrEditMyinformationVO.setUsrMl(usrVO.getUsrMl());
		
		 if (bindingResult.hasErrors()) {
		        model.addAttribute("userInputRegist", usrVO);
		        return "common/component/viewmyinfo"; // 검증 실패 시 원래 페이지로
		    }
		
		boolean isUpdated = this.usrService.updateUsrEditMyinformation(usrEditMyinformationVO);

		if (isUpdated) {

			return "redirect:/editmyinformation";
		}
		return "redirect:/";
	}
	
	/**
	 * 사용자,강사, 플랫폼 관리자 공통으로 사용 controller end -lsh
	 */
	
	// 로그인 공통 Controller end 
}
