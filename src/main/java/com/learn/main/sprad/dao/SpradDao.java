package com.learn.main.sprad.dao;

import com.learn.main.sprad.vo.SpradRegistRequestVO;

public interface SpradDao {
	
	/**
	 * 슈퍼 관리자 등록
	 * @param spradRegistRequestVO
	 * @return
	 */
	public int createNewSprad(SpradRegistRequestVO spradRegistRequestVO);
	
	/**
	 * 
	 * @param SpradId
	 * @return
	 */
	public int selectSpradCount(String SpradId);

}