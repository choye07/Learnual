package com.learn.bbs.crs.crsinf.dao;

import java.util.List;

import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfDetailReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfEndUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfStartAndEndTimeRequestVO;

/**
 * @TableName CRS_INF
 * @TableComment null
 * 강좌 정보
 */
public interface CrsInfDao {
	// 각 강좌 신청하여 db에 저장하는 Insert 쿼리문
	public int insertOneCourse(CrsInfRegistRequestVO crsInfRegistRequestVO);
	
	// 중복되는 강좌 이름이 있는지 체크하는 Select - count 쿼리문
	public int countCourseName(String crsInfNm, String insttnId);
	
	// 강좌 이름을 불러오는 쿼리문 - 수정할 때 필요
	public String selectCourseName(String crsInfId, String insttnid);
	
	// 현재 등록되어 있는 강좌중 마감되거나 종료되지 않은 강좌들을 가져옴 - 강좌 관리 페이지(플랫폼관리자)한테만 띄운다
	public List<CrsInfPltadReadResponseVO> selectAllCourseForPltad(String insttnId);
	
	// 현재 등록되어 있는 강좌중 마감된 - 강좌 관리 페이지(플랫폼관리자)한테만 띄운다
	public List<CrsInfPltadFinishedReadResponseVO> selectAllFinishedCourseForPltad(String insttnId);
	
	// 강좌 수정
	public int updateOneCourse(CrsInfModifyRequestVO crsInfUpdateRequestVO);
	
	// 강좌 수정 전 모든 데이터를 수정 폼에 넣어주기 위한 쿼리문
	public CrsInfModifyRequestVO selectAllInfoFromOneCourse(String crsInfId, String insttnId);
	
	// 강좌 삭제; soft delete
	public int deleteOneCourse(String crsInfNm, String insttnId);
	
	// 현재 개설된 강좌들만 불러옴; 유저들에게 보여준다 - 현재 개설 중인 강좌
	public List<CrsInfAvailableReadResponseVO> selectAvailableCoursesForUser(String insttnId);
	
	public List<CrsInfAvailableReadResponseVO> selectAvailableFourCoursesForUser(String insttnId);
	
	// 강좌의 정보를 출력하기 위해 필요함; 커리큘럼도!
	public CrsInfDetailReadResponseVO selectCourseDetail(String crsInfId, String insttnId);
	
	// 강좌 마감
	public int endOneCourse(CrsInfEndUpdateRequestVO crsInfEndUpdateRequestVO);
	
	// 현재 자신이 수강중인 강좌 보여주기 
	public List<CrsInfAvailableReadResponseVO> selectMyCourseForUser(String usrMl, String insttnId);
	
	// 강좌 폐강 
	public int abandonOneCourse(CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO);
	
	// 폐강된 강좌 목록 가져오기
	public List<CrsInfAbandonReadResponseVO> selectAbandonCourse(String insttnId);
	
	// 해당 강좌의 정원 불러오기
	public int selectLimitedCount(String crsInfId, String insttnId);
	
	// 해당 강좌 정보의 수업 시작 시간 & 종료 시간 - 소희
		public CrsInfStartAndEndTimeRequestVO selectCourseTimeStartAndEnd (String crsInfId);
		
	// 강사가 맡은 네가지 강좌
	public List<CrsInfAvailableReadResponseVO> selectFourCoursesForInstr(String instrId, String insttnId);
	
	// 강사가 맡은 모든 강좌
	public List<CrsInfAvailableReadResponseVO> selectCoursesForInstr(String instrId, String insttnId);
}