package com.learn.bbs.crs.crsinf.service;

import java.util.List;

import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;

/**
 * @author 최예진
 * 강좌 정보
 */
public interface CrsInfService {
	public boolean insertOneCourse(CrsInfRegistRequestVO crsInfRegistRequestVO);
	
	public boolean countCourseName(String crsInfNm);
	
	public List<CrsInfPltadReadResponseVO> selectAllCourseForPltad();
	
	public List<CrsInfPltadFinishedReadResponseVO> selectAllFinishedCourseForPltad();
	
	public boolean updateOneCourse(CrsInfModifyRequestVO crsInfModifyRequestVO);
	
	public CrsInfModifyRequestVO selectAllInfoFromOneCourse(String crsInfId);
	
	public boolean deleteOneCourse(String crsInfId);
	
	public List<CrsInfAvailableReadResponseVO> selectAvailableCourses();
}