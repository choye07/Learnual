package com.learn.exceptions;

import com.learn.bbs.pltad.vo.PltadmLoginRequestVO;

public class PltadmLoginException extends RuntimeException {

    private static final long serialVersionUID = -4823284385179310620L;
    
    private PltadmLoginRequestVO pltadmLoginRequestVO;

    public PltadmLoginException(PltadmLoginRequestVO pltadmLoginRequestVO) {
        super("비밀번호 또는 이메일을 잘못 작성했습니다. 확인 후 다시 시도해 주세요.");
        this.pltadmLoginRequestVO = pltadmLoginRequestVO;
    }

    public PltadmLoginException(PltadmLoginRequestVO pltadmLoginRequestVO, int failCount) {
        super("비밀번호가 " + failCount + "차례 틀려 계정 접근이 제한되었습니다. 플랫폼 관리자에게 문의하세요.");
        this.pltadmLoginRequestVO = pltadmLoginRequestVO;
    }
    
	public PltadmLoginRequestVO getPltadmLoginRequestVO() {
		return pltadmLoginRequestVO;
	}
}
