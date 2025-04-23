package com.learn.exceptions;

import com.learn.main.sprad.vo.SpradLoginRequestVO;

public class SpradLoginException extends RuntimeException {
	
    private static final long serialVersionUID = -7771221067688783722L;
    
	private SpradLoginRequestVO spradLoginRequestVO;

    public SpradLoginException(SpradLoginRequestVO spradLoginRequestVO) {
        super("비밀번호 또는 이메일을 잘못 작성했습니다. 확인 후 다시 시도해 주세요.");
        this.spradLoginRequestVO = spradLoginRequestVO;
    }

    public SpradLoginException(SpradLoginRequestVO spradLoginRequestVO, int failCount) {
        super("비밀번호가 " + failCount + "차례 틀려 계정 접근이 제한되었습니다. 플랫폼 관리자에게 문의하세요.");
        this.spradLoginRequestVO = spradLoginRequestVO;
    }
    
	public SpradLoginRequestVO getSpradLoginRequestVO() {
		return spradLoginRequestVO;
	}
}
