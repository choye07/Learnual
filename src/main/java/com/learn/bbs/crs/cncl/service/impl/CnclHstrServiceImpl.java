package com.learn.bbs.crs.cncl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.crs.apphstr.dao.AppHstrDao;
import com.learn.bbs.crs.cncl.dao.CnclHstrDao;
import com.learn.bbs.crs.cncl.service.CnclHstrService;
import com.learn.bbs.crs.cncl.vo.CnclCancellationRequestVO;
import com.learn.exceptions.CnclHstrInsertException;


/**
 * @author 최예진
 * 취소 내역
 */
@Service
public class CnclHstrServiceImpl implements CnclHstrService {

    @Autowired
    private CnclHstrDao cnclHstrDao;
    @Autowired
    private AppHstrDao appHstrDao;

	@Override
	public boolean insertCancelledAppHstr(String crsInfId, String usrId) {
		boolean hasApplied = this.appHstrDao.existsAppHstr(crsInfId, usrId);
	    
	    if (!hasApplied) {
	    	throw new CnclHstrInsertException(crsInfId);
	    }
	    	
	    String appHstrId = this.appHstrDao.findAppHstrId(crsInfId, usrId);
	    
	    CnclCancellationRequestVO cnclCancellationRequestVO = new CnclCancellationRequestVO();
	    cnclCancellationRequestVO.setAppHstrId(appHstrId);

	    // 신청 취소 내역 삽입
	    return cnclHstrDao.insertCancelledAppHstr(cnclCancellationRequestVO) > 0;
	}
}