package com.learn.bbs.crs.apphstr.dao;

import com.learn.bbs.crs.apphstr.vo.AppHstrVO;

/**
 * @author 최예진
 * 신청 내역
 */
public interface AppHstrDao {
	// 강좌 신청
	public int insertOneAppHstr(AppHstrVO appHstr);
	
	// 신청 내역 존재 여부 체크
	// 여기도 유저 id 처리해야하는데 쿼리문은 제대로 써놨고 뒤에 컨트롤러에서 더미데이터 박아놨습니다. (CrsInfController)
    public boolean existsAppHstr(String crsInfId, String usrId);

    // 신청 내역 ID 조회해서 CNCL 테이블에 넣을 때 필요함
    // 여기도 유저 id 처리해야하는데 쿼리문은 제대로 써놨고 뒤에 서비스에서 더미데이터 박아놨습니다. (CnclHstrController)
    public String findAppHstrId(String crsInfId, String usrId);
}