package com.learn.bbs.pltad.cnfr.dao;

import java.util.List;

import com.learn.bbs.pltad.cnfr.vo.CnfrHstrConfirmReadVO;

/**
 * @author 최예진
 * 확정 내역
 */
public interface CnfrHstrDao {
	// 플랫폼관리자가 마감 버튼 누르면 확정 내역으로 신청한 학생들 정보 넣어주는 쿼리
	public int insertRegisteredUsers();
	
	// 신청 확정지은 학생들의 정보 띄워주기 위해 필요한 쿼리
	public List<CnfrHstrConfirmReadVO> selectAllConfirmedUsers(String crsInfId);
}