package com.learn.bbs.menu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.menu.service.MenuService;
import com.learn.bbs.menu.vo.MenuRegistRequestVO;
import com.learn.main.cmcd.service.CmcdService;
import com.learn.main.cmcd.vo.CmCodeVO;

import jakarta.validation.Valid;

/**
 * @TableName MENU
 * @TableComment null 메뉴
 */
@Controller
public class MenuController {

	@Autowired
	private MenuService MenuService;
	
	@Autowired
	private CmcdService cmcdService;
	

	@GetMapping("/menumanage")
	public String menuMangeViewPage(@Valid @ModelAttribute MenuRegistRequestVO menuRegistRequestVO,
			BindingResult bindingResult, Model model) {
		List<CmCodeVO> cmCdList = this.cmcdService.selectAllCmcd(5);
		model.addAttribute("cmCdList", cmCdList);
		return "bbs/menu/menumanage";
	}

	@PostMapping("/menumanage/regist")
	public String doRegistMenu(@Valid @ModelAttribute MenuRegistRequestVO menuRegistRequestVO,
			BindingResult bindingResult, Model model) {

		boolean isRegist = this.MenuService.createNewMenu(menuRegistRequestVO);

		if (isRegist) {
			return "/success";
		}

		return "/fail";
	}

	
}