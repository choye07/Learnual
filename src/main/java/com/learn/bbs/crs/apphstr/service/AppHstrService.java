package com.learn.bbs.crs.apphstr.service;

import com.learn.bbs.crs.apphstr.vo.AppHstrVO;

/**
 * @author 최예진
 * 신청 내역
 */
public interface AppHstrService {
	public boolean insertOneAppHstr(String crsInfId, String usrMl);
}