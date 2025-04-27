package com.learn.util;

import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.MyInformationRequestVO;

public class SessionUtil {

	/**
	 * 개인정보 수정시 사용자, 관리자, 강사를 공통으로 처리하기 위한 Util
	 * @param usrVO
	 * @param pltadmVO
	 * @param instrVO
	 * @return
	 */
//    public static MyInformationRequestVO myInformationUtil(Object usrVO, Object pltadmVO, Object instrVO) {
//        MyInformationRequestVO myInformationRequestVO = new MyInformationRequestVO();
//
//        if (usrVO instanceof UsrVO) {
//            UsrVO user = (UsrVO) usrVO;
//            myInformationRequestVO.setMyiLgnId(user.getUsrMl());
//            myInformationRequestVO.setMyiLgnPw(user.getUsrPw());
//            myInformationRequestVO.setMyiConfirlgnPw(user.getUsrPw());
//            myInformationRequestVO.setMyiLgnSlt(user.getUsrSlt());
//            myInformationRequestVO.setMyiNm(user.getUsrNm());
//            myInformationRequestVO.setMyiPn(user.getUsrPn());
//            myInformationRequestVO.setMyiAdrs(user.getUsrAdrs());
//            myInformationRequestVO.setMyiUpdtDt(user.getUsrUpdtDt());
//            myInformationRequestVO.setMyiLstPwMdfyDt(user.getUsrLstPwMdfyDt());
//        }
//
//        else if (pltadmVO instanceof PltadmVO) {
//            PltadmVO admin = (PltadmVO) pltadmVO;
//            myInformationRequestVO.setMyiLgnId(admin.getPltadmLgnId());
//            myInformationRequestVO.setMyiLgnPw(admin.getPltadmLgnPw());
//            myInformationRequestVO.setMyiConfirlgnPw(admin.getPltadmLgnPw());
//            myInformationRequestVO.setMyiLgnSlt(admin.getPlatadmLgnSlt());
//            myInformationRequestVO.setMyiNm(admin.getPltadmNm());
//            myInformationRequestVO.setMyiPn(admin.getPltadmPn());
//            myInformationRequestVO.setMyiAdrs(admin.getPltadmAdrs());
//            myInformationRequestVO.setMyiEmail(admin.getPltadmEmail());
//            myInformationRequestVO.setMyiUpdtDt(admin.getPltadmUpdtDt());
//            myInformationRequestVO.setMyiLstPwMdfyDt(admin.getPlatadmLstPwMdfyDt());
//        }
//
//        else if (instrVO instanceof InstrVO) {
//            InstrVO instructor = (InstrVO) instrVO;
//            myInformationRequestVO.setMyiLgnId(instructor.getInstrLgnId());
//            myInformationRequestVO.setMyiLgnPw(instructor.getInstrLgnPw());
//            myInformationRequestVO.setMyiConfirlgnPw(instructor.getInstrLgnPw());
//            myInformationRequestVO.setMyiLgnSlt(instructor.getInstrLgnSltPw());
//            myInformationRequestVO.setMyiNm(instructor.getInstrNm());
//            myInformationRequestVO.setMyiPn(instructor.getInstrPn());
//            myInformationRequestVO.setMyiAdrs(instructor.getInstrAdrs());
//            myInformationRequestVO.setMyiEmail(instructor.getInstrMl());
//            myInformationRequestVO.setMyiUpdtDt(instructor.getInstrUpdtDt());
//            myInformationRequestVO.setMyiLstPwMdfyDt(instructor.getInstrLstPwMdfyDt());
//        }
//
//        return myInformationRequestVO;
//    }
    
    public static MyInformationRequestVO myInformationUtil(PltadmVO pltadmVO) {
        MyInformationRequestVO myInformationRequestVO = new MyInformationRequestVO();

            myInformationRequestVO.setMyiLgnId(pltadmVO.getPltadmLgnId());
            myInformationRequestVO.setMyiLgnPw(pltadmVO.getPltadmLgnPw());
            myInformationRequestVO.setMyiConfirlgnPw(pltadmVO.getPltadmLgnPw());
            myInformationRequestVO.setMyiLgnSlt(pltadmVO.getPlatadmLgnSlt());
            myInformationRequestVO.setMyiNm(pltadmVO.getPltadmNm());
            myInformationRequestVO.setMyiPn(pltadmVO.getPltadmPn());
            myInformationRequestVO.setMyiAdrs(pltadmVO.getPltadmAdrs());
            myInformationRequestVO.setMyiEmail(pltadmVO.getPltadmEmail());
            myInformationRequestVO.setMyiUpdtDt(pltadmVO.getPltadmUpdtDt());
            myInformationRequestVO.setMyiLstPwMdfyDt(pltadmVO.getPlatadmLstPwMdfyDt());

        return myInformationRequestVO;
    }
    
    public static MyInformationRequestVO myInformationUtil(InstrVO instrVO) {
        MyInformationRequestVO myInformationRequestVO = new MyInformationRequestVO();

        InstrVO instructor = (InstrVO) instrVO;
        myInformationRequestVO.setMyiLgnId(instructor.getInstrLgnId());
        myInformationRequestVO.setMyiLgnPw(instructor.getInstrLgnPw());
        myInformationRequestVO.setMyiConfirlgnPw(instructor.getInstrLgnPw());
        myInformationRequestVO.setMyiLgnSlt(instructor.getInstrLgnSltPw());
        myInformationRequestVO.setMyiNm(instructor.getInstrNm());
        myInformationRequestVO.setMyiPn(instructor.getInstrPn());
        myInformationRequestVO.setMyiAdrs(instructor.getInstrAdrs());
        myInformationRequestVO.setMyiEmail(instructor.getInstrMl());
        myInformationRequestVO.setMyiUpdtDt(instructor.getInstrUpdtDt());
        myInformationRequestVO.setMyiLstPwMdfyDt(instructor.getInstrLstPwMdfyDt());

        return myInformationRequestVO;
    }
    
    public static MyInformationRequestVO myInformationUtil(UsrVO usrVO) {
        MyInformationRequestVO myInformationRequestVO = new MyInformationRequestVO();

        UsrVO user = (UsrVO) usrVO;
        myInformationRequestVO.setMyiLgnId(user.getUsrMl());
        myInformationRequestVO.setMyiLgnPw(user.getUsrPw());
        myInformationRequestVO.setMyiConfirlgnPw(user.getUsrPw());
        myInformationRequestVO.setMyiLgnSlt(user.getUsrSlt());
        myInformationRequestVO.setMyiNm(user.getUsrNm());
        myInformationRequestVO.setMyiPn(user.getUsrPn());
        myInformationRequestVO.setMyiAdrs(user.getUsrAdrs());
        myInformationRequestVO.setMyiUpdtDt(user.getUsrUpdtDt());
        myInformationRequestVO.setMyiLstPwMdfyDt(user.getUsrLstPwMdfyDt());

        return myInformationRequestVO;
    }
}

