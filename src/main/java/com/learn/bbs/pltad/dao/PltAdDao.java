package com.learn.bbs.pltad.dao;

import com.learn.bbs.pltad.vo.PltadRegistRequestVO;

public interface PltAdDao {

	
	//플랫폼 관리자 등록
	public int insertNewPltad(PltadRegistRequestVO pltadRegistRequestVO);
	
	//플랫폼 관린자 등록되어 있는지 체크
	public int selectPltadCount(String lgnId);
	
	
}