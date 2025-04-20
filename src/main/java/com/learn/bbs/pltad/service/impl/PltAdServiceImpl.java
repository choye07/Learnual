package com.learn.bbs.pltad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.pltad.dao.PltAdDao;
import com.learn.bbs.pltad.service.PltAdService;
import com.learn.bbs.pltad.vo.PltadRegistRequestVO;
import com.learn.beans.Sha;
import com.learn.common.dao.SesCmcdDao;
import com.learn.exceptions.PltadRegistException;
import com.learn.main.sprad.dao.SpradDao;

@Service
public class PltAdServiceImpl implements PltAdService {

	@Autowired
	private PltAdDao pltAdDao;
	

	@Autowired
	private Sha sha;

	@Autowired
	private SpradDao spradDao;
	
	

	@Autowired
	private SesCmcdDao SesCmcdDao;
	

	@Override
	public boolean createNewPltad(PltadRegistRequestVO pltadRegistRequestVO) {

		// 플랫폼 관리자 등록 전에 super관리자 인지 체크해야함.
		String lgnId = pltadRegistRequestVO.getLgnId();
		int selectCount =this.spradDao.selectSpradCount(lgnId);
		
		if(selectCount == 0) {
			throw new PltadRegistException(pltadRegistRequestVO);
		}
		
		//플랫폼 관리자 공통 코드 보내기
		String CmcdId = this.SesCmcdDao.selectOneCmcd(pltadRegistRequestVO.PLTAD_MACC_NM);
		pltadRegistRequestVO.setCmcdId(CmcdId);
		
		//비밀 번호 난독화 진행
		String salt = this.sha.generateSalt();

		String password = pltadRegistRequestVO.getPltadmLgnPw();
		password = this.sha.getEncrypt(password, salt);

		pltadRegistRequestVO.setPltadmLgnPw(password);
		pltadRegistRequestVO.setPlatadmLgnSlt(salt);

		
		return this.pltAdDao.insertNewPltad(pltadRegistRequestVO) > 0;
	}

}