package com.learn.bbs.eduad.flarch.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.learn.bbs.eduad.flarch.service.FlArchService;
import com.learn.bbs.eduad.flarch.vo.FlArchDeleteRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchListVO;
import com.learn.bbs.eduad.flarch.vo.FlArchSearchRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchUpdateRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchVO;
import com.learn.bbs.eduad.flarch.vo.FlArchWriteRequestVO;
import com.learn.bbs.file.service.FlTypeService;
import com.learn.bbs.file.vo.FlTypeVO;
import com.learn.bbs.file.vo.FlVO;

import jakarta.validation.Valid;

@Controller
public class FlArchController {

	// 로그를 쓰기 위한 설정
	private static final Logger LOGGER = LoggerFactory.getLogger(FlArchController.class);

	@Autowired
	private FlArchService flArchService;
	@Autowired
	private FlTypeService flTypeService;

	// 게시글 목록
	@GetMapping("/eduad/flarch/list")
	public String viewFlArchBoardList(Model model, FlArchSearchRequestVO flArchSearchRequestVO) {

		// TODO 로그 출력 -> 배포할 땐 주석처리하기!
		LOGGER.debug("/flarch/list 를 방문했습니다.");

		FlArchListVO flArchListVO = this.flArchService.getFlArchBoardList(flArchSearchRequestVO);
		model.addAttribute("flArchList", flArchListVO);

		// 총 페이지의 수, 현재 페이지 번호를 알 수 있는 flArchSearchRequestVO를 model에 넣어서 알려줌.
		model.addAttribute("pagination", flArchSearchRequestVO);
		return "bbs/eduad/flarch/flarchlist";
	}

	// 게시글 조회
	@GetMapping("/eduad/flarch/view/{flArchId}")
	public String viewOneFlArchBoardPage(@PathVariable String flArchId, Model model) {
		FlArchVO flArchVO = this.flArchService.getOneFlArchBoard(flArchId, true);
		model.addAttribute("flArchVO", flArchVO);

		// 변환 가능한 파일 확장자 조회 -> 추후에 추가하는 기능
		// 파일이 있는 게시글만 조회한다.
//		if (flArchVO.getFlList() != null) {
//			Map<String, List<String>> convertMap = flArchService.getFileConvertibleExtMap(flArchVO.getFlList());
//		    model.addAttribute("convertibleMap", convertMap);
//		}
		return "bbs/eduad/flarch/flarchview";
	}

	// 게시글 등록
	@GetMapping("/eduad/flarch/write")
	public String viewFlArchBoardWritePage() {
		return "bbs/eduad/flarch/flarchwrite";
	}

	// 게시글 등록 - 서버 전송 후 조회
	@PostMapping("/eduad/flarch/write")
	public String doFlArchBoardWrite(@Valid @ModelAttribute FlArchWriteRequestVO flArchWriteRequestVO,
			BindingResult bindingResult, Model model) {
//TODO    							Model model, @SessionAttribute("__LOGIN_USER__") MembersVO memberVO) {

		// 유효성 검사
		if (bindingResult.hasErrors()) {
			model.addAttribute("flArchWriteRequestVO", flArchWriteRequestVO);
			return "bbs/eduad/flarch/flarchwrite";
		}
//TODO    	flArchWriteRequestVO.setInstrId(memberVO.getEmail());
		
		flArchWriteRequestVO.setInstrId("강사명");
		flArchWriteRequestVO.setArtcId("게시판 아이디");

		boolean isCreated = this.flArchService.createNewFlArchBoard(flArchWriteRequestVO);

		if (isCreated) {

			return "redirect:/eduad/flarch/list";
		}
		return "bbs/eduad/flarch/flarchwrite";
	}

	@GetMapping("/eduad/flarch/delete/{flArchId}")
	public String doDeleteOneFlArchBoard(@PathVariable String flArchId) {
//TODO    								@SessionAttribute("__LOGIN_USER__") MembersVO memberVO) {

		FlArchDeleteRequestVO flArchDeleteRequestVO = new FlArchDeleteRequestVO();
		flArchDeleteRequestVO.setFlArchId(flArchId);
//    	flArchDeleteRequestVO.setInstrId(memberVO.getEmail());
		flArchDeleteRequestVO.setInstrId("강사명");

		boolean isSuccess = this.flArchService.deleteOneFlArchBoard(flArchDeleteRequestVO);

		if (isSuccess) {
			return "redirect:/eduad/flarch/list";
		}

		return "redirect:/eduad/flarch/view/" + flArchId;
	}

	@GetMapping("/eduad/flarch/modify/{flArchId}")
	public String viewBoardUpdatePage(@PathVariable String flArchId, Model model) {
//    									@SessionAttribute("__LOGIN_USER__") MembersVO memberVO) {

		// 수정된 게시글을 보여주기 때문에 조회수 증가를 방지하기 위해 false를 준다.
		FlArchVO flArchVO = this.flArchService.getOneFlArchBoard(flArchId, false);

		// 같은 회원이 아니라면 modify 뷰가 보이면 안된다.
		if (flArchVO.getInstrId() != null) {
//TODO    		if( !flArchVO.getInstrId().equals(memberVO.getEmail())) {
			return "redirect:/eduad/flarch/list";
		}

		model.addAttribute("flArchVO", flArchVO);
		return "bbs/eduad/flarch/flarchmodify";
	}

	@PostMapping("/eduad/flarch/modify/{flArchId}")
	public String doUpdateOneBoard(@PathVariable String flArchId, FlArchUpdateRequestVO flArchUpdateRequestVO) {
//    								@SessionAttribute("__LOGIN_USER__") MembersVO memberVO) {

		// DB에서도 내가 쓴 글이 아니라면 수정하지 못하도록 한다.
//TODO    	flArchUpdateRequestVO.setInstrId(memberVO.getEmail());

		flArchUpdateRequestVO.setFlArchId(flArchId);
		boolean isSuccess = this.flArchService.updateOneFlArchBoard(flArchUpdateRequestVO);

		if (isSuccess) {
			return "redirect:/eduad/flarch/view/" + flArchId;
		}

		return "redirect:/eduad/flarch/list";
	}

}