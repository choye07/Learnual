package com.learn.exceptions;

import com.learn.common.vo.MyInformationRequestVO;

public class MyInformationUpdateException extends RuntimeException {
	
    private static final long serialVersionUID = -7293021795047512990L;
    
	private MyInformationRequestVO myInfromationRequestVO;

    public MyInformationUpdateException(String message, MyInformationRequestVO myInfromationRequestVO) {
        super(message);
        this.myInfromationRequestVO = myInfromationRequestVO;
    }

    public MyInformationRequestVO getMyInfromationRequestVO() {
        return myInfromationRequestVO;
    }
}