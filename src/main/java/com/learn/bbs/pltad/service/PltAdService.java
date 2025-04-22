package com.learn.bbs.pltad.service;

import com.learn.bbs.pltad.vo.PltadRegistRequestVO;
import com.learn.bbs.pltad.vo.PltadmLoginRequestVO;
import com.learn.bbs.pltad.vo.PltadmVO;

public interface PltAdService {
	public boolean createNewPltad(PltadRegistRequestVO pltadRegistRequestVO);
	
	// 이메일 중복 검사 기능 
    boolean checkDuplicateEmail(String pltadmLgnId);
    // 관리자 로그인 기능
    public PltadmVO doLogin(PltadmLoginRequestVO pltadmLoginRequestVO);
    // 관리자 로그아웃 기능
 	public boolean doLogout(String pltadmLgnId);
 	// 관리자 계정 삭제 기능
 	public boolean doDeleteUsr(String pltadmLgnId);
}