package com.learn.main.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.usr.service.UsrService;
import com.learn.bbs.usr.vo.UsrEditMyinformationVO;
import com.learn.bbs.usr.vo.UsrVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LearnualMainController {

	@Autowired
	private UsrService usrService;

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
//	public String goManageCourse() {
//		return "insttn/coursemanage";
//	}

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
		
		boolean isUpdated = this.usrService.updateUsrEditMyinformation(usrEditMyinformationVO);

		if (isUpdated) {

			return "common/component/editmyinformation";
		}
		return "/";
	}
}
