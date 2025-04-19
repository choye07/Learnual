package com.learn.bbs.pltad.crssbj.dao;

import java.util.List;

import com.learn.bbs.crs.sbj.vo.SbjVO;
import com.learn.bbs.pltad.crssbj.vo.CrsSbjRegistRequestVO;

/**
 * @TableName CRS_SBJ
 * @TableComment null
 * 강좌 과목
 */
public interface CrsSbjDao {
	// 강좌 등록할 때 강좌 과목 테이블에 강좌 id 선택한 과목들의 id를 저장하기 위해 필요한 쿼리문
	public int insertOneCourseSubject(CrsSbjRegistRequestVO crsSbjRegistRequestVO);
	
	// 강좌 수정할 때 강좌 과목 테이블 삭제하는 쿼리문
	public int deleteCourseSubject(String crsInfId);
	
	// 강좌 수정할 때 과목 리스트 불러올 쿼리문
	public List<CrsSbjRegistRequestVO> selectSubjectList(String crsInfId);
}