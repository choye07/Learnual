package com.learn.bbs.pltad.instr.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.pltad.instr.dao.InstrDao;
import com.learn.bbs.pltad.instr.service.InstrService;
import com.learn.bbs.pltad.instr.vo.InstrLoginRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.LoginRequestVO;
import com.learn.common.vo.MyInformationRequestVO;
import com.learn.exceptions.MyInformationUpdateException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


/**
 * @TableName INSTR
 * @TableComment null
 * 강사
 */
@Controller
public class InstrController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InstrController.class);

    @Autowired
    private InstrService instrService;
    
    @Autowired
    private InstrDao instrDao;
    
    @PostMapping("pltad/instrmanage/regist")
    public String doInstrRegist(@Valid 
			@ModelAttribute  InstrRegistRequestVO instrRegistRequestVO,
			BindingResult bindingResult,
			Model model) {
    	
    	instrRegistRequestVO.setLgnId("admin");
    	
		boolean isCreated = this.instrService.createInstr(instrRegistRequestVO);
		
		if (isCreated) {
			return "/success";
		}

    	return"/fail";
    }
    
    @PostMapping("/instr/login")
	public String doLogin(@Valid @ModelAttribute LoginRequestVO loginRequestVO, BindingResult bindingResult,
			@RequestParam(required = false, defaultValue = "/learnual") String nextUrl, Model model, HttpSession session,
			HttpServletRequest request) {

		// 사용자의 IP 를 가져올 때 HttpServeltRequest 가 사용.
		String userIp = request.getRemoteAddr();
		LOGGER.debug(userIp);
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginInput", loginRequestVO);
			return "/main/mainlogin";
		}

		InstrLoginRequestVO instrLoginRequestVO = new InstrLoginRequestVO();
		instrLoginRequestVO.setInstrLgnId(loginRequestVO.getLgnId());
		instrLoginRequestVO.setInstrLgnPw(loginRequestVO.getLgnPw());

		InstrVO instrVO = this.instrService.doLogin(instrLoginRequestVO);
		// 사이트에 접속했을 때 발급 받은 세션은 폐기(로그아웃)시킨다.
		session.invalidate();
		// 새로운 세션을 발급받는다.
		session = request.getSession(true);
		// 서버가 Session 에 회원 정보를 기록(기억) 한다.
		// 해당 사용자의 고유한 세션의 아이디를 브라우저에게 "Cookie" 로 보내준다.
		session.setAttribute("__LOGIN_INSTR__", instrVO);

		return "redirect:" + nextUrl;
	}
    
    @GetMapping("/instr/logout") 
    public String doLogout(HttpSession session) { 
    	// 회원의 정보를 Session 에서 가져온다. (__LOGIN_USER__) => UsrVO
    	InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
    	 
    	this.instrService.doLogout(instrVO.getInstrLgnId());
    	
    	// 세션 폐기 (로그아웃)
    	session.invalidate(); 
    	return "redirect:/learnual";
    }
    
    @PostMapping("/instr/editmyinformation")
    public String doEditMyInformation(@Valid @ModelAttribute MyInformationRequestVO myInformationRequestVO,
                                       BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("inputEdit", myInformationRequestVO);
            return "common/component/editmyinformation";
        }

        InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
        // 사용자, 관리자, 강사의 공통화 유효처리를 위한 객체로 어떤 역할인지 모르기 때문에 세션값을 다시 담는다 .
        myInformationRequestVO.setMyiLgnId(instrVO.getInstrLgnId());

        try {
            boolean isUpdated = instrService.updateUsrEditMyinformation(myInformationRequestVO);

            if (isUpdated) {
            	InstrVO updatedInstrVO = instrDao.selectOneUsrBy(myInformationRequestVO.getMyiLgnId());
                session.setAttribute("__LOGIN_INSTR__", updatedInstrVO);
                return "redirect:/eduad/"+instrVO.getInsttnId()+"/dashboard";
            }
        } catch (MyInformationUpdateException mue) {
            model.addAttribute("errorMessage", mue.getMessage());
            model.addAttribute("inputEdit", myInformationRequestVO);
            return "common/component/editmyinformation";
        }

        return "redirect:/learnual";
    }
    
 	// 강사가 가르칠(가르치고 있는) 강좌들을 보여준다 
 	@GetMapping("instr/{insttnId}")
 	public String showAvailableCoursesForInstr(Model model, HttpSession session, @PathVariable String insttnId) {
 		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");

 		List<CrsInfAvailableReadResponseVO> instrCourses = this.instrService
 				.selectCoursesForInstr(instrVO.getInstrId(), instrVO.getInsttnId());

 		if(!insttnId.equals(instrVO.getInsttnId())) {
 			return "redirect:/instr/" + instrVO.getInsttnId();
 		}
 		
 		model.addAttribute("isInstr", true);
 		model.addAttribute("instrCourses", instrCourses);

 		return "/bbs/crs/courseregist";
 	}
 	
 	@GetMapping("instr/{insttnId}/{crsInfId}/course")
 	public String showInstrCourse(@PathVariable String insttnId,
					 			  @PathVariable String crsInfId,
					 			  Model model,
					 			  HttpSession session) {
		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
		
		if(!insttnId.equals(instrVO.getInsttnId())) {
		return "redirect:/instr/" + instrVO.getInsttnId() + "/" + crsInfId + "/course";
		}
		
		model.addAttribute("insttnId", insttnId);
		model.addAttribute("courseDetail", this.instrService.selectCourseDetail(crsInfId, instrVO.getInsttnId()));
		
		return "bbs/crs/maincourse";
	}
}