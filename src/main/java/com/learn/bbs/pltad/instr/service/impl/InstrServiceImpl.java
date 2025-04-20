package com.learn.bbs.pltad.instr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.pltad.dao.PltAdDao;
import com.learn.bbs.pltad.instr.dao.InstrDao;
import com.learn.bbs.pltad.instr.service.InstrService;
import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;
import com.learn.beans.Sha;
import com.learn.common.dao.SesCmcdDao;
import com.learn.exceptions.InstrRegistException;

/**
 * @TableName INSTR
 * @TableComment null 강사
 */
@Service
public class InstrServiceImpl implements InstrService {

	@Autowired
	private InstrDao instrDao;

	@Autowired
	private PltAdDao pltadDao;

	@Autowired
	private SesCmcdDao sesCmcdDao;

	@Autowired
	private Sha sha;

	@Override
	public boolean createNewInstr(InstrRegistRequestVO instrRegistRequestVO) {

		// 플랫폼 관리자 등록 전에 로그인한 계정이 super 관리자 인지 체크해야함.
		String PltLgnId = instrRegistRequestVO.getLgnId();
		int selectLgnIdCount = this.pltadDao.selectPltadCount(PltLgnId);

		if (selectLgnIdCount == 0) {
			throw new InstrRegistException(instrRegistRequestVO);
		}

		// 강사 관리자 권한을 넣어줘야해서 select 해서 가져와야함.
		String CmcdId = this.sesCmcdDao.selectOneSesCmcd(InstrRegistRequestVO.INSTR_MACC_NM);
		instrRegistRequestVO.setCmcdId(CmcdId);

		// 비밀 번호 난독화 진행
		String salt = this.sha.generateSalt();
		String password = instrRegistRequestVO.getInstrLgnPw();

		password = this.sha.getEncrypt(password, salt);

		instrRegistRequestVO.setInstrLgnPw(password);
		instrRegistRequestVO.setInstrLgnSltPw(salt);

		return this.instrDao.insertNewInstr(instrRegistRequestVO) > 0;
	}

}