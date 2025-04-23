package com.learn.bbs.crs.crspratt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.crs.crspratt.dao.CrsPrattDao;
import com.learn.bbs.crs.crspratt.service.CrsPrattService;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;
import com.learn.bbs.pltad.dao.PltAdDao;
import com.learn.exceptions.CrsPrattRegistException;
import com.learn.exceptions.InstrRegistException;

/**
 * @author 최예진
 * 수강이력
 */
@Service
public class CrsPrattServiceImpl implements CrsPrattService {

    @Autowired
    private CrsPrattDao crsPrattDao;
    @Autowired
    private PltAdDao pltAdDao;

	@Override
	public boolean insertCrsPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO) {
    	// 세션 값이 들어가야하는데 일단 세팅을 해놨습니다.
    	String loginId = crsPrattRegistRequestVO.getLogId();
    	int selectCount = this.pltAdDao.selectPltadCount(loginId);
    	
    	if(selectCount == 0) {
    		throw new InstrRegistException(crsPrattRegistRequestVO);
    	}
    	
    	// 강좌 이력 삽입
    	int isInserted = this.crsPrattDao.insertCrsPratt(crsPrattRegistRequestVO);
    	
    	// DB 저장 실패
    	if(isInserted == 0) {
    		throw new CrsPrattRegistException(crsPrattRegistRequestVO.getCrsPrattId());
    	}
    	
    	// DB 저장 성공
    	return isInserted > 0;
	}
}