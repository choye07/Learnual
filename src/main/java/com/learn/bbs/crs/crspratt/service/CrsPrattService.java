package com.learn.bbs.crs.crspratt.service;

import java.util.List;

import com.learn.bbs.crs.crspratt.vo.CrsPrattReadResponseVO;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;

/**
 * @author 최예진
 * 수강이력
 */
public interface CrsPrattService {
	public boolean insertCrsPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO);
	
	public List<CrsPrattReadResponseVO> selectUsersFromCrsPratt(String crsInfId, String insttnId);
	
	public String selectCourseName(String crsInfId, String insttnId);
}