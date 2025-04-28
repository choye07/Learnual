package com.learn.bbs.eduad.crntc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.eduad.crntc.service.CrNtcService;
import com.learn.bbs.eduad.crntc.vo.CrntcListVO;
import com.learn.bbs.eduad.crntc.vo.CrntcUpdateRequestVO;
import com.learn.bbs.eduad.crntc.vo.CrntcVO;
import com.learn.bbs.eduad.crntc.vo.CrntcWriteRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.main.sprad.vo.SpradmVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


/**
 * @author 최예진
 *  강좌 공지사항
 */
@Controller
public class CrNtcController {

    @Autowired
    private CrNtcService crNtcService;
    
    @GetMapping("/usr/{insttnId}/{crsInfId}/ARTC-20240427-000001/list")
    public String viewCourseNoticeList(@PathVariable String insttnId,
    								   @PathVariable String crsInfId,
//    								   @PathVariable String artcId,
    								   Model model,
    								   HttpSession session) {
    	InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
    	SpradmVO spradmVO = (SpradmVO) session.getAttribute("__LOGIN_SPRAD__");
    	
		if (instrVO == null && pltadmVO == null && usrVO == null && spradmVO == null) {
			// 로그인 안되어 있으면
			return "redirect:/login";
		} else if(instrVO != null) {
			model.addAttribute("showButton", true);
		} else {
			model.addAttribute("showButton", false);
		}
    	
    	CrntcListVO crntcListVO = this.crNtcService.getAllCourseNotice();
    	model.addAttribute("crntcList", crntcListVO);
    	
    	model.addAttribute("insttnId", insttnId);
    	model.addAttribute("crsInfId", crsInfId);
    	
    	return "/bbs/crs/ntc/crntcboardlist";
    }
   
    // 강좌 공지사항 작성하기(학습관리자만 가능)
	@GetMapping("/crntc/write")
	public String viewCourseNoticeWritePage() {
		return "/bbs/crs/ntc/crntcboardwrite";
	}

	// 강좌 공지사항 작성 작성하기
	@PostMapping("/crntc/write") // 경로 바뀔 수 있음
	public String doCourseNoticeWrite(
			@Valid @ModelAttribute CrntcWriteRequestVO crntcWriteRequestVO,
			BindingResult bindingResult,
			Model model,  HttpSession session) {
    	InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
    	UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
    	SpradmVO spradmVO = (SpradmVO) session.getAttribute("__LOGIN_SPRAD__");
		
	    // 체크박스 상태에 따라 ntcPinnedYn 값 설정
	    if (crntcWriteRequestVO.getCrntcPinnedYn() == null) {
	    	crntcWriteRequestVO.setCrntcPinnedYn("N"); // 체크되지 않은 경우
	    } else {
	    	crntcWriteRequestVO.setCrntcPinnedYn("Y"); // 체크된 경우
	    }
		
	    // 파라미터 유효성 검사 체크
		if (bindingResult.hasErrors()) {
			model.addAttribute("usrWriteCrntc", crntcWriteRequestVO);
			return "/bbs/crs/ntc/crntcboardwrite";
		}
		
		boolean isCreated = this.crNtcService.createNewCourseNotice(crntcWriteRequestVO);
		if(isCreated) {
			return "redirect:/crntc/list";
		}
		
		return "/crntc/write";
	}

	// 강좌 공지사항 하나 보기
	@GetMapping("/crntc/view/{id}") // 경로 바뀔 수 있음
	public String viewOneCourseNotice(@PathVariable String id, Model model) {
		CrntcVO crntcVO = this.crNtcService.getOneCourseNoticeBy(id);
		model.addAttribute("selectedCrNotice", crntcVO);
		return "/bbs/crs/ntc/crntcboardview";
	}
	
	// 강좌 공지사항 하나 삭제하기
	@GetMapping("/crntc/delete/{id}") // 경로 바뀔 수 있음
	public String deleteOneCourseNotice(@PathVariable String id) {
		boolean isSuccess = this.crNtcService.deleteOneCourseNoticeBy(id);
		
		if(isSuccess) {
			return "redirect:/crntc/list";	
		}
		return "redirect:/crntc/list";
	}
	
	// 강좌 공지사항 하나 수정하기 (get -> page)
	@GetMapping("/crntc/modify/{id}")
	public String viewCourseNoticeModifyPage(@PathVariable String id, Model model) {
		CrntcVO crntcVO = this.crNtcService.getOneCourseNoticeBy(id);
		// 수정하기 위해 해당 id의 insttnNotice를 가져온 후 모델로 뷰에 전송
		model.addAttribute("toModifyCrntcVO", crntcVO);
		// 이동 & 전송할 뷰 지정
		return "/bbs/crs/ntc/crntcboardedit";
	}

	// 메인 공지사항 하나 수정하기 (post -> do)
	@PostMapping("/crntc/modify/{id}")
	public String modifyOneCourseNotice(
			@Valid @ModelAttribute CrntcUpdateRequestVO crntcUpdateRequestVO,
			@PathVariable String id, 
			BindingResult bindingResult,
			Model model) {
		// 수정 폼 파라미터 유효성 검사
		if(bindingResult.hasErrors()) {
			model.addAttribute("usrModifyCrntc", crntcUpdateRequestVO);
			return "/bbs/crs/ntc/crntcboardedit"; // 수정 뷰에 사용자 작성정보를 보내준다.
		}
		
		// 수정 완료 버튼을 누르면 form 을 전송하므로 VO 필요
		boolean isSuccess = this.crNtcService.updateOneCourseNoticeBy(crntcUpdateRequestVO);
		if(isSuccess) {
			// id를 @PathVariable로 받아오는 것은 redirect를 위함
			return "redirect:/crntc/view/" + id;
		}
		return "redirect:/crntc/list";
	}

}