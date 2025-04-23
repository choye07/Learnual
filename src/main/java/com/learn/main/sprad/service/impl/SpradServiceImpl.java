package com.learn.main.sprad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.pltad.dao.PltAdDao;
import com.learn.bbs.pltad.service.PltAdService;
import com.learn.bbs.pltad.vo.PltadRegistRequestVO;
import com.learn.bbs.pltad.vo.PltadmLoginRequestVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.beans.Sha;
import com.learn.common.dao.SesCmcdDao;
import com.learn.exceptions.PltadRegistException;
import com.learn.exceptions.PltadmLoginException;
import com.learn.exceptions.SpradLoginException;
import com.learn.main.sprad.dao.SpradDao;
import com.learn.main.sprad.service.SpradService;
import com.learn.main.sprad.vo.SpradLoginRequestVO;
import com.learn.main.sprad.vo.SpradRegistRequestVO;
import com.learn.main.sprad.vo.SpradmVO;

@Service
public class SpradServiceImpl implements SpradService {

	@Autowired
	private Sha sha;

	@Autowired
	private SpradDao spradDao;
	

	@Override
	public boolean createNewSprad(SpradRegistRequestVO spradRegistRequestVO) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Transactional(readOnly= true)
	@Override
	public boolean checkDuplicateEmail(String spradId) {
    	// true 라면 쓸 수 없는 email
    	return this.spradDao.selectUsrCountBy(spradId) == 1;
	}

	@Override
	public SpradmVO doLogin(SpradLoginRequestVO spradLoginRequestVO) {
		
		// 회원, 강사, 관리자의 로직과 동일 
		SpradmVO spradmVO = this.spradDao.selectOneUsrBy(spradLoginRequestVO.getSpradmLgnId());	

		if (spradmVO == null) {
			throw new SpradLoginException(spradLoginRequestVO);
   	}
		if ("Y".equals(spradmVO.getSpradmBlkYn())) {
			throw new SpradLoginException(spradLoginRequestVO, spradmVO.getSpradmLgnFailCnt());
	}
		String salt = spradmVO.getSpradmLgnSlt();
		String password = spradLoginRequestVO.getSpradmLgnPw();
		
		password = sha.getEncrypt(password, salt);
		
		if ( ! spradmVO.getSpradmLgnPw().equals(password)) {
			this.spradDao.updateLoginFailCount(spradLoginRequestVO.getSpradmLgnId());
			
			this.spradDao.updateBlock(spradLoginRequestVO.getSpradmLgnId());
			
		   	throw new SpradLoginException(spradLoginRequestVO);
		}
		else {
			this.spradDao.updateLoginSuccess(spradLoginRequestVO.getSpradmLgnId());
		}
	
	// 9 조회된 사용자 정보를 반환 시킨다. 
		return spradmVO;
	}

	@Transactional
	@Override
	public boolean doLogout(String spradId) {
		// 회원, 강사, 관리자의 로직과 동일 
		return this.spradDao.updateLogoutStatus(spradId) > 0;
	}

	@Transactional
	@Override
	public boolean doDeleteUsr(String spradId) {
		// 회원, 강사, 관리자의 로직과 동일 
		return this.spradDao.deleteOneUsrBy(spradId) > 0;
	}
}