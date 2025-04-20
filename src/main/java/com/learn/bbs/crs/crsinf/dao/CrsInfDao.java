package com.learn.bbs.crs.crsinf.dao;

import java.util.List;
import java.util.Map;

import com.learn.bbs.crs.apphstr.vo.AppHstrVO;
import com.learn.bbs.crs.cncl.vo.CnclCancellationRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfDetailReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;

/**
 * @TableName CRS_INF
 * @TableComment null
 * 강좌 정보
 */
public interface CrsInfDao {
	// 각 강좌 신청하여 db에 저장하는 Insert 쿼리문
	public int insertOneCourse(CrsInfRegistRequestVO crsInfRegistRequestVO);
	
	// 중복되는 강좌 이름이 있는지 체크하는 Select - count 쿼리문
	public int countCourseName(String crsInfNm);
	
	// 강좌 이름을 불러오는 쿼리문 - 수정할 때 필요
	public String selectCourseName(String crsInfId);
	
	// 현재 등록되어 있는 강좌중 마감되거나 종료되지 않은 강좌들을 가져옴 - 강좌 관리 페이지(플랫폼관리자)한테만 띄운다
	public List<CrsInfPltadReadResponseVO> selectAllCourseForPltad();
	
	// 현재 등록되어 있는 강좌중 마감된 - 강좌 관리 페이지(플랫폼관리자)한테만 띄운다
	public List<CrsInfPltadFinishedReadResponseVO> selectAllFinishedCourseForPltad();
	
	// 강좌 수정
	public int updateOneCourse(CrsInfModifyRequestVO crsInfUpdateRequestVO);
	
	// 강좌 수정 전 모든 데이터를 수정 폼에 넣어주기 위한 쿼리문
	public CrsInfModifyRequestVO selectAllInfoFromOneCourse(String crsInfId);
	
	// 강좌 삭제; soft delete
	public int deleteOneCourse(String crsInfNm);
	
	// 현재 수강신청 가능한 강좌들만 불러옴
	public List<CrsInfAvailableReadResponseVO> selectAvailableCourses();
	
	// 강좌의 정보를 출력하기 위해 필요함; 커리큘럼도!
	public CrsInfDetailReadResponseVO selectCourseDetail(String crsInfId);
}