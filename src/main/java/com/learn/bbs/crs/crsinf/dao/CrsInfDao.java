package com.learn.bbs.crs.crsinf.dao;

import java.util.List;

import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfDetailReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfVO;

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
	public List<CrsInfAvailableReadResponseVO> selectAvailableCoursesForUser();
	
	// 강좌의 정보를 출력하기 위해 필요함; 커리큘럼도!
	public CrsInfDetailReadResponseVO selectCourseDetail(String crsInfId);
	
	// 강좌 마감
	public int endOneCourse(String crsInfId);
	
	// 현재 자신이 수강중인 강좌 보여주기 
	public List<CrsInfAvailableReadResponseVO> selectMyCourseForUser(String usrId);
	
	// 강좌 폐강 
	public int abandonOneCourse(CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO);
	
	// 폐강된 강좌 목록 가져오기
	public List<CrsInfAbandonReadResponseVO> selectAbandonCourse();
	
	// 강좌 확정 페이지에서 체크하지 않은 학생들(강좌 신청은 했으나 최종적으로 강좌를 듣지 않기로 결정한 학생들)	
	public int updateNotAttendCourse(List<String> usrIds, String loginId);
}