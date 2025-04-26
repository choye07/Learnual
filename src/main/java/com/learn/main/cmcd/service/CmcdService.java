package com.learn.main.cmcd.service;

import java.util.List;

import com.learn.main.cmcd.vo.CmCodeVO;

/**
 * @TableName CM_CODE
 * @TableComment null
 * 공통 코드
 */
public interface CmcdService {
	
	public List<CmCodeVO> selectAllCmcd(int level);
}