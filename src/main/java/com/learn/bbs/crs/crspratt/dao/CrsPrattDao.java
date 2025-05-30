package com.learn.bbs.crs.crspratt.dao;

import java.util.List;

import com.learn.bbs.crs.crspratt.vo.CrsPrattReadResponseVO;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;

/**
 * @author 최예진
 * 수강이력
 */
public interface CrsPrattDao {
	// 수강이력이 있는지 없는지 체크
	public int checkUserHasCrsPratt(String usrMl, String insttnId);
	
	// 플랫폼 관리자가 강좌 마감 후 강좌 확정하면 해당 강좌를 들을 학생들을 수강 이력에 insert하는 쿼리문
	public int insertCrsPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO);
	
	// 확정된 유저들 정보 가져오는 쿼리
	public List<CrsPrattReadResponseVO> selectUsersFromCrsPratt(String crsInfId, String insttnId);
}