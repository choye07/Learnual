package com.learn.main.ntc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.usr.vo.UsrVO;
import com.learn.main.ntc.service.MainNtcService;
import com.learn.main.ntc.vo.NtcListVO;
import com.learn.main.ntc.vo.NtcUpdateRequestVO;
import com.learn.main.ntc.vo.NtcVO;
import com.learn.main.ntc.vo.NtcWriteRequestVO;
import com.learn.main.sprad.vo.SpradmVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


/**
 * @author 최예진
 * 러뉴얼 공지사항 
 */
@Controller
public class MainNtcController {

    @Autowired
    private MainNtcService mainNtcService;
    
    // 메인 공지사항 list 보기
    // 0504 추가 내용
    // 플랫폼관리자만 '작성'버튼 실행할 수 있다.
    @GetMapping("/learnual/ntc/list") // 경로 바뀔 수 있음
    public String viewMainNoticeList(Model model) {
    	NtcListVO ntcListVO = this.mainNtcService.getAllMainNotice();
    	model.addAttribute("mainNtcList", ntcListVO);
    	
    	return "/main/ntc/mainntcboardlist";
    }
    
    // 메인 공지사항 작성하기(관리자만 가능)
	@GetMapping("/learnual/ntc/write")
	public String viewMainNoticeWritePage(Model model, HttpSession session) {
		// write view는 슈퍼관리자만 접근 가능, 다른 권한자의 경우는 고려하지 않는다.
		SpradmVO spradmVO = (SpradmVO) session.getAttribute("__LOGIN_SPRAD__");
		model.addAttribute("spradmVO", spradmVO);
		return "/main/ntc/mainntcboardwrite";
	}

	// 메인 공지사항 작성 받아오기
	@PostMapping("/learnual/ntc/write") // 경로 바뀔 수 있음
	public String doMainNoticeWrite(
			@Valid @ModelAttribute NtcWriteRequestVO ntcWriteRequestVO,
			BindingResult bindingResult,
			Model model,
			HttpSession session
			) {
		
	    // 체크박스 상태에 따라 ntcPinnedYn 값 설정
	    if (ntcWriteRequestVO.getNtcPinnedYn() == null) {
	        ntcWriteRequestVO.setNtcPinnedYn("N"); // 체크되지 않은 경우
	    } else {
	        ntcWriteRequestVO.setNtcPinnedYn("Y"); // 체크된 경우
	    }
		
	    // 파라미터 유효성 검사 체크
		if (bindingResult.hasErrors()) {
			model.addAttribute("usrWriteNtc", ntcWriteRequestVO);
			return "/main/ntc/mainntcboardwrite";
		}
		
		SpradmVO spradmVO = (SpradmVO) session.getAttribute("__LOGIN_SPRAD__");
		ntcWriteRequestVO.setNtcWrtrId(spradmVO.getSpradmId());
		
		boolean isCreated = this.mainNtcService.createNewMainNotice(ntcWriteRequestVO);
		if(isCreated) {
			return "redirect:/learnual/ntc/list";
		}
		
		return "/learnual/ntc/write";
	}
	
	// 메인 공지사항 하나 보기
	@GetMapping("/learnual/ntc/view/{id}") // 경로 바뀔 수 있음
	public String viewOneMainNotice(@PathVariable String id, Model model) {
		NtcVO ntcVO = this.mainNtcService.getOneMainNotcie(id);
		model.addAttribute("selectedNotice", ntcVO);
		return "/main/ntc/mainntcboardview";
	}
	
	// 메인 공지사항 하나 삭제하기
	@GetMapping("/learnual/ntc/delete/{id}") // 경로 바뀔 수 있음
	public String deleteOneMainNotice(@PathVariable String id) {
		boolean isSuccess = this.mainNtcService.deleteOneMainNoticeBy(id);
		
		if(isSuccess) {
			return "redirect:/learnual/ntc/list";	
		}
		return "redirect:/learnual/ntc/list";
	}
	
	// 메인 공지사항 하나 수정하기 (get -> page)
	@GetMapping("/learnual/ntc/modify/{id}")
	public String viewMainNoticeModifyPage(@PathVariable String id, Model model) {
		// 수정의 getMapping에서는 수정하고자 하는 VO를 가져오기만 한다.
		// 실제 수정 로직은 postMapping에서 이루어진다.
		// 수정하기 위해서 id에 해당하는(수정하고자 하는) mainNotice 들고오기
		NtcVO ntcVO = this.mainNtcService.getOneMainNotcie(id);
		// 수정뷰페이지에 가져온 mainNotice 보내기
		model.addAttribute("toModifyNtcVO", ntcVO);
		// 이동할 뷰 지정
		return "/main/ntc/mainntcboardedit";
	}
	
	// 메인 공지사항 하나 수정하기 (post -> do)
	// p -> r -> g 유의
	@PostMapping("/learnual/ntc/modify/{id}")
	public String modifyOneMainNotice(
			@Valid @ModelAttribute NtcUpdateRequestVO ntcUpdateRequestVO,
			@PathVariable String id, 
			BindingResult bindingResult,
			Model model) {
		// 수정 폼 파라미터 유효성 검사
		if(bindingResult.hasErrors()) {
			model.addAttribute("usrModifyNtc", ntcUpdateRequestVO);
			return "/main/ntc/mainntcboardedit"; // 수정 뷰에 사용자 작성정보를 보내준다.
		}
		
		// 수정 완료 버튼을 누르면 form 을 전송하므로 VO 필요
		boolean isSuccess = this.mainNtcService.updateOneMainNoticeBy(ntcUpdateRequestVO);
		if(isSuccess) {
			// id를 @PathVariable로 받아오는 것은 redirect를 위함
			return "redirect:/learnual/ntc/view/" + id;
		}
		return "redirect:/learnual/ntc/list";
	}
	
}