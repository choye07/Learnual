package com.learn.bbs.menu.service;

import com.learn.bbs.menu.vo.MenuListVO;
import com.learn.bbs.menu.vo.MenuRegistRequestVO;

/**
 * @TableName MENU
 * @TableComment null
 * 메뉴
 */
public interface MenuService {

	public boolean createNewMenu (MenuRegistRequestVO menuRegistRequestVO);
	
	public MenuListVO selectAllMenu (String insttnId);
	
	public MenuListVO selectAllInsttnMenuBy (String insttnId);
	
	public MenuListVO selectAllCrsInfMenuBy (String crsinfId,String insttnId);
	
}