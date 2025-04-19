package com.learn.bbs.pltad.crssbj.service;

import com.learn.bbs.pltad.crssbj.vo.CrsSbjRegistRequestVO;

/**
 * @TableName CRS_SBJ
 * @TableComment null
 * 강좌 과목
 */
public interface CrsSbjService {
	public boolean insertOneCourseSubject(CrsSbjRegistRequestVO crsSbjRegistRequestVO);
}