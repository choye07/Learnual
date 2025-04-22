package com.learn.exceptions;

import com.learn.bbs.pltad.instr.vo.InstrLoginRequestVO;
import com.learn.common.vo.LoginRequestVO;

public class InstrLoginException extends RuntimeException {

    private static final long serialVersionUID = -6904036454265260312L;

    private InstrLoginRequestVO instrLoginRequestVO;
    
    public InstrLoginException(InstrLoginRequestVO instrLoginRequestVO) {
        super("비밀번호 또는 이메일을 잘못 작성했습니다. 확인 후 다시 시도해 주세요.");
        this.instrLoginRequestVO = instrLoginRequestVO;
    }

    public InstrLoginException(InstrLoginRequestVO instrLoginRequestVO, int failCount) {
        super("비밀번호가 " + failCount + "차례 틀려 계정 접근이 제한되었습니다. 플랫폼 관리자에게 문의하세요.");
    }
    
    public InstrLoginRequestVO getInstrLoginRequestVO() {
    	return instrLoginRequestVO;
    }
}