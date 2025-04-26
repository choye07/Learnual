package com.learn.bbs.artc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.artc.service.ArtcService;
import com.learn.bbs.artc.vo.ArtcReadRequestVO;
import com.learn.bbs.artc.vo.ArtcRegistRequestVO;
import com.learn.bbs.artc.vo.ArtcVO;
import com.learn.main.cmcd.service.CmcdService;
import com.learn.main.cmcd.vo.CmCodeVO;

/**
 * @TableName ARTC
 * @TableComment null 게시판
 */
@Controller
public class ArtcController {

	@Autowired
	private ArtcService artcService;

	@Autowired
	private CmcdService cmcdService;

	@GetMapping("/artcmanage")
	public String viewArtcPage(Model model, ArtcReadRequestVO ArtcReadRequestVO) {

		List<CmCodeVO> cmCdList = this.cmcdService.selectAllCmcd(5);
		List<ArtcVO> artcList = this.artcService.selectAllArtc(ArtcReadRequestVO);
		
		// TO-DO 학원 목록 가져오기.		
		// List<InsttnVO> insttnList
		
		// TO-DO 강좌 목록 가져오기.
		if (artcList != null) {
			model.addAttribute("artcList", artcList);
		}
		model.addAttribute("cmCdList", cmCdList);

		return "bbs/artc/artcmanage";
	}

	@PostMapping("/artcmanage/regist")
	public String doRegistArtc(Model model, ArtcRegistRequestVO artcRegistRequestVO) {

		boolean isRegist = this.artcService.createNewArtc(artcRegistRequestVO);
		if (isRegist) {
			return "success";
		}
		return "fail";
	}

}