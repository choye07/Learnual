package com.learn.bbs.attd.dao;

import com.learn.bbs.attd.vo.AttdRegistRequestVO;

/**
 * @author 최예진
 * 신청 내역
 */
public interface AttdDao {
	
	// 사용자의 출석 등록 
	public int insertNewUsrAttd(AttdRegistRequestVO attdRegistRequestVO);

	// 이메일로 조회시 해당 계정 사용자의 강좌정보의  모든 정보를 가져옴.
	//	-> 한사람은 한 기관에서 하나의 강좌만 들을 수 있다는 전제 (로직 변경 가능 있음)
	public AttdRegistRequestVO selectOneUsrAttdBy(String usrMl);

	// 사용자의 출석 후 조퇴 외출 결석 수정 현황 
	public int updateOneUsrAttdCurrent(AttdRegistRequestVO attdRegistRequestVO);
}