package com.learn.bbs.menu.vo;

import java.util.List;

public class MenuListVO {

	private int menuCnt;
	
	private List<MenuVO> MenuList;

	public int getMenuCnt() {
		return menuCnt;
	}

	public void setMenuCnt(int menuCnt) {
		this.menuCnt = menuCnt;
	}

	public List<MenuVO> getMenuList() {
		return MenuList;
	}

	public void setMenuList(List<MenuVO> menuList) {
		MenuList = menuList;
	}

	
}
