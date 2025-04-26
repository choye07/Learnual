package com.learn.bbs.crs.apphstr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.crs.apphstr.dao.AppHstrDao;
import com.learn.bbs.crs.apphstr.service.AppHstrService;
import com.learn.bbs.crs.apphstr.vo.AppHstrReadResponseVO;
import com.learn.bbs.crs.apphstr.vo.AppHstrRegistRequestVO;
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
	public boolean insertOneAppHstr(AppHstrRegistRequestVO appHstrRegistRequestVO) {
    	// 현재 강좌의 정원 수 조회
    	int limitedCount = this.crsInfDao.selectLimitedCount(appHstrRegistRequestVO.getCrsInfId(), appHstrRegistRequestVO.getInsttnId());
        // 현재 강좌의 신청 수 조회
    	int currentUserCount = this.appHstrDao.countCurrentUserInCourse(appHstrRegistRequestVO.getCrsInfId(), appHstrRegistRequestVO.getInsttnId());

    	// 정원 초과시 신청 불가
        if (currentUserCount >= limitedCount) {
            return false;
        }

        int isInserted = this.appHstrDao.insertOneAppHstr(appHstrRegistRequestVO);

        if (isInserted == 0) {
            throw new CnclHstrInsertException(appHstrRegistRequestVO.getCrsInfId());
        }

        return isInserted > 0;
    }

    @Transactional(readOnly = true)
	@Override
	public List<AppHstrReadResponseVO> selectCurrentUserInCourse(String crsInfId, String insttnId) {
		return this.appHstrDao.selectCurrentUserInCourse(crsInfId, insttnId);
	}
    
    @Transactional(readOnly = true)
	@Override
	public String selectCourseName(String crsInfId, String insttnId) {
		return this.crsInfDao.selectCourseName(crsInfId, insttnId);
	}
}