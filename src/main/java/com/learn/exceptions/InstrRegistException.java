package com.learn.exceptions;

import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;

public class InstrRegistException extends RuntimeException{
	private static final long serialVersionUID = -1895073148170913734L;

	
	private InstrRegistRequestVO instrRegistRequestVO;


	public InstrRegistException(InstrRegistRequestVO instrRegistRequestVO) {
		super("강사(학습 관리자)를 등록할 권한이 없습니다. 계정을 확인해주세요");
		this.instrRegistRequestVO = instrRegistRequestVO;
	}
	
	
}
