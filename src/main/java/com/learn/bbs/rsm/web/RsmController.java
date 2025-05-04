package com.learn.bbs.rsm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.rsm.service.RsmService;
import com.learn.bbs.rsm.vo.RsmListVO;
import com.learn.bbs.rsm.vo.RsmSearchRequestVO;
import com.learn.bbs.usr.vo.UsrVO;

@Controller
public class RsmController {
	
	@Autowired
	private RsmService rsmService;
	
	// 이력서 목록 조회
		@GetMapping("/usr/{insttnId}/dashboard/rsm/list")
		public String viewMyRsmList(@PathVariable String insttnId, 
				                    RsmSearchRequestVO rsmSearchRequestVO,
				                    Model model,
				                    @SessionAttribute("__LOGIN_USER__") UsrVO usrVO) {

			// 회원의 정보를 Session 에서 가져온다. (__LOGIN_USER__) => UsrVO

			// 세션에서 회원 아이디를 가져온다.
	   	 	rsmSearchRequestVO.setInsttnId(usrVO.getInsttnId());
	   	 	rsmSearchRequestVO.setUsrId(usrVO.getUsrMl());

			// 이력서를 가져온다.
			RsmListVO rsmListVO = this.rsmService.getAllRsm(rsmSearchRequestVO);
			model.addAttribute("rsmListVO", rsmListVO);

			// 총 페이지의 수, 현재 페이지 번호를 알 수 있는 flArchSearchRequestVO를 model에 넣어서 알려줌.
			model.addAttribute("pagination", rsmSearchRequestVO);
			return "dashboard/usr/rsm/dashboardusrmyresumelist";
		}

}
