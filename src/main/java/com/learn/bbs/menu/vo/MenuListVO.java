package com.learn.bbs.menu.vo;

import java.util.List;

import com.learn.bbs.artc.vo.ArtcVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfVO;
import com.learn.insttn.vo.InsttnVO;
import com.learn.main.cmcd.vo.CmCodeVO;

public class MenuListVO {

	private int menuCnt;
	
	private List<MenuVO> menuList;
	
	private List<CmCodeVO> cmCdList;
	
	private List<InsttnVO> insttnList;
	
	private List<CrsInfVO> crsinfList;
	
	private List<ArtcVO> ArtcList;

    public List<ArtcVO> getArtcList() {
		return ArtcList;
	}

	public void setArtcList(List<ArtcVO> artcList) {
		ArtcList = artcList;
	}

	public List<CrsInfVO> getCrsinfList() {
		return crsinfList;
	}

	public void setCrsinfList(List<CrsInfVO> crsinfList) {
		this.crsinfList = crsinfList;
	}

	public List<InsttnVO> getInsttnList() {
		return insttnList;
	}

	public void setInsttnList(List<InsttnVO> insttnList) {
		this.insttnList = insttnList;
	}

	public List<CmCodeVO> getCmCdList() {
		return cmCdList;
	}

	public void setCmCdList(List<CmCodeVO> cmCdList) {
		this.cmCdList = cmCdList;
	}

	public int getMenuCnt() {
		return menuCnt;
	}

	public void setMenuCnt(int menuCnt) {
		this.menuCnt = menuCnt;
	}

	public List<MenuVO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuVO> menuList) {
		this.menuList = menuList;
	}

	
}
