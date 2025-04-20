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
	private SesCmcdDao sesCmcdDao;
	
	@Autowired
	private SpradDao spradDao;
	
	@Autowired
	private Sha sha;

	@Override
	public boolean createNewPltad(PltadRegistRequestVO pltadRegistRequestVO) {

		// 플랫폼 관리자 등록 전에 로그인한 계정이 super 관리자 인지 체크해야함.
		String SpradLgnId = pltadRegistRequestVO.getLgnId();
		int selectLgnIdCount = this.spradDao.selectSpradCount(SpradLgnId);
		
		if(selectLgnIdCount ==0) {
			throw new PltadRegistException(pltadRegistRequestVO);
		}
		
		
		// 플랫폼 관리자 권한을 넣어줘야해서 select 해서 가져와야함.
		String CmcdId = this.sesCmcdDao.selectOneSesCmcd(PltadRegistRequestVO.PLTAD_MACC_NM);
		pltadRegistRequestVO.setCmcdId(CmcdId);
		
		// 비밀 번호 난독화 진행
		String salt = this.sha.generateSalt();

		String password = pltadRegistRequestVO.getPltadmLgnPw();
		password = this.sha.getEncrypt(password, salt);

		pltadRegistRequestVO.setPltadmLgnPw(password);
		pltadRegistRequestVO.setPlatadmLgnSlt(salt);

		return this.pltAdDao.insertNewPltad(pltadRegistRequestVO) > 0;
	}

}