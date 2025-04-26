package com.learn.bbs.menu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.menu.dao.MenuDao;
import com.learn.bbs.menu.service.MenuService;
import com.learn.bbs.menu.vo.MenuListVO;
import com.learn.bbs.menu.vo.MenuRegistRequestVO;
import com.learn.bbs.menu.vo.MenuSearchRequestVO;

/**
 * @TableName MENU
 * @TableComment null
 * 메뉴
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

	@Override
	public boolean createNewMenu(MenuRegistRequestVO menuRegistRequestVO) {
		
		//TO-DO 이미 있는 메뉴 인지.
		
		
		return this.menuDao.insertNewMenu(menuRegistRequestVO) > 0;
	}

	@Override
	public MenuListVO selectMenu(MenuSearchRequestVO MenuSearchRequestVO) {
		// TODO Auto-generated method stub
		return null;
	}

}