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
	@GetMapping("/mypageinfo/rsm/ajax/list")
	public AjaxResponse getMyRsmList(RsmSearchRequestVO rsmSearchRequestVO, HttpServletRequest request) {

		// 회원의 정보를 Session 에서 가져온다. (__LOGIN_USER__) => UsrVO
//   	 	UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");

		// 세션에서 회원 아이디를 가져온다.
//   	 	rsmSearchRequestVO.setUsrMl(usrVO.getUsrMl());
//		 TODO 마이페이지가 안열려서 세션값으로 아직 못한다.	
		HttpSession session = request.getSession();
		String usrId = (String) session.getAttribute("USR_ID");
		rsmSearchRequestVO.setUsrId(usrId);

		// 이력서를 가져온다.
		RsmListVO rsmListVO = this.rsmService.getAllRsm(rsmSearchRequestVO);
		// 이력서 목록과 페이지네이션 정보를 Ajax로 반환
		return new AjaxResponse(rsmListVO);
	}

	// 이력서 등록
	@PostMapping("/mypageinfo/rsm/write")
	public AjaxResponse registMyRsmList(@Valid @ModelAttribute RsmWriteRequestVO rsmWriteRequestVO,
			BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
//			    						, @SessionAttribute("__LOGIN_USER__") UsrVO usrVO ) {

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

//		rsmWriteRequestVO.setUsrId(usrVO.getUsrId()); // 세션 사용자 정보 채우기
		rsmWriteRequestVO.setUsrId("회원 세션 테스트 아이디");
		rsmWriteRequestVO.setArtcId("게시판 테스트 아이디");
		rsmWriteRequestVO.setFile(file);
		boolean isCreate = this.rsmService.createNewRsm(rsmWriteRequestVO); // rsmVO 안에 파일 포함
		return new AjaxResponse(HttpStatus.OK.value(), isCreate);
	}

	// 이력서 삭제
	@GetMapping("/mypageinfo/rsm/delete/{rsmId}")
	public AjaxResponse deleteMyRsm(@PathVariable String rsmId) {
//    									@SessionAttribute("__LOGIN_USER__") MembersVO memberVO) {

		RsmDeleteRequestVO rsmDeleteRequestVO = new RsmDeleteRequestVO();
		//TODO 세션에서 사용자 정보 설정 (임시로 하드코딩)
		rsmDeleteRequestVO.setRsmId(rsmId); // URL로 전달된 rsmId 설정
		rsmDeleteRequestVO.setUsrId("회원 세션 테스트 아이디");
		// 삭제될 파일 가져오기
		List<FlVO> files = this.flService.getFilesById(rsmId);

		if (!files.isEmpty()) {
			rsmDeleteRequestVO.setFile(files.get(0));
		}

		boolean isDelete = this.rsmService.deleteOneRsm(rsmDeleteRequestVO);
		return new AjaxResponse(HttpStatus.OK.value(), isDelete);
	}

}