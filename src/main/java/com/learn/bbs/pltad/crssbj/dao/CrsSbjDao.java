package com.learn.bbs.pltad.crssbj.dao;

import com.learn.bbs.pltad.crssbj.vo.CrsSbjRegistRequestVO;

/**
 * @TableName CRS_SBJ
 * @TableComment null
 * 강좌 과목
 */
public interface CrsSbjDao {
	// 강좌 등록할 때 강좌 과목 테이블에 강좌 id 선택한 과목들의 id를 저장하기 위해 필요한 쿼리문
	public int insertOneCourseSubject(CrsSbjRegistRequestVO crsSbjRegistRequestVO);
}