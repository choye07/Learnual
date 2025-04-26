package com.learn.bbs.crs.cncl.service;


/**
 * @author 최예진
 * 취소 내역
 */
public interface CnclHstrService {
	public boolean insertCancelledAppHstr(String crsInfId, String usrMl, String insttnId);
}