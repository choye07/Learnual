package com.learn.bbs.attd.service;

import com.learn.bbs.attd.vo.AttdRegistRequestVO;

/**
 * @author 최예진
 * 신청 내역
 */
public interface AttdService {
	
	// 사용자 출석여부등록 기능 
	public boolean createNewUsrAttd(AttdRegistRequestVO attdRegistRequestVO);
	
	public AttdRegistRequestVO doUsrAttd(AttdRegistRequestVO attdRegistRequestVO);
	
	// 사용자 출석 후 조퇴, 외출, 결석 현황 수정 
	public boolean updateUsrAttdCurrent(AttdRegistRequestVO attdRegistRequestVO);


}