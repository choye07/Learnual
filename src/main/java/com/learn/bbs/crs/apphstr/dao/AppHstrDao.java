package com.learn.bbs.crs.apphstr.dao;

import java.util.List;

import com.learn.bbs.crs.apphstr.vo.AppHstrReadResponseVO;
import com.learn.bbs.crs.apphstr.vo.AppHstrRegistRequestVO;

/**
 * @author 최예진
 * 신청 내역
 */
public interface AppHstrDao {
	// 강좌 신청
	public int insertOneAppHstr(AppHstrRegistRequestVO appHstrRegistRequestVO);
	
	// 신청 내역 존재 여부 체크
    public boolean existsAppHstr(String crsInfId, String usrMl, String insttnId);

    // 신청 내역 ID 조회해서 CNCL 테이블에 넣을 때 필요함
    public String findAppHstrId(String crsInfId, String usrMl, String insttnId);
    
    // 현재 신청 인원 체크
    public int countCurrentUserInCourse(String crsInfId, String insttnId);
    
    // 현재 신청 인원의 정보 가져오기
    public List<AppHstrReadResponseVO> selectCurrentUserInCourse(String crsInfId, String insttnId);
}