package com.learn.bbs.pltad.crssbj.service;

import java.util.List;

import com.learn.bbs.pltad.crssbj.vo.CrsSbjRegistRequestVO;

/**
 * @TableName CRS_SBJ
 * @TableComment null
 * 강좌 과목
 */
public interface CrsSbjService {
	public boolean insertOneCourseSubject(CrsSbjRegistRequestVO crsSbjRegistRequestVO);
	
	public boolean deleteCourseSubject(String crsInfId);
	
	public List<CrsSbjRegistRequestVO> selectSubjectList(String crsInfId);
}