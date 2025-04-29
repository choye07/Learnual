package com.learn.bbs.eduad.flarch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.eduad.flarch.service.FlArchService;
import com.learn.bbs.eduad.flarch.vo.FlArchDeleteRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchListVO;
import com.learn.bbs.eduad.flarch.vo.FlArchSearchRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchUpdateRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchVO;
import com.learn.bbs.eduad.flarch.vo.FlArchWriteRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class FlArchController {

	@Autowired
	private FlArchService flArchService;
	private String flArchId;
	// 강사 자료실 목록 뷰
	@GetMapping("/test11")
	public String testInstr() {
		return "bbs/flarch/eduad/flarchboardlisteduad"; 
	}
	// 회원 자료실 목록 뷰
	@GetMapping("/test12")
	public String testUsr() {
		return "bbs/flarch/usr/flarchboardlistusr"; 
	}

	// TODO 자료실 게시판: /eduad/{insttnId}/{crsInfId}/{artcId}
	// 게시글 목록 - 강사 조회
	@GetMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/list")
	public String viewEuadFlArchBoardList(FlArchSearchRequestVO flArchSearchRequestVO,
			                              @PathVariable String insttnId,
                                          @PathVariable String crsInfId,
                                          @PathVariable String artcId,
                                          HttpSession session,
                                          Model model ) {

		InstrVO instrVO= (InstrVO) session.getAttribute("__LOGIN_INSTR__");

		flArchSearchRequestVO.setInsttnId(instrVO.getInsttnId());
		flArchSearchRequestVO.setCrsInfId("CRS_INF-20250428-000014");
		flArchSearchRequestVO.setArtcId("ARTC-20250428-000004");
		flArchSearchRequestVO.setLgnId(instrVO.getInstrLgnId());

		FlArchListVO flArchListVO = this.flArchService.getFlArchBoardList(flArchSearchRequestVO);
		model.addAttribute("flArchList", flArchListVO);

		// 총 페이지의 수, 현재 페이지 번호를 알 수 있는 flArchSearchRequestVO를 model에 넣어서 알려줌.
		model.addAttribute("pagination", flArchSearchRequestVO);
		return "bbs/flarch/eduad/flarchboardlisteduad";
	}

	// 게시글 목록 - 회원도 조회가 가능하다.
	@GetMapping("/usr/{insttnId}/{crsInfId}/{artcId}/flarch/list")
	public String viewUsrFlArchBoardList(FlArchSearchRequestVO flArchSearchRequestVO,
			                             @PathVariable String insttnId,
                                         @PathVariable String crsInfId,
                                         @PathVariable String artcId,
                                         HttpSession session,
			                             Model model ) {

		
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");

		flArchSearchRequestVO.setInsttnId(usrVO.getInsttnId());
		flArchSearchRequestVO.setCrsInfId("CRS_INF-20250428-000014");
		flArchSearchRequestVO.setArtcId("ARTC-20250428-000004");
		flArchSearchRequestVO.setLgnId(usrVO.getUsrMl());

		FlArchListVO flArchListVO = this.flArchService.getFlArchBoardList(flArchSearchRequestVO);
		model.addAttribute("flArchList", flArchListVO);

		// 총 페이지의 수, 현재 페이지 번호를 알 수 있는 flArchSearchRequestVO를 model에 넣어서 알려줌.
		model.addAttribute("pagination", flArchSearchRequestVO);
		return "bbs/flarch/usr/flarchboardlistusr"; 
	}

	// 게시글 조회 - 강사
	@GetMapping("/eduad/INSTTN-20250424-000001/CRS_INF-20250428-000014/ARTC-20250428-000004/flarch/view/{flArchId}")
	public String viewOneFlArchBoardPageInstr (
                                               @PathVariable String flArchId,
                                               Model model, 
			                                   @SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO ) {

		// 원래 파라미터
//		 (@PathVariable String insttnId,
//                 @PathVariable String crsInfId,
//                 @PathVariable String artcId,
//                 @PathVariable String flArchId,
//                 Model model, 
//                 @SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO ) {
		// 세션 가져오기
		// 해당 학원의 강좌를 듣는 학생이나 강사가 아니면 게시글을 조회할 수 없다.
		
		// 게시글 가져오기
		FlArchVO flArchVO = this.flArchService.getOneFlArchBoard(flArchId, true);

		// 학원, 강좌 체크
//		if (!insttnId.equals(flArchVO.getInsttnId()) || !crsInfId.equals(flArchVO.getCrsInfId())) {
//			//return "redirect:/eduad/flarch/list";
//			return "redirect:/eduad/" + "INSTTN-20250424-000001" + "/" + "CRS_INF-20250428-000014" + "/" + "ARTC-20250428-000004" + "/flarch/list";
//		}

		model.addAttribute("flArchVO", flArchVO);
		return "bbs/flarch/eduad/flarchboardvieweduad";
	}
	
	// 게시글 조회 - 회원
		@GetMapping("/usr/INSTTN-20250424-000001/CRS_INF-20250428-000014/ARTC-20250428-000004/flarch/view/{flArchId}")
		public String viewOneFlArchBoardPageUsr (@PathVariable String flArchId,
	                                            Model model, 
				                                @SessionAttribute("__LOGIN_USER__") UsrVO usrVO) {

//			@PathVariable String insttnId,
//            @PathVariable String crsInfId,
//            @PathVariable String artcId,
//            @PathVariable String flArchId,
//           Model model, 
//           @SessionAttribute("__LOGIN_USER__") UsrVO usrVO) {
        	   
			// 게시글 가져오기
			FlArchVO flArchVO = this.flArchService.getOneFlArchBoard(flArchId, true);

			// 세션 가져오기
			// 해당 학원의 강좌를 듣는 학생이나 강사가 아니면 게시글을 조회할 수 없다.
			
			// 학원, 강좌 체크
//			if (!insttnId.equals(flArchVO.getInsttnId()) || !crsInfId.equals(flArchVO.getCrsInfId())) {
//				//return "redirect:/eduad/flarch/list";
//				return "redirect:/usr/" + insttnId + "/" + "CRS_INF-20250428-000014" + "/" + "ARTC-20250428-000004" + "/flarch/list";
//			}

			model.addAttribute("flArchVO", flArchVO);
			return "bbs/flarch/usr/flarchboardviewusr";
		}

	/*
	 * 게시글 등록과 수정, 삭제는 강사만 할 수 있다.(학생은 오직 읽기만 가능하다.)
	 */
		
	// 게시글 등록
	@GetMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/write")
	public String viewFlArchBoardWritePage(HttpSession session) {
		 // 무조건 고정값 세팅
		InstrVO instrVO= (InstrVO) session.getAttribute("__LOGIN_INSTR__");
	    String insttnId = instrVO.getInsttnId();
	    String crsInfId = "CRS_INF-20250428-000014";
	    String artcId = "ARTC-20250428-000004";
		return "bbs/flarch/eduad/flarchboardwriteeduad";
	}

	// 게시글 등록 - 서버 전송 후 조회
	@PostMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/write")
	public String doFlArchBoardWrite(@PathVariable String insttnId,
                                     @PathVariable String crsInfId,
                                     @PathVariable String artcId,
			                         @Valid @ModelAttribute FlArchWriteRequestVO flArchWriteRequestVO,
			                         BindingResult bindingResult, 
			                         Model model,
			                         @SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO) {

		// 유효성 검사
		if (bindingResult.hasErrors()) {
			model.addAttribute("flArchWriteRequestVO", flArchWriteRequestVO);
			return "bbs/flarch/eduad/flarchboardwriteeduad";
		}

		// 로그인된 사용자 정보 설정
		/*
		 * String loginEmail = null; if (instrVO != null) { loginEmail =
		 * instrVO.getInstrMl(); // 강사 이메일 } else { return "redirect:/login"; // 로그인 안
		 * 되어 있으면 로그인 페이지로 리다이렉트 }
		 */

		flArchWriteRequestVO.setInsttnId(instrVO.getInsttnId());
		flArchWriteRequestVO.setCrsInfId("CRS_INF-20250428-000014");
		flArchWriteRequestVO.setArtcId("ARTC-20250428-000004");
		flArchWriteRequestVO.setLgnId(instrVO.getInstrLgnId());
		
		boolean isCreated = this.flArchService.createNewFlArchBoard(flArchWriteRequestVO);

		// 게시글 작성 성공 시 목록 페이지로 리다이렉트
		if (isCreated) {
			//return "redirect:/eduad/" + insttnId + "/" + crsInfId + "/" + artcId + "/flarch/list";
			return "redirect:/eduad/" + instrVO.getInsttnId() + "/" + "CRS_INF-20250428-000014" + "/" + "ARTC-20250428-000004" + "/flarch/list";
		}
		// 실패 시 게시글 작성 화면으로 돌아감
		return "bbs/flarch/eduad/flarchboardwriteeduad";
	}

	@GetMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/delete/{flArchId}")
	public String doDeleteOneFlArchBoard(@PathVariable String insttnId,
                                         @PathVariable String crsInfId,
                                         @PathVariable String artcId,
		                                 @PathVariable String flArchId,
										 @SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO) {

		FlArchDeleteRequestVO flArchDeleteRequestVO = new FlArchDeleteRequestVO();
		
		flArchDeleteRequestVO.setFlArchId(flArchId);
		flArchDeleteRequestVO.setInsttnId(instrVO.getInsttnId());     
		flArchDeleteRequestVO.setCrsInfId("CRS_INF-20250428-000014"); 
		flArchDeleteRequestVO.setArtcId("ARTC-20250428-000004");      
		flArchDeleteRequestVO.setLgnId(instrVO.getInstrLgnId());      
		

		boolean isSuccess = this.flArchService.deleteOneFlArchBoard(flArchDeleteRequestVO);

		if (isSuccess) {
			// 삭제 성공 시 목록 화면으로 리다이렉트
			//return "redirect:/eduad/flarch/list";
			return "redirect:/eduad/" + instrVO.getInsttnId() + "/" + "CRS_INF-20250428-000014" + "/" + "ARTC-20250428-000004" + "/flarch/list";
		}
		// 삭제 실패 시 게시글 조회 화면으로 돌아감
		//return "redirect:/eduad/flarch/view/" + flArchId;
		return "redirect:/eduad/" + instrVO.getInsttnId() + "/" + "CRS_INF-20250428-000014" + "/" + "ARTC-20250428-000004" + "/flarch/view/" + flArchId;
	}

	@GetMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/modify/{flArchId}")
	public String viewBoardUpdatePage(@PathVariable String insttnId,
                                      @PathVariable String crsInfId,
                                      @PathVariable String artcId,
			                          @PathVariable String flArchId,
			                          @SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO
			                          , Model model) {
		// 세션값 지정
		insttnId = instrVO.getInsttnId();       
		crsInfId = "CRS_INF-20250428-000014";   
		artcId = "ARTC-20250428-000004";        
		String lgnId = instrVO.getInstrLgnId(); 
		
		// 수정된 게시글을 보여주기 때문에 조회수 증가를 방지하기 위해 false를 준다.
		FlArchVO flArchVO = this.flArchService.getOneFlArchBoard(flArchId, false);

		// 본인이 작성한 글이 아니면 수정 못함
		// 현재 로그인된 사용자의 이메일(memberVO.getEmail())과 작성자(instrId)를 비교
		if (!instrVO.getInstrLgnId().equals(flArchVO.getLgnId())) {
			return "redirect:/eduad/" + instrVO.getInsttnId() + "/" + "CRS_INF-20250428-000014" + "/" + "ARTC-20250428-000004" + "/flarch/list";
		}

		model.addAttribute("flArchVO", flArchVO);
		// 게시글 수정 화면으로 리턴
		return "bbs/flarch/eduad/flarchboardmodifyeduad";
	}

	@PostMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/modify/{flArchId}")
	public String doUpdateOneBoard(@PathVariable String insttnId, 
			                       @PathVariable String crsInfId,
			                       @PathVariable String artcId,
			                       @PathVariable String flArchId,
			                       @Valid FlArchUpdateRequestVO flArchUpdateRequestVO, 
			                       BindingResult bindingResult,
			                       @SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO) {

		// 유효성 검사
		if (bindingResult.hasErrors()) {
			return "bbs/flarch/eduad/flarchboardmodifyeduad";
		}

		// DB에서도 내가 쓴 글이 아니라면 수정하지 못하도록 한다.
                               
         flArchUpdateRequestVO.setFlArchId(flArchId);                  
         flArchUpdateRequestVO.setInsttnId(instrVO.getInsttnId());     
         flArchUpdateRequestVO.setCrsInfId("CRS_INF-20250428-000014"); 
         flArchUpdateRequestVO.setArtcId("ARTC-20250428-000004");      
         flArchUpdateRequestVO.setLgnId(instrVO.getInstrLgnId());      
                               
		//flArchUpdateRequestVO.setInsttnId(insttnId);
		//flArchUpdateRequestVO.setCrsInfId(crsInfId);
		//flArchUpdateRequestVO.setArtcId(artcId);
		//flArchUpdateRequestVO.setFlArchId(flArchId);
		//flArchUpdateRequestVO.setLgnId(instrVO.getInstrMl());

		boolean isSuccess = this.flArchService.updateOneFlArchBoard(flArchUpdateRequestVO);

		if (isSuccess) {
			// /eduad/{insttnId}/{crsInfId}/{artcId}/flarch/view/{flArchId}")
			return "redirect:/eduad/" + insttnId + "/" + crsInfId + "/" + artcId + "/flarch/view/" + flArchId;
		}
		// 게시글 수정 실패 시 목록 페이지로 리다이렉트
		// /eduad/{insttnId}/{crsInfId}/{artcId}/flarch/list")
		return "redirect:/eduad/" + insttnId + "/" + crsInfId + "/" + artcId + "/flarch/list";
	}

}