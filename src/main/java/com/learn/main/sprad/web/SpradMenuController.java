package com.learn.main.sprad.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learn.bbs.menu.service.MenuService;
import com.learn.bbs.menu.vo.MenuListVO;
import com.learn.bbs.menu.vo.MenuRegistRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.main.sprad.vo.SpradmVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sprad")
public class SpradMenuController {
	
	@Autowired
	private MenuService MenuService;
	
	@GetMapping("/menumanage")
	public String sprMainMenuMangeViewPage( Model model, HttpSession session) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
		SpradmVO spradmVO = (SpradmVO) session.getAttribute("__LOGIN_SPRAD__");

		if (usrVO != null || pltadmVO != null|| instrVO != null ) {
			return "redirect:/learnual";
		}
		
		if(spradmVO==null) {
			return "redirect:/login";
		}
		MenuListVO menuListVO = this.MenuService.selectAllMenu(spradmVO.getInsttnId());
		model.addAttribute("menuListVO",menuListVO);
		return "bbs/menu/menumanage";
	}
	
	@GetMapping("/{insttnId}/insttnmenumanage")
	public String sprInsttnMenuMangeViewPage( Model model, HttpSession session,@PathVariable String insttnId) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
		SpradmVO spradmVO = (SpradmVO) session.getAttribute("__LOGIN_SPRAD__");

		if (usrVO != null || pltadmVO != null|| instrVO != null ) {
			return "redirect:/learnual";
		}
		
		if(spradmVO==null) {
			return "redirect:/login";
		}
		
		MenuListVO menuListVO = this.MenuService.selectAllInsttnMenuBy(insttnId);
		model.addAttribute("menuListVO",menuListVO);
		model.addAttribute("insttnId",insttnId);

		return "bbs/menu/menumanage";
	}
	@GetMapping("/{insttnId}/{crsInfId}/crsinfmenumanage")
	public String sprCrsInfMenuMangeViewPage( Model model, HttpSession session,@PathVariable String crsInfId,@PathVariable String insttnId) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");
		SpradmVO spradmVO = (SpradmVO) session.getAttribute("__LOGIN_SPRAD__");

		if (usrVO != null || pltadmVO != null|| instrVO != null ) {
			return "redirect:/learnual";
		}
		
		if(spradmVO==null) {
			return "redirect:/login";
		}
		
		MenuListVO menuListVO = this.MenuService.selectAllCrsInfMenuBy(crsInfId,insttnId);
		model.addAttribute("menuListVO",menuListVO);
		model.addAttribute("insttnId",insttnId);
		model.addAttribute("crsInfId",crsInfId);
		return "bbs/menu/menumanage";
	}
	@PostMapping("/{insttnId}/menumanage/regist")
	public String doRegistMenu(@Valid @ModelAttribute MenuRegistRequestVO menuRegistRequestVO,
			BindingResult bindingResult, Model model, HttpSession session,@PathVariable String insttnId) {
		
		
		//TO-DO valid 체크 해야함.
		  if (bindingResult.hasErrors()) {
			  model.addAttribute("menuRegistRequestVO", menuRegistRequestVO);
	    		return "bbs/menu/menumanage"; 
	        }
		  
		  menuRegistRequestVO.setInsttnId(insttnId);
		boolean isRegist = this.MenuService.createNewMenu(menuRegistRequestVO);

		if (isRegist) {

			return "redirect:/sprad/menumanage";
		}

		
		return "bbs/menu/menumanage";
	}


}
