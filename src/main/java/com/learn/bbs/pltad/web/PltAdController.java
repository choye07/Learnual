package com.learn.bbs.pltad.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.pltad.dao.PltAdDao;
import com.learn.bbs.pltad.service.PltAdService;
import com.learn.bbs.pltad.vo.PltadRegistRequestVO;
import com.learn.bbs.pltad.vo.PltadmLoginRequestVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.common.vo.LoginRequestVO;
import com.learn.common.vo.MyInformationRequestVO;
import com.learn.exceptions.MyInformationUpdateException;
import com.learn.main.sprad.vo.SpradmVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PltAdController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PltAdController.class);

	
    @Autowired
    private PltAdService pltAdService;
    
    @Autowired
    private PltAdDao pltAdDao;
    
    @PostMapping("/spr/pltadmanage/regist")
    public String doPltadRegist(@Valid 
								@ModelAttribute 
								PltadRegistRequestVO pltadRegistRequestVO,
								BindingResult bindingResult,
								Model model, HttpSession session) {
	    	SpradmVO spradmVO = (SpradmVO) session.getAttribute("__LOGIN_SPRAD__");
    	pltadRegistRequestVO.setLgnId(spradmVO.getSpradmLgnId());
    	
		boolean isCreated = this.pltAdService.createNewPltad(pltadRegistRequestVO);
		if (isCreated) {
			return "redirect:/sprad/learnual/pltadmanage";
		}

    	
		return "/fail";
    	
    }

	@PostMapping("/plta/login")
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

		PltadmLoginRequestVO pltadmLoginRequestVO = new PltadmLoginRequestVO();
		pltadmLoginRequestVO.setPltadmLgnId(loginRequestVO.getLgnId());
		pltadmLoginRequestVO.setPltadmLgnPw(loginRequestVO.getLgnPw());

		PltadmVO pltadmVO = this.pltAdService.doLogin(pltadmLoginRequestVO);
		// 사이트에 접속했을 때 발급 받은 세션은 폐기(로그아웃)시킨다.
		session.invalidate();
		// 새로운 세션을 발급받는다.
		session = request.getSession(true);
		// 서버가 Session 에 회원 정보를 기록(기억) 한다.
		// 해당 사용자의 고유한 세션의 아이디를 브라우저에게 "Cookie" 로 보내준다.
		session.setAttribute("__LOGIN_PLTADM__", pltadmVO);

		return "redirect:" + nextUrl;
	}

    @GetMapping("/plta/logout") 
    public String doLogout(HttpSession session) { 
    	// 회원의 정보를 Session 에서 가져온다. (__LOGIN_USER__) => UsrVO
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	 
    	this.pltAdService.doLogout(pltadmVO.getPltadmLgnId());
    	
    	// 세션 폐기 (로그아웃)
    	session.invalidate(); 
    	return "redirect:/learnual";
    }
    
    
    @PostMapping("/pltad/editmyinformation")
    public String doEditMyInformation(@Valid @ModelAttribute MyInformationRequestVO myInformationRequestVO,
                                       BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("inputEdit", myInformationRequestVO);
            return "common/component/editmyinformation";
        }

        PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
        // 사용자, 관리자, 강사의 공통화 유효처리를 위한 객체로 어떤 역할인지 모르기 때문에 세션값을 다시 담는다 .
        myInformationRequestVO.setMyiLgnId(pltadmVO.getPltadmLgnId());

        try {
            boolean isUpdated = pltAdService.updateUsrEditMyinformation(myInformationRequestVO);

            if (isUpdated) {
                PltadmVO updatedPltadmVO = pltAdDao.selectOneUsrBy(myInformationRequestVO.getMyiLgnId());
                session.setAttribute("__LOGIN_PLTADM__", updatedPltadmVO);
                return "redirect:/viewmyinfo";
            }
        } catch (MyInformationUpdateException mue) {
            model.addAttribute("errorMessage", mue.getMessage());
            model.addAttribute("inputEdit", myInformationRequestVO);
            return "common/component/editmyinformation";
        }

        return "redirect:/learnual";
    }

}