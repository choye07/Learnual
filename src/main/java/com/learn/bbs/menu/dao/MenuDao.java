package com.learn.bbs.menu.dao;

import java.util.List;

import com.learn.bbs.menu.vo.MenuRegistRequestVO;
import com.learn.bbs.menu.vo.MenuSearchRequestVO;
import com.learn.bbs.menu.vo.MenuVO;

/**
 * @TableName MENU
 * @TableComment null
 * 메뉴
 */
public interface MenuDao {

	public int insertNewMenu(MenuRegistRequestVO menuRegistRequestVO);
	
	public List<MenuVO> selectAllMenu(MenuSearchRequestVO menuSearchRequestVO);
}