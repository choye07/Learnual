package com.learn.bbs.pltad.instr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.crs.crsinf.dao.CrsInfDao;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.pltad.dao.PltAdDao;
import com.learn.bbs.pltad.instr.dao.InstrDao;
import com.learn.bbs.pltad.instr.service.InstrService;
import com.learn.bbs.pltad.instr.vo.InstrLoginRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.beans.Sha;
import com.learn.common.dao.SesCmcdDao;
import com.learn.common.vo.LoginRequestVO;
import com.learn.common.vo.MyInformationRequestVO;
import com.learn.exceptions.InstrLoginException;
import com.learn.exceptions.InstrRegistException;
import com.learn.exceptions.MyInformationUpdateException;

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
    private CrsInfDao crsInfDao;
    
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
	
	@Transactional(readOnly= true)
	@Override
	public boolean checkDuplicateEmail(String instrLgnId) {
    	// true 라면 쓸 수 없는 email
    	return this.instrDao.selectUsrCountBy(instrLgnId) == 1;
	}

	@Override
	public InstrVO doLogin(InstrLoginRequestVO instrLoginRequestVO) {
		// 1. email 로 회원의 모든 정보를 조회한다.
		InstrVO instrVO = this.instrDao.selectOneUsrBy(instrLoginRequestVO.getInstrLgnId());
	
		LoginRequestVO loginRequestVO = new LoginRequestVO();
		loginRequestVO.setLgnId(instrLoginRequestVO.getInstrLgnId());
		loginRequestVO.setLgnPw(instrLoginRequestVO.getInstrLgnPw());
		
		// 1-1. 회원의 정보가 null 이면 사용자에게 예외를 던져버린다. 
		//		 "비밀번호 또는 이메일을 잘 못 작성했습니다. 확인 후 다시 시도해주세요."
		if (instrVO == null) {
			throw new InstrLoginException(instrLoginRequestVO);
   	}
		
		// 2. 회원의 정보 중 BLOCK_YN 이 "Y" 라면 예외를 던져버린다.ㅣ
		//		"비밀번호가 n 차례 틀려 계정 접근이 제한되었습니다. 관리자에게 문의 하세요."
		if ("Y".equals(instrVO.getInstrBlkYn())) {
			System.out.println(instrVO.getInstrLgnFailCnt() + " : eererer");
			throw new InstrLoginException(instrLoginRequestVO, instrVO.getInstrLgnFailCnt());
	}
		// 3. SALT 를 이용해 memberLoginRequestVO의 password 를 암호화 한다.
		String salt = instrVO.getInstrLgnSltPw();
		String password = instrLoginRequestVO.getInstrLgnPw();
		password = sha.getEncrypt(password, salt);
		
		// 4. 회원의 정보 중 password 값이 memberLoginRequestVO 의 암호화된 password 와 같은지 비교한다.
		if ( ! instrVO.getInstrLgnPw().equals(password)) {
			// 5. 만약 다르면 MEMBERS 테이블의 LOGIN_FAIL_COUNT 값을 1 증가시킨다.
			//		LATEST_LOGIN_FAIL_DATE는 현재시간으로 업데이트 시킨다.
			this.instrDao.updateLoginFailCount(instrLoginRequestVO.getInstrLgnId());
			
			// 6. 업데이트된 LOGIN_FAIL_COUNT 의 값이 5 이상이라면 "BLOCK_YN" 값을 "Y" 로 업데이트 시킨다.
			this.instrDao.updateBlock(instrLoginRequestVO.getInstrLgnId());
			
			// 7. 사용자에게 예외를 던져버린다.
			// 	"비밀번호 또는 이메일을 잘 못 작성했습니다. 확인 후 다시 시도해주세요."
		   	throw new InstrLoginException(instrLoginRequestVO);
		}
		

		// 8. 회원의 정보 중 password 값이 memberLoginRequestVO 의 암호화된 password와 같다면
		// MEMBERS 테이블의 LOGIN_FAIL_COUNT는 0 으로 수정한다.
		// LATEST_LOGIN_DATE는 현재시간으로 업데이트 한다.
		// LATEST_LOGIN_IP 는 사용자의 IP 로 업데이트 한다.
		// LOGIN_YN 은 "Y" 로 업데이트 한다.
		else {
			this.instrDao.updateLoginSuccess(instrLoginRequestVO.getInstrLgnId());
		}
	
	// 9 조회된 사용자 정보를 반환 시킨다. 
		return instrVO;
	}
	
	@Transactional
	@Override
	public boolean doLogout(String instrLgnId) {
		return this.instrDao.updateLogoutStatus(instrLgnId) > 0;
	}
	
	@Transactional
	@Override
	public boolean doDeleteUsr(String instrLgnId) {
		return this.instrDao.deleteOneUsrBy(instrLgnId) > 0;
	}
	
	@Transactional
	@Override
	public boolean updateUsrEditMyinformation(MyInformationRequestVO myInfromationRequestVO) {
		// 1. pltAd 테이블에 email 이 있는지 조회한다.
		boolean emailCheck = this.checkDuplicateEmail(myInfromationRequestVO.getMyiLgnId());

		if (!emailCheck) {
			throw new MyInformationUpdateException("해당 이메일이 존재하지 않습니다.", myInfromationRequestVO);
		}

		// 2. 비밀번호 변경 데이터 처리
		if (myInfromationRequestVO.getMyiLgnPw() != null && !myInfromationRequestVO.getMyiLgnPw().isEmpty()) {
			// 2. 수정 정보에 비밀번호 변경 데이터가 있다면 암호화를 진행.
			String salt = this.sha.generateSalt();

			String password = myInfromationRequestVO.getMyiLgnPw();
			password = this.sha.getEncrypt(password, salt);
			myInfromationRequestVO.setMyiLgnPw(password);
			myInfromationRequestVO.setMyiLgnSlt(salt);
		} else {
			// 만약 비밀번호가 없다면?
			// 2-1. email 로 회원의 모든 정보를 조회한 후에 해당 계정의 비밀번호를 저장해준다.
			InstrVO instrVO = this.instrDao.selectOneUsrBy(myInfromationRequestVO.getMyiLgnId());

			if (instrVO == null) {
				throw new MyInformationUpdateException("회원 정보 조회 중 오류가 발생했습니다.", myInfromationRequestVO);
			}

			myInfromationRequestVO.setMyiLgnPw(instrVO.getInstrLgnPw());
			myInfromationRequestVO.setMyiLgnSlt(instrVO.getInstrLgnSltPw());

		}

		// 3. 수정 정보 처리
		if (myInfromationRequestVO.getMyiNm() == null || myInfromationRequestVO.getMyiNm().isEmpty()) {
			throw new MyInformationUpdateException("이름이 유효하지 않습니다.", myInfromationRequestVO);
		}

		if (myInfromationRequestVO.getMyiPn() == null || myInfromationRequestVO.getMyiPn().isEmpty()) {
			throw new MyInformationUpdateException("전화번호가 유효하지 않습니다.", myInfromationRequestVO);
		}

		if (myInfromationRequestVO.getMyiAdrs() == null || myInfromationRequestVO.getMyiAdrs().isEmpty()) {
			throw new MyInformationUpdateException("주소가 유효하지 않습니다.", myInfromationRequestVO);
		}

		// 4. 업데이트 처리
		return this.instrDao.updateOneUsrEditMyinformation(myInfromationRequestVO) > 0;
	}
    
	@Transactional(readOnly = true)
	@Override
	public List<InstrVO> selectAllInstrs() {
		return this.instrDao.selectAllInstrs();
	}

	@Transactional(readOnly = true)
	@Override
	public List<CrsInfAvailableReadResponseVO> selectCoursesForInstr(String instrId, String insttnId) {
		return this.crsInfDao.selectCoursesForInstr(instrId, insttnId);
	}
}