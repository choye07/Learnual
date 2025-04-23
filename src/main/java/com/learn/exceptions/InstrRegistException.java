package com.learn.exceptions;

import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;

public class InstrRegistException extends RuntimeException{
	private static final long serialVersionUID = -1895073148170913734L;

	
	private InstrRegistRequestVO instrRegistRequestVO;
	
	private CrsInfRegistRequestVO crsInfRegistRequestVO;
	
	private CrsPrattRegistRequestVO crsPrattRegistRequestVO;
	
	private CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO;


	public InstrRegistException(InstrRegistRequestVO instrRegistRequestVO) {
		super("강사(학습 관리자)를 등록할 권한이 없습니다. 계정을 확인해주세요");
		this.instrRegistRequestVO = instrRegistRequestVO;
	}
	
	public InstrRegistException(CrsInfRegistRequestVO crsInfRegistRequestVO) {
		super("강좌 개설 권한이 없습니다. 계정을 확인해주세요");
		this.crsInfRegistRequestVO = crsInfRegistRequestVO;
	}
	
	public InstrRegistException(CrsPrattRegistRequestVO crsPrattRegistRequestVO) {
		super("강좌 확정 권한이 없습니다. 계정을 확인해주세요.");
		this.crsPrattRegistRequestVO = crsPrattRegistRequestVO;
	}
	
	public InstrRegistException(CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO) {
		super("강좌 폐강 권한이 없습니다. 계정을 확인해주세요.");
		this.crsInfAbandonUpdateRequestVO = crsInfAbandonUpdateRequestVO;
	}
	
    public InstrRegistException(String loginId) {
        super("권한이 없습니다. 계정을 확인해주세요.");
    }
}
