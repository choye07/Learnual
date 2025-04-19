package com.learn.bbs.pltad.crsinf.dao;

import com.learn.bbs.pltad.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.pltad.crsinf.vo.CrsInfVO;

/**
 * @TableName CRS_INF
 * @TableComment null
 * 강좌 정보
 */
public interface CrsInfDao {
	// 각 강좌 신청하여 db에 저장하는 Insert 쿼리문
	public int insertOneCourse(CrsInfRegistRequestVO crsInfRegistRequestVO);
	
	public int countCourseName(String crsInfNm);
}