package com.learn.bbs.menu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.artc.dao.ArtcDao;
import com.learn.bbs.artc.vo.ArtcVO;
import com.learn.bbs.crs.crsinf.dao.CrsInfDao;
import com.learn.bbs.menu.dao.MenuDao;
import com.learn.bbs.menu.service.MenuService;
import com.learn.bbs.menu.vo.MenuListVO;
import com.learn.bbs.menu.vo.MenuRegistRequestVO;
import com.learn.bbs.pltad.instr.web.InstrController;
import com.learn.bbs.usr.web.UsrController;
import com.learn.insttn.dao.InsttnDao;
import com.learn.main.cmcd.dao.CmcdDao;

/**
 * @TableName MENU
 * @TableComment null 메뉴
 */
@Service
public class MenuServiceImpl implements MenuService {

    private final UsrController usrController;
	private static final Logger LOGGER = LoggerFactory.getLogger(InstrController.class);
	@Autowired
	private MenuDao menuDao;

	@Autowired
	private CmcdDao cmcdDao;

	@Autowired
	private InsttnDao insttnDao;

	@Autowired
	private CrsInfDao crsInfDao;

	@Autowired
	private ArtcDao artcDao;

    MenuServiceImpl(UsrController usrController) {
        this.usrController = usrController;
    }

	@Override
	public boolean createNewMenu(MenuRegistRequestVO menuRegistRequestVO) {

		// TO-DO 이미 있는 메뉴 인지.

		return this.menuDao.insertNewMenu(menuRegistRequestVO) > 0;
	}

	@Override
	public MenuListVO selectAllMenu(String insttnId) {
		MenuListVO menuListVO = new MenuListVO();
		menuListVO.setCmCdList(this.cmcdDao.selectAllCmcd(5));
		menuListVO.setInsttnList(this.insttnDao.selectAllInsttnBy(insttnId));
		menuListVO.setCrsinfList(this.crsInfDao.selectAllCrsInfForSpradBy(insttnId));
 		menuListVO.setMenuList(this.menuDao.selectAllMenu(insttnId));
		menuListVO.setArtcList(this.artcDao.selectAllArtc(insttnId));
		

		return menuListVO;
	}

	@Override
	public MenuListVO selectAllInsttnMenuBy(String insttnId) {
		MenuListVO menuListVO = new MenuListVO();
		menuListVO.setCmCdList(this.cmcdDao.selectAllCmcd(5));
		menuListVO.setInsttnList(this.insttnDao.selectAllInsttnBy(insttnId));
		menuListVO.setCrsinfList(this.crsInfDao.selectAllCrsInfForSpradBy(insttnId));
		menuListVO.setMenuList(this.menuDao.selectAllMenu(insttnId));
		menuListVO.setArtcList(this.artcDao.selectAllArtc(insttnId));
		return menuListVO;
	}

	@Override
	public MenuListVO selectAllCrsInfMenuBy(String crsinfId,String insttnId) {
		MenuListVO menuListVO = new MenuListVO();
		menuListVO.setCmCdList(this.cmcdDao.selectAllCmcd(5));
		menuListVO.setCrsinfList(this.crsInfDao.selectAllInsttnForSpradBy(crsinfId));
		menuListVO.setInsttnList(this.insttnDao.selectAllInsttnBy(insttnId));
		menuListVO.setMenuList(this.menuDao.selectAllMenu(crsinfId));
		menuListVO.setArtcList(this.artcDao.selectAllArtc(crsinfId));
		return menuListVO;
	}

}