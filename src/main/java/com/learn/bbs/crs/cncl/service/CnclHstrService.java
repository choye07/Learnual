package com.learn.bbs.crs.cncl.service;


/**
 * @author 최예진
 * 취소 내역
 */
public interface CnclHstrService {
	// usrId 필요한데 일단 더미데이터로 박아놨어요
	public boolean insertCancelledAppHstr(String crsInfId, String usrId);
}