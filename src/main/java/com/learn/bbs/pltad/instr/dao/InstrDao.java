package com.learn.bbs.pltad.instr.dao;

import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;

/**
 * @TableName INSTR
 * @TableComment null
 * 강사
 */
public interface InstrDao {
	
	public int insertNewInstr(InstrRegistRequestVO instrRegistRequestVO);

}