package com.learn.bbs.pltad.service.impl;

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
		int selectCount =this.spradDao.selectUsrCountBy(lgnId); // -> 로그인 공통화 처리를 위해 Dao name 변경 
		
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
	
	@Transactional(readOnly= true)
	@Override
	public boolean checkDuplicateEmail(String pltadmLgnId) {
    	// true 라면 쓸 수 없는 email
    	return this.pltAdDao.selectUsrCountBy(pltadmLgnId) == 1;
	}

	@Override
	public PltadmVO doLogin(PltadmLoginRequestVO pltadmLoginRequestVO) {
		// 1. email 로 회원의 모든 정보를 조회한다.
		PltadmVO pltadmVO = this.pltAdDao.selectOneUsrBy(pltadmLoginRequestVO.getPltadmLgnId());	
	
		// 1-1. 회원의 정보가 null 이면 사용자에게 예외를 던져버린다. 
		//		 "비밀번호 또는 이메일을 잘 못 작성했습니다. 확인 후 다시 시도해주세요."
	
		if (pltadmVO == null) {
			throw new PltadmLoginException(pltadmLoginRequestVO);
   	}
		
		// 2. 회원의 정보 중 BLOCK_YN 이 "Y" 라면 예외를 던져버린다.ㅣ
		//		"비밀번호가 n 차례 틀려 계정 접근이 제한되었습니다. 관리자에게 문의 하세요."
		if ("Y".equals(pltadmVO.getPlatadmBlkYn())) {
			throw new PltadmLoginException(pltadmLoginRequestVO, pltadmVO.getPlatadmFailCnt());
	}
		// 3. SALT 를 이용해 memberLoginRequestVO의 password 를 암호화 한다.
		String salt = pltadmVO.getPlatadmLgnSlt();
		String password = pltadmLoginRequestVO.getPltadmLgnPw();
		password = sha.getEncrypt(password, salt);
		
		// 4. 회원의 정보 중 password 값이 memberLoginRequestVO 의 암호화된 password 와 같은지 비교한다.
		if ( ! pltadmVO.getPltadmLgnPw().equals(password)) {
			// 5. 만약 다르면 MEMBERS 테이블의 LOGIN_FAIL_COUNT 값을 1 증가시킨다.
			//		LATEST_LOGIN_FAIL_DATE는 현재시간으로 업데이트 시킨다.
			this.pltAdDao.updateLoginFailCount(pltadmLoginRequestVO.getPltadmLgnId());
			
			// 6. 업데이트된 LOGIN_FAIL_COUNT 의 값이 5 이상이라면 "BLOCK_YN" 값을 "Y" 로 업데이트 시킨다.
			this.pltAdDao.updateBlock(pltadmLoginRequestVO.getPltadmLgnId());
			
			// 7. 사용자에게 예외를 던져버린다.
			// 	"비밀번호 또는 이메일을 잘 못 작성했습니다. 확인 후 다시 시도해주세요."
		   	throw new PltadmLoginException(pltadmLoginRequestVO);
		}
		

		// 8. 회원의 정보 중 password 값이 memberLoginRequestVO 의 암호화된 password와 같다면
		// MEMBERS 테이블의 LOGIN_FAIL_COUNT는 0 으로 수정한다.
		// LATEST_LOGIN_DATE는 현재시간으로 업데이트 한다.
		// LATEST_LOGIN_IP 는 사용자의 IP 로 업데이트 한다.
		// LOGIN_YN 은 "Y" 로 업데이트 한다.
		else {
			this.pltAdDao.updateLoginSuccess(pltadmLoginRequestVO.getPltadmLgnId());
		}
	
	// 9 조회된 사용자 정보를 반환 시킨다. 
		return pltadmVO;
	}

	@Transactional
	@Override
	public boolean doLogout(String pltadmLgnId) {
		return this.pltAdDao.updateLogoutStatus(pltadmLgnId) > 0;
	}

	@Transactional
	@Override
	public boolean doDeleteUsr(String pltadmLgnId) {
		return this.pltAdDao.deleteOneUsrBy(pltadmLgnId) > 0;
	}

}