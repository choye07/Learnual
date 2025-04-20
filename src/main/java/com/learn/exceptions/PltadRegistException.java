package com.learn.exceptions;

import com.learn.bbs.pltad.vo.PltadRegistRequestVO;

public class PltadRegistException extends RuntimeException{

	private static final long serialVersionUID = 3836109947631315693L;
	
	private PltadRegistRequestVO pltadRegistRequestVO;

	

	public PltadRegistException(PltadRegistRequestVO pltadRegistRequestVO) {
		super("플랫폼 관리자 등록 권한이 없습니다. 계정을 확인해주세요");
		this.pltadRegistRequestVO = pltadRegistRequestVO;
	}



	public PltadRegistRequestVO getPltadRegistRequestVO() {
		return pltadRegistRequestVO;
	}
	
	
	

}
