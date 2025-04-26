package com.learn.main.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.learn.Util.SessionUtil;
import com.learn.bbs.pltad.instr.service.InstrService;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.pltad.service.PltAdService;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.service.UsrService;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.MyInformationRequestVO;
import com.learn.insttn.service.InsttnService;
import com.learn.insttn.vo.InsttnListVO;
import com.learn.insttn.vo.InsttnSearchRequestVO;
import com.learn.insttn.vo.InsttnVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LearnualMainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LearnualMainController.class);
	
	
	@Autowired
	private UsrService usrService;
	
	@Autowired
	private PltAdService pltAdService;
	
	@Autowired
	private InstrService instrService;
	
	@Autowired
	private InsttnService insttnService; 

	@GetMapping("/main")
	public String goMain(Model model, InsttnSearchRequestVO insttnSearchRequestVO) {
			List<InsttnVO> insttnList = this.insttnService.selectAllinsttn(insttnSearchRequestVO);
			model.addAttribute("insttnList", insttnList);
			model.addAttribute("Search",insttnSearchRequestVO);
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
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
		
		MyInformationRequestVO myInformationRequestVO = new MyInformationRequestVO();
		
		// 사용자가 로그인 중이라면
		if (usrVO == null && pltadmVO == null && instrVO == null) {
			// 세션에 사용자가 없으면 로그인 페이지로 리다이렉트
			return "redirect:/login";
		}

		myInformationRequestVO = SessionUtil.myInformationUtil(usrVO, pltadmVO, instrVO);
		
		model.addAttribute("inputEdit", myInformationRequestVO); // JSP에서 사용할 이름으로 모델 추가

		return "common/component/viewmyinfo";
	}
	
	@GetMapping("/editmyinformation")
	public String goEditMyInformation(HttpSession session, Model model, HttpServletRequest request) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
		
		MyInformationRequestVO myInformationRequestVO = new MyInformationRequestVO();
		
		// 사용자가 로그인 중이라면
		if (usrVO == null && pltadmVO == null && instrVO == null) {
			// 세션에 사용자가 없으면 로그인 페이지로 리다이렉트
			return "redirect:/login";
		}
		
		myInformationRequestVO = SessionUtil.myInformationUtil(usrVO, pltadmVO, instrVO);

		model.addAttribute("inputEdit", myInformationRequestVO); 
		
		return "common/component/editmyinformation";
	}
	
	/**
	 * 사용자,강사, 플랫폼 관리자 공통으로 사용 controller end -lsh
	 */
	
	// 로그인 공통 Controller end 
}
