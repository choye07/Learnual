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
import com.learn.bbs.usr.vo.UsrVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class FlArchController {

	@Autowired
	private FlArchService flArchService;

	// TODO 자료실 게시판: /eduad/{insttnId}/{crsInfId}/{artcId}
	// 게시글 목록
	@GetMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/list")
	public String viewEuadFlArchBoardList(HttpServletRequest request, 
			                              FlArchSearchRequestVO flArchSearchRequestVO,
			                              Model model, 
			                              @PathVariable String insttnId,
                                          @PathVariable String crsInfId,
                                          @PathVariable String artcId) {

		HttpSession session = request.getSession();

		flArchSearchRequestVO.setInsttnId((String) session.getAttribute("INSTTN_ID"));
		flArchSearchRequestVO.setCrsInfId((String) session.getAttribute("CRS_INF_ID"));
		flArchSearchRequestVO.setArtcId((String) session.getAttribute("ARTC_ID"));
		flArchSearchRequestVO.setLgnId((String) session.getAttribute("LGN_ID"));

		FlArchListVO flArchListVO = this.flArchService.getFlArchBoardList(flArchSearchRequestVO);
		model.addAttribute("flArchList", flArchListVO);

		// 총 페이지의 수, 현재 페이지 번호를 알 수 있는 flArchSearchRequestVO를 model에 넣어서 알려줌.
		model.addAttribute("pagination", flArchSearchRequestVO);
		return "bbs/eduad/flarch/flarchlist";
	}

	// 회원도 조회가 가능하다.
	@GetMapping("/usr/{insttnId}/{crsInfId}/{artcId}/flarch/list")
	public String viewUsrFlArchBoardList(HttpServletRequest request, 
			                             FlArchSearchRequestVO flArchSearchRequestVO,
			                             Model model, 
			                             @PathVariable String insttnId,
                                         @PathVariable String crsInfId,
                                         @PathVariable String artcId,
                                         @PathVariable String flArchId) {

		HttpSession session = request.getSession();

		flArchSearchRequestVO.setInsttnId((String) session.getAttribute("INSTTN_ID"));
		flArchSearchRequestVO.setCrsInfId((String) session.getAttribute("CRS_INF_ID"));
		flArchSearchRequestVO.setArtcId((String) session.getAttribute("ARTC_ID"));
		flArchSearchRequestVO.setLgnId((String) session.getAttribute("LGN_ID"));

		FlArchListVO flArchListVO = this.flArchService.getFlArchBoardList(flArchSearchRequestVO);
		model.addAttribute("flArchList", flArchListVO);

		// 총 페이지의 수, 현재 페이지 번호를 알 수 있는 flArchSearchRequestVO를 model에 넣어서 알려줌.
		model.addAttribute("pagination", flArchSearchRequestVO);
		return "bbs/eduad/flarch/flarchlist";
	}

	// 게시글 조회
	@GetMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/view/{flArchId}")
	public String viewOneFlArchBoardPage(@PathVariable String insttnId,
                                         @PathVariable String crsInfId,
                                         @PathVariable String artcId,
                                         @PathVariable String flArchId,
                                          Model model, HttpSession session,
			                              @SessionAttribute(name = "__LOGIN_INSTR__", required = false) InstrVO instrVO,
			                              @SessionAttribute(name = "__LOGIN_USER__", required = false) UsrVO usrVO) {

		// 게시글 가져오기
		FlArchVO flArchVO = this.flArchService.getOneFlArchBoard(flArchId, true);

		// 세션 가져오기
		String sessionInsttnId = (String) session.getAttribute("INSTTN_ID");
		String sessionCrsInfId = (String) session.getAttribute("CRS_INF_ID");

		// 해당 학원의 강좌를 듣는 학생이나 강사가 아니면 게시글을 조회할 수 없다.
		String loginEmail = null;
		if (instrVO != null) {
			loginEmail = instrVO.getInstrMl(); // 강사 이메일
		} else if (usrVO != null) {
			loginEmail = usrVO.getUsrMl(); // 학생 이메일
		} else {
			// 로그인 안 되어 있으면
			return "redirect:/eduad/flarch/list";
		}

		// 학원, 강좌 체크
		if (!sessionInsttnId.equals(flArchVO.getInsttnId()) || !sessionCrsInfId.equals(flArchVO.getCrsInfId())) {
			return "redirect:/eduad/flarch/list";
		}

		// 본인(강사/학생) 체크
		// 본인(강사 또는 학생)이 맞는지 체크
		if (!loginEmail.equals(flArchVO.getLgnId())) {
			return "redirect:/eduad/flarch/list";
		}

		model.addAttribute("flArchVO", flArchVO);
		return "bbs/eduad/flarch/flarchview";
	}

	// 게시글 등록
	@GetMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/write")
	public String viewFlArchBoardWritePage() {
		return "bbs/eduad/flarch/flarchwrite";
	}

	// 게시글 등록 - 서버 전송 후 조회
	@PostMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/write")
	public String doFlArchBoardWrite(@Valid @ModelAttribute FlArchWriteRequestVO flArchWriteRequestVO,
			BindingResult bindingResult, Model model, HttpSession session, 
			@SessionAttribute("__LOGIN_USER__") InstrVO instrVO) {

		// 유효성 검사
		if (bindingResult.hasErrors()) {
			model.addAttribute("flArchWriteRequestVO", flArchWriteRequestVO);
			return "bbs/eduad/flarch/flarchwrite";
		}

		// 로그인된 사용자 정보 설정
		String loginEmail = null;
		if (instrVO != null) {
			loginEmail = instrVO.getInstrMl(); // 강사 이메일
		} else {
			return "redirect:/login"; // 로그인 안 되어 있으면 로그인 페이지로 리다이렉트
		}

		flArchWriteRequestVO.setInsttnId((String) session.getAttribute("INSTTN_ID"));
		flArchWriteRequestVO.setCrsInfId((String) session.getAttribute("CRS_INF_ID"));
		flArchWriteRequestVO.setArtcId((String) session.getAttribute("ARTC_ID"));
		flArchWriteRequestVO.setLgnId(loginEmail);

		boolean isCreated = this.flArchService.createNewFlArchBoard(flArchWriteRequestVO);

		// 게시글 작성 성공 시 목록 페이지로 리다이렉트
		if (isCreated) {
			return "redirect:/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/list";
		}

		return "bbs/eduad/flarch/flarchwrite"; // 실패 시 글쓰기 페이지로 돌아감
	}

	@GetMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/delete/{flArchId}")
	public String doDeleteOneFlArchBoard(@PathVariable String flArchId, HttpSession session,
										 @SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO) {

		FlArchDeleteRequestVO flArchDeleteRequestVO = new FlArchDeleteRequestVO();
		flArchDeleteRequestVO.setFlArchId(flArchId);
		flArchDeleteRequestVO.setInsttnId((String) session.getAttribute("INSTTN_ID"));
		flArchDeleteRequestVO.setCrsInfId((String) session.getAttribute("CRS_INF_ID"));
		flArchDeleteRequestVO.setArtcId((String) session.getAttribute("ARTC_ID"));
		flArchDeleteRequestVO.setLgnId((String) session.getAttribute("LGN_ID"));
		

		boolean isSuccess = this.flArchService.deleteOneFlArchBoard(flArchDeleteRequestVO);

		if (isSuccess) {
			return "redirect:/eduad/flarch/list";
		}

		return "redirect:/eduad/flarch/view/" + flArchId;
	}

	@GetMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/modify/{flArchId}")
	public String viewBoardUpdatePage(@PathVariable String flArchId, HttpSession session,
			@SessionAttribute("__LOGIN_USER__") InstrVO instrVO, Model model) {

		// 수정된 게시글을 보여주기 때문에 조회수 증가를 방지하기 위해 false를 준다.
		FlArchVO flArchVO = this.flArchService.getOneFlArchBoard(flArchId, false);

		// 본인이 작성한 글이 아니면 수정 못함
		// 현재 로그인된 사용자의 이메일(memberVO.getEmail())과 작성자(instrId)를 비교
		if (!instrVO.getInstrMl().equals(flArchVO.getLgnId())) {
			return "redirect:/eduad/flarch/list";
		}

		model.addAttribute("flArchVO", flArchVO);
		return "bbs/eduad/flarch/flarchmodify";
	}

	@PostMapping("/eduad/{insttnId}/{crsInfId}/{artcId}/flarch/modify/{flArchId}")
	public String doUpdateOneBoard(@PathVariable String insttnId, @PathVariable String crsInfId,
			@PathVariable String artcId, @PathVariable String flArchId,
			@Valid FlArchUpdateRequestVO flArchUpdateRequestVO, BindingResult bindingResult,
			@SessionAttribute("__LOGIN_USER__") InstrVO instrVO) {

		// 유효성 검사
		if (bindingResult.hasErrors()) {
			return "bbs/eduad/flarch/flarchmodify";
		}

		// DB에서도 내가 쓴 글이 아니라면 수정하지 못하도록 한다.
		flArchUpdateRequestVO.setInsttnId(insttnId);
		flArchUpdateRequestVO.setCrsInfId(crsInfId);
		flArchUpdateRequestVO.setArtcId(artcId);
		flArchUpdateRequestVO.setFlArchId(flArchId);
		flArchUpdateRequestVO.setLgnId(instrVO.getInstrMl());

		boolean isSuccess = this.flArchService.updateOneFlArchBoard(flArchUpdateRequestVO);

		if (isSuccess) {
			// /eduad/{insttnId}/{crsInfId}/{artcId}/flarch/view/{flArchId}")
			return "redirect:/eduad/" + insttnId + "/" + crsInfId + "/" + artcId + "/flarch/view/" + flArchId;
		}

		// /eduad/{insttnId}/{crsInfId}/{artcId}/flarch/list")
		return "redirect:/eduad/" + insttnId + "/" + crsInfId + "/" + artcId + "/flarch/list";
	}

}