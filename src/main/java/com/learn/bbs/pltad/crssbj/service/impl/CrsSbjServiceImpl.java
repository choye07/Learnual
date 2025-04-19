package com.learn.bbs.pltad.crssbj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.pltad.crsinf.dao.CrsInfDao;
import com.learn.bbs.pltad.crssbj.dao.CrsSbjDao;
import com.learn.bbs.pltad.crssbj.service.CrsSbjService;
import com.learn.bbs.pltad.crssbj.vo.CrsSbjRegistRequestVO;
import com.learn.exceptions.CrsSbjRegistException;


/**
 * @TableName CRS_SBJ
 * @TableComment null
 * 강좌 과목
 */
@Service
public class CrsSbjServiceImpl implements CrsSbjService {

    @Autowired
    private CrsSbjDao crsSbjDao;

    @Transactional
	@Override
	public boolean insertOneCourseSubject(CrsSbjRegistRequestVO crsSbjRegistRequestVO) {
    	int isInserted = this.crsSbjDao.insertOneCourseSubject(crsSbjRegistRequestVO);
    	
    	// db 저장 실패; throw error
		if(isInserted == 0) {
			throw new CrsSbjRegistException();
		}
		
		// db 저장 성공
		return isInserted > 0;
	}
}