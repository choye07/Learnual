package com.learn.bbs.menu.service;

import com.learn.bbs.menu.vo.MenuListVO;
import com.learn.bbs.menu.vo.MenuRegistRequestVO;
import com.learn.bbs.menu.vo.MenuSearchRequestVO;

/**
 * @TableName MENU
 * @TableComment null
 * 메뉴
 */
public interface MenuService {

	public boolean createNewMenu (MenuRegistRequestVO menuRegistRequestVO);
	
	public MenuListVO selectMenu (MenuSearchRequestVO MenuSearchRequestVO);
}