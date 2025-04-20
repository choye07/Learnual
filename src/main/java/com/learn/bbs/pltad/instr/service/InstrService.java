package com.learn.bbs.pltad.instr.service;

import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;

/**
 * @TableName INSTR
 * @TableComment null
 * 강사
 */
public interface InstrService {
	
	public boolean createInstr(InstrRegistRequestVO instrRegistRequestVO);

}