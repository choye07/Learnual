package com.learn.bbs.pltad.ntc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.pltad.ntc.service.InsttnNtcService;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcListVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcUpdateRequestVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcWriteRequestVO;

import jakarta.validation.Valid;


/**
 * @author 최예진
 * 러뉴얼 공지사항 
 */
@Controller
public class InsttnNtcController {

    @Autowired
    private InsttnNtcService insttnNtcService;
    
    // 메인 공지사항 list 보기
    @GetMapping("/insttnntc/list") // 경로 바뀔 수 있음
    public String viewInsttnNoticeList(Model model) {
    	InsttnNtcListVO insttnNtcListVO = this.insttnNtcService.getAllInsttnNotice();
    	model.addAttribute("insttnNtcList", insttnNtcListVO);
    	
    	return "/bbs/pltad/ntc/insttnntcboardlist";
    }
   
    // 메인 공지사항 작성하기(관리자만 가능)
	@GetMapping("/insttnntc/write")
	public String viewInsttnNoticeWritePage() {
		return "/bbs/pltad/ntc/insttnntcboardwrite";
	}

	// 메인 공지사항 작성 받아오기
	@PostMapping("/insttnntc/write") // 경로 바뀔 수 있음
	public String doInsttnNoticeWrite(
			@Valid @ModelAttribute InsttnNtcWriteRequestVO insttnNtcWriteRequestVO,
			BindingResult bindingResult,
			Model model
			) {
		
	    // 체크박스 상태에 따라 ntcPinnedYn 값 설정
	    if (insttnNtcWriteRequestVO.getNtcPinnedYn() == null) {
	    	insttnNtcWriteRequestVO.setNtcPinnedYn("N"); // 체크되지 않은 경우
	    } else {
	    	insttnNtcWriteRequestVO.setNtcPinnedYn("Y"); // 체크된 경우
	    }
		
	    // 파라미터 유효성 검사 체크
		if (bindingResult.hasErrors()) {
			model.addAttribute("usrWriteInsttnNtc", insttnNtcWriteRequestVO);
			return "/bbs/pltad/ntc/insttnntcboardwrite";
		}
		
		boolean isCreated = this.insttnNtcService.createNewInsttnNotice(insttnNtcWriteRequestVO);
		if(isCreated) {
			return "redirect:/insttnntc/list";
		}
		
		return "/insttnntc/write";
	}
	
	// 메인 공지사항 하나 보기
	@GetMapping("/insttnntc/view/{id}") // 경로 바뀔 수 있음
	public String viewOneInsttnNotice(@PathVariable String id, Model model) {
		InsttnNtcVO insttnNtcVO = this.insttnNtcService.getOneInsttnNoticeBy(id);
		model.addAttribute("selectedInsttnNotice", insttnNtcVO);
		return "/bbs/pltad/ntc/insttnntcboardview";
	}

	// 메인 공지사항 하나 삭제하기
	@GetMapping("insttnntc/delete/{id}") // 경로 바뀔 수 있음
	public String deleteOneInsttnNotice(@PathVariable String id) {
		boolean isSuccess = this.insttnNtcService.deleteOneInsttnNoticeBy(id);
		
		if(isSuccess) {
			return "redirect:/insttnntc/list";	
		}
		return "redirect:/insttnntc/list";
	}

	// 메인 공지사항 하나 수정하기 (get -> page)
	@GetMapping("/insttnntc/modify/{id}")
	public String viewInsttnNoticeModifyPage(@PathVariable String id, Model model) {
		InsttnNtcVO insttnNtcVO = this.insttnNtcService.getOneInsttnNoticeBy(id);
		// 수정하기 위해 해당 id의 insttnNotice를 가져온 후 모델로 뷰에 전송
		model.addAttribute("toModifyInsttnNtcVO", insttnNtcVO);
		// 이동 & 전송할 뷰 지정
		return "/bbs/pltad/ntc/insttnntcboardedit";
	}

	// 메인 공지사항 하나 수정하기 (post -> do)
	@PostMapping("/insttnntc/modify/{id}")
	public String modifyOneInsttnNotice(
			@Valid @ModelAttribute InsttnNtcUpdateRequestVO insttnNtcUpdateRequestVO,
			@PathVariable String id, 
			BindingResult bindingResult,
			Model model) {
		// 수정 폼 파라미터 유효성 검사
		if(bindingResult.hasErrors()) {
			model.addAttribute("usrModifyInsttnNtc", insttnNtcUpdateRequestVO);
			return "/bbs/pltad/ntc/insttnntcboardedit"; // 수정 뷰에 사용자 작성정보를 보내준다.
		}
		
		// 수정 완료 버튼을 누르면 form 을 전송하므로 VO 필요
		boolean isSuccess = this.insttnNtcService.updateOneInsttnNoticeBy(insttnNtcUpdateRequestVO);
		if(isSuccess) {
			// id를 @PathVariable로 받아오는 것은 redirect를 위함
			return "redirect:/insttnntc/view/" + id;
		}
		return "redirect:/insttnntc/list";
	}
	
}