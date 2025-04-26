package com.learn.main.cmcd.dao;

import java.util.List;

import com.learn.main.cmcd.vo.CmCodeVO;

/**
 * @TableName CM_CODE
 * @TableComment null
 * 공통 코드
 */
public interface CmcdDao {
	
	public List<CmCodeVO> selectAllCmcd(int level);

}