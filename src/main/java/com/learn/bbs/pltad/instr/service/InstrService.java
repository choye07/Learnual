package com.learn.bbs.pltad.instr.service;

import java.util.List;

import com.learn.bbs.pltad.instr.vo.InstrLoginRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;

/**
 * @TableName INSTR
 * @TableComment null
 * 강사
 */
public interface InstrService {
	
	public boolean createInstr(InstrRegistRequestVO instrRegistRequestVO);

	// 이메일 중복 검사 기능 
    boolean checkDuplicateEmail(String instrLgnId);
    // 강사 로그인 기능
    public InstrVO doLogin(InstrLoginRequestVO instrLoginRequestVO);
    // 강사 로그아웃 기능
 	public boolean doLogout(String instrLgnId);
 	// 강사 계정 삭제 기능
 	public boolean doDeleteUsr(String instrLgnId);
 	
 	public List<InstrVO> selectAllInstrs();
}