package com.learn.bbs.crs.apphstr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.crs.apphstr.dao.AppHstrDao;
import com.learn.bbs.crs.apphstr.service.AppHstrService;
import com.learn.bbs.crs.apphstr.vo.AppHstrVO;
import com.learn.exceptions.AppHstrInsertException;


/**
 * @author 최예진
 * 신청 내역
 */
@Service
public class AppHstrServiceImpl implements AppHstrService {

    @Autowired
    private AppHstrDao appHstrDao;

    @Transactional
	@Override
	public boolean insertOneAppHstr(AppHstrVO appHstr) {
		int isInserted = this.appHstrDao.insertOneAppHstr(appHstr);
		
		if(isInserted == 0) {
			 throw new AppHstrInsertException(appHstr.getAppHstrId());
		}
		
		return isInserted > 0;
	}
}