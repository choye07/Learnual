package com.learn.bbs.pltad.dao;

import com.learn.bbs.pltad.vo.PltadRegistRequestVO;

public interface PltAdDao {

	/**
	 * 플랫폼 관리자 등록
	 * @param SpradId
	 * @return
	 */
	public int insertNewPltad(PltadRegistRequestVO pltadRegistRequestVO);
	
	/**
	 * 등록 되어있는 아이디인지 체크
	 * @param SpradId
	 * @return
	 */
	public int selectPltadCount(String PltadId);
	
	
}