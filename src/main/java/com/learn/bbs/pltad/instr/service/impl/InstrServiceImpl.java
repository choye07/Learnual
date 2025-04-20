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
 * @TableComment null
 * 강사
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
	public boolean createInstr(InstrRegistRequestVO instrRegistRequestVO) {
		// 플랫폼 관리자 등록 전에 super관리자 인지 체크해야함.
		String lgnId = instrRegistRequestVO.getLgnId();
		int selectCount =this.pltadDao.selectPltadCount(lgnId);
		
		if(selectCount == 0) {
			throw new InstrRegistException(instrRegistRequestVO);
		}
		
		//플랫폼 관리자 공통 코드 보내기
		String CmcdId = this.sesCmcdDao.selectOneCmcd(instrRegistRequestVO.INSTR_MACC_NM);
		instrRegistRequestVO.setCmcdId(CmcdId);
		
		//비밀 번호 난독화 진행
		String salt = this.sha.generateSalt();

		String password = instrRegistRequestVO.getInstrLgnPw();
		password = this.sha.getEncrypt(password, salt);

		instrRegistRequestVO.setInstrLgnPw(password);
		instrRegistRequestVO.setInstrLgnSltPw(salt);

		
		return this.instrDao.insertNewInstr(instrRegistRequestVO)> 0;
	}

}