package com.learn.bbs.crs.apphstr.dao;

import com.learn.bbs.crs.apphstr.vo.AppHstrVO;

/**
 * @author 최예진
 * 신청 내역
 */
public interface AppHstrDao {
	// 강좌 신청
	public int insertOneAppHstr(String crsInfId, String usrMl);
	
	// 신청 내역 존재 여부 체크
    public boolean existsAppHstr(String crsInfId, String usrMl);

    // 신청 내역 ID 조회해서 CNCL 테이블에 넣을 때 필요함
    public String findAppHstrId(String crsInfId, String usrMl);
    
    // 현재 신청 인원 체크
    public int countCurrentUserInCourse(String crsInfId);
}