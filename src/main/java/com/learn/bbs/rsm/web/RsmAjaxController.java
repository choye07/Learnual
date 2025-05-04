package com.learn.bbs.rsm.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.learn.bbs.file.service.FlService;
import com.learn.bbs.file.vo.FlDeleteRequestVO;
import com.learn.bbs.file.vo.FlVO;
import com.learn.bbs.rsm.service.RsmService;
import com.learn.bbs.rsm.vo.RsmDeleteRequestVO;
import com.learn.bbs.rsm.vo.RsmListVO;
import com.learn.bbs.rsm.vo.RsmSearchRequestVO;
import com.learn.bbs.rsm.vo.RsmUpdateRequestVO;
import com.learn.bbs.rsm.vo.RsmWriteRequestVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.AjaxResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController // ajax를 이용해 json으로 응답받기 위해 사용함
public class RsmAjaxController {

	@Autowired
	private RsmService rsmService;
	@Autowired
	private FlService flService;

	// 이력서 목록 조회
	@GetMapping("/usr/{insttnId}/dashboard/ajax/rsm/list")
	public AjaxResponse getMyRsmList(@PathVariable String insttnId, 
			                         RsmSearchRequestVO rsmSearchRequestVO,
			                         @SessionAttribute("__LOGIN_USER__") UsrVO usrVO) {

		// 세션에서 회원 아이디를 가져온다.
		rsmSearchRequestVO.setUsrId(usrVO.getUsrMl());
		rsmSearchRequestVO.setInsttnId(usrVO.getInsttnId());

		// 이력서를 가져온다.
		RsmListVO rsmListVO = this.rsmService.getAllRsm(rsmSearchRequestVO);
		
		// 이력서 목록과 페이지네이션 정보를 Ajax로 반환
		return new AjaxResponse(rsmListVO);
	}

	// 이력서 등록
	@PostMapping("/usr/{insttnId}/dashboard/rsm/write")
	public AjaxResponse registMyRsmList(@PathVariable String insttnId, 
			                            @Valid @ModelAttribute RsmWriteRequestVO rsmWriteRequestVO,
			                            BindingResult bindingResult, @RequestParam("file") MultipartFile file,
			                            @SessionAttribute("__LOGIN_USER__") UsrVO usrVO ) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			Map<String, String> errorMap = new HashMap<>();
			for (ObjectError error : allErrors) {
				String message = error.getDefaultMessage();
				String fieldName = "";

				if (error instanceof FieldError fieldError) {
					fieldName = fieldError.getField();
				}

				errorMap.put(fieldName, message);
			}
			return new AjaxResponse(HttpStatus.BAD_REQUEST.value(), errorMap);
		}

		rsmWriteRequestVO.setUsrId(usrVO.getUsrMl());
		rsmWriteRequestVO.setInsttnId(usrVO.getInsttnId());
		rsmWriteRequestVO.setArtcId("게시판 테스트 아이디");
		rsmWriteRequestVO.setFile(file);
		
		boolean isCreate = this.rsmService.createNewRsm(rsmWriteRequestVO);
		
		return new AjaxResponse(HttpStatus.OK.value(), isCreate);
	}

	// 이력서 삭제
	@GetMapping("usr/{insttnId}/dashboard/rsm/delete/{rsmId}")
	public AjaxResponse deleteMyRsm(@PathVariable String insttnId, 
			                        @PathVariable String rsmId,
    		                        @SessionAttribute("__LOGIN_USER__") UsrVO usrVO) {

		RsmDeleteRequestVO rsmDeleteRequestVO = new RsmDeleteRequestVO();
		rsmDeleteRequestVO.setRsmId(rsmId);
		rsmDeleteRequestVO.setUsrId(usrVO.getUsrMl());
		rsmDeleteRequestVO.setInsttnId(usrVO.getInsttnId());
		
		// 삭제될 파일 가져오기
		List<FlVO> files = this.flService.getFilesById(rsmId);

		if (!files.isEmpty()) {
			rsmDeleteRequestVO.setFile(files.get(0));
		}

		boolean isDelete = this.rsmService.deleteOneRsm(rsmDeleteRequestVO);
		
		return new AjaxResponse(HttpStatus.OK.value(), isDelete);
	}

}