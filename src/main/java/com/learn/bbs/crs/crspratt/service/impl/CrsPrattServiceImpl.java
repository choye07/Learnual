package com.learn.bbs.crs.crspratt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.crs.crsinf.dao.CrsInfDao;
import com.learn.bbs.crs.crspratt.dao.CrsPrattDao;
import com.learn.bbs.crs.crspratt.service.CrsPrattService;
import com.learn.bbs.crs.crspratt.vo.CrsPrattReadResponseVO;
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
    private CrsInfDao crsInfDao;

    @Transactional
	@Override
	public boolean insertCrsPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO) {
    	// 강좌 이력 삽입
    	int isInserted = this.crsPrattDao.insertCrsPratt(crsPrattRegistRequestVO);
    	
    	// DB 저장 실패
    	if(isInserted == 0) {
    		throw new CrsPrattRegistException(crsPrattRegistRequestVO.getCrsPrattId());
    	}
    	
    	// DB 저장 성공
    	return isInserted > 0;
	}

    @Transactional(readOnly = true)
	@Override
	public List<CrsPrattReadResponseVO> selectUsersFromCrsPratt(String crsInfId, String insttnId) {
		return this.crsPrattDao.selectUsersFromCrsPratt(crsInfId, insttnId);
	}
	
	@Transactional(readOnly = true)
	@Override
	public String selectCourseName(String crsInfId, String insttnId) {
		return this.crsInfDao.selectCourseName(crsInfId, insttnId);
	}
}