package com.learn.bbs.rsm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.learn.bbs.rsm.service.RsmService;
import com.learn.bbs.rsm.vo.RsmListVO;
import com.learn.bbs.rsm.vo.RsmSearchRequestVO;

@Controller
public class RsmController {
	
	@Autowired
	private RsmService rsmService;
	
	// 이력서 목록 조회
		@GetMapping("/mypageinfo/rsm/list")
		public String viewMyRsmList(Model model, RsmSearchRequestVO rsmSearchRequestVO) {
	// TODO 마이페이지가 안열려서 세션값으로 아직 못한다.					, HttpSession session) {

			// 회원의 정보를 Session 에서 가져온다. (__LOGIN_USER__) => UsrVO
//	   	 	UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");

			// 세션에서 회원 아이디를 가져온다.
//	   	 	rsmSearchRequestVO.setUsrMl(usrVO.getUsrMl());
			rsmSearchRequestVO.setUsrId("회원 세션 테스트 아이디");

			// 이력서를 가져온다.
			RsmListVO rsmListVO = this.rsmService.getAllRsm(rsmSearchRequestVO);
			model.addAttribute("rsmListVO", rsmListVO);

			// 총 페이지의 수, 현재 페이지 번호를 알 수 있는 flArchSearchRequestVO를 model에 넣어서 알려줌.
			model.addAttribute("pagination", rsmSearchRequestVO);
			return "bbs/rsm/rsmboardlistusr";
		}

}
