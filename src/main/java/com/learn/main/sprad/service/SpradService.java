package com.learn.main.sprad.service;

import com.learn.main.sprad.vo.SpradLoginRequestVO;
import com.learn.main.sprad.vo.SpradRegistRequestVO;
import com.learn.main.sprad.vo.SpradmVO;

public interface SpradService {
	//슈퍼관리자 등록
	public boolean createNewSprad(SpradRegistRequestVO spradRegistRequestVO);
	
	// 이메일 중복 검사 기능 ß
    boolean checkDuplicateEmail(String spradId);
    // 슈퍼관리자 로그인 기능
    public SpradmVO doLogin(SpradLoginRequestVO spradLoginRequestVO);
    // 슈퍼관리자 로그아웃 기능
 	public boolean doLogout(String spradId);
 	// 슈퍼관리자 계정 삭제 기능
 	public boolean doDeleteUsr(String spradId);
}