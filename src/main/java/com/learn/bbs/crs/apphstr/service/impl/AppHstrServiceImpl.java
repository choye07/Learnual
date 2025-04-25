package com.learn.bbs.crs.apphstr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.crs.apphstr.dao.AppHstrDao;
import com.learn.bbs.crs.apphstr.service.AppHstrService;
import com.learn.bbs.crs.crsinf.dao.CrsInfDao;
import com.learn.exceptions.CnclHstrInsertException;


/**
 * @author 최예진
 * 신청 내역
 */
@Service
public class AppHstrServiceImpl implements AppHstrService {

    @Autowired
    private AppHstrDao appHstrDao;
    @Autowired
    private CrsInfDao crsInfDao;

    @Transactional
	@Override
	public boolean insertOneAppHstr(String crsInfId, String usrMl) {
    	// 강좌의 정원 수 조회
        int limitedCount = this.crsInfDao.selectLimitedCount(crsInfId);
        
        // 현재 신청한 인원 수 조회
        int currentUserCount = this.appHstrDao.countCurrentUserInCourse(crsInfId);
        
        // 정원 초과; 신청 불가하게 막아야 한다
        if (currentUserCount >= limitedCount) {
            return false;
        }
        
        // 강좌 신청
        int isInserted = this.appHstrDao.insertOneAppHstr(crsInfId, usrMl);
        
        if(isInserted == 0) {
            throw new CnclHstrInsertException(crsInfId);
        }
        
        return isInserted > 0;
	}
}