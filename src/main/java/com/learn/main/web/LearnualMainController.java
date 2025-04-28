package com.learn.main.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.MyInformationRequestVO;
import com.learn.insttn.service.InsttnService;
import com.learn.insttn.vo.InsttnSearchRequestVO;
import com.learn.insttn.vo.InsttnVO;
import com.learn.util.SessionUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LearnualMainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LearnualMainController.class);
	
	@Autowired
	private InsttnService insttnService; 

	@GetMapping("/learnual")
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

	//@GetMapping("/dashboard/usr")
	@GetMapping("/usr/{usrDashBoardInsttnId}/dashboard") // usreditInsttnId = usr 가 가지고 있는 기관(학원 id)
	public String goUsrDashboard(HttpSession session, Model model, @PathVariable String usrDashBoardInsttnId) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
		
		MyInformationRequestVO myInformationRequestVO = new MyInformationRequestVO();
		
		// 사용자가 로그인 중이라면
		if (usrVO == null && pltadmVO == null && instrVO == null) {
			// 세션에 사용자가 없으면 로그인 페이지로 리다이렉트
			return "redirect:/login";
		} 
		// 강사나 플랫폼 관리자가 들어갈 경우.
		else if (pltadmVO != null || instrVO != null) {
			return "redirect:/learnual";
		}
		
		if(usrVO != null ) {
			myInformationRequestVO = SessionUtil.myInformationUtil(usrVO); 
			if(usrVO.getInsttnId().equals(usrDashBoardInsttnId)) {
				model.addAttribute("inputEdit", myInformationRequestVO); // JSP에서 사용할 이름으로 모델 추가
				return "dashboard/usr/dashboardusr";
			}
		} 
		
		return "redirect:/learnual";
	}

	@GetMapping("/eduad/{eduadDashBoardInsttnId}/dashboard") // eduadDashBoardInsttnId = 강사 가 가지고 있는 기관(학원 id)
	public String goEduadDashboard(HttpSession session, Model model, @PathVariable String eduadDashBoardInsttnId) {
		
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
		
		MyInformationRequestVO myInformationRequestVO = new MyInformationRequestVO();
		
		// 강사가 로그인 중이라면
		if (usrVO == null && pltadmVO == null && instrVO == null) {
			// 세션에 강사가 없으면 로그인 페이지로 리다이렉트
			return "redirect:/login";
		} 
		// 사용자나 플랫폼 관리자가 들어갈 경우.
		else if (usrVO != null || pltadmVO != null) {
			return "redirect:/learnual";
		}
		
		if(instrVO != null ) {
			myInformationRequestVO = SessionUtil.myInformationUtil(instrVO); 
			
			if(instrVO.getInsttnId().equals(eduadDashBoardInsttnId)) {
			model.addAttribute("inputEdit", myInformationRequestVO); // JSP에서 사용할 이름으로 모델 추가
			model.addAttribute("insttnId", instrVO.getInsttnId());

			return "dashboard/eduad/dashboardeduad";
			}
		} 
		
		return "redirect:/learnual";
	}
	
	@GetMapping("/eduad/{eduadDashBoardInsttnId}/dashboard/courselist")
	public String showInstrCoursList(HttpSession session, Model model, @PathVariable String eduadDashBoardInsttnId) {
		
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
		
		List<CrsInfAvailableReadResponseVO> courseList = this.insttnService.selectCoursesForInstr(instrVO.getInstrId(), eduadDashBoardInsttnId);
		
		// 강사가 로그인 중이라면
		if (usrVO == null && pltadmVO == null && instrVO == null) {
			// 세션에 강사가 없으면 로그인 페이지로 리다이렉트
			return "redirect:/login";
		} 
		// 사용자나 플랫폼 관리자가 들어갈 경우.
		else if (usrVO != null || pltadmVO != null) {
			return "redirect:/learnual";
		}
		
		if(instrVO != null ) {
			if(instrVO.getInsttnId().equals(eduadDashBoardInsttnId)) {
			model.addAttribute("courseList", courseList); // JSP에서 사용할 이름으로 모델 추가

			return "dashboard/eduad/crs/dashboardeduadmycourselist";
			}
		} 
		
		return "redirect:/learnual";
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
		
		if(usrVO != null ) {
			model.addAttribute("inputEdit", myInformationRequestVO); // JSP에서 사용할 이름으로 모델 추가

			return "common/component/viewmyinfo";
		} 
		
		else if (instrVO != null ) {
			myInformationRequestVO = SessionUtil.myInformationUtil(instrVO);
			model.addAttribute("inputEdit", myInformationRequestVO); // JSP에서 사용할 이름으로 모델 추가

			return "common/component/viewmyinfo";
		}
		else  {
			myInformationRequestVO = SessionUtil.myInformationUtil(pltadmVO); 

			model.addAttribute("inputEdit", myInformationRequestVO); // JSP에서 사용할 이름으로 모델 추가

			return "common/component/viewmyinfo";
		}
		
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
		
		//myInformationRequestVO = SessionUtil.myInformationUtil(usrVO, pltadmVO, instrVO);
		
		if(usrVO != null ) {
			myInformationRequestVO = SessionUtil.myInformationUtil(usrVO);
			model.addAttribute("inputEdit", myInformationRequestVO); 
			return "common/component/editmyinformation";
		} 
		
		else if (instrVO != null ) {
			myInformationRequestVO = SessionUtil.myInformationUtil(instrVO);
			model.addAttribute("inputEdit", myInformationRequestVO); 
			return "common/component/editmyinformation";
		}
		else  {
			myInformationRequestVO = SessionUtil.myInformationUtil(pltadmVO);

			model.addAttribute("inputEdit", myInformationRequestVO); 
			
			return "common/component/editmyinformation";
		}
		
	}
	
	/**
	 * 사용자,강사, 플랫폼 관리자 공통으로 사용 controller end -lsh
	 */
	
	// 로그인 공통 Controller end 
}
