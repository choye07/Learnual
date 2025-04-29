package com.learn.bbs.menu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.bbs.menu.service.MenuService;
import com.learn.bbs.menu.vo.MenuListVO;

import jakarta.servlet.http.HttpSession;

/**
 * @TableName MENU
 * @TableComment null 메뉴
 */
@RestController()
public class MenuController {

	@Autowired
	private MenuService MenuService;
	

	@GetMapping("/main")
	public MenuListVO menuMangeViewPage(HttpSession session,Model model) {
		return this.MenuService.selectAllMenu("learnual");
	}
	




	
}