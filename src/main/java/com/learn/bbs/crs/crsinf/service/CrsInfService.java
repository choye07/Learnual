package com.learn.bbs.crs.crsinf.service;

import java.util.List;

import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfCourseListReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfDetailReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfEndUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;
import com.learn.bbs.crs.sbj.vo.SbjVO;
import com.learn.bbs.pltad.cnfr.vo.CnfrHstrConfirmReadVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;

/**
 * @author 최예진
 * 강좌 정보
 */
public interface CrsInfService {
	public boolean insertOneCourse(CrsInfRegistRequestVO crsInfRegistRequestVO);
	
	public boolean countCourseName(String crsInfNm, String insttnId);
	
	public String selectCourseName(String crsInfId, String insttnId);
	
	public List<CrsInfPltadReadResponseVO> selectAllCourseForPltad(String insttnId);
	
	public List<CrsInfPltadFinishedReadResponseVO> selectAllFinishedCourseForPltad(String insttnId);
	
	public boolean updateOneCourse(CrsInfModifyRequestVO crsInfModifyRequestVO);
	
	public CrsInfModifyRequestVO selectAllInfoFromOneCourse(String crsInfId, String insttnId);
	
	public boolean deleteOneCourse(String crsInfId, String insttnId);
	
	public List<CrsInfAvailableReadResponseVO> selectRegisterableCourses(String insttnId);
	
	public CrsInfDetailReadResponseVO selectCourseDetail(String crsInfId, String insttnId);

	public boolean isAppliedOrCancelled(String crsInfId, String usrMl, String insttnId);
	
	public boolean endOneCourse(CrsInfEndUpdateRequestVO crsInfEndUpdateRequestVO);
	
	public int insertRegisteredUsers(String insttnId);
	
	public List<CnfrHstrConfirmReadVO> getConfirmedUsers(String crsInfId, String insttnId);
	
	public boolean insertCrsPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO);
	
	public void saveConfirmedUsersToPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO);
	
    public List<SbjVO> getSubjectList();
    
    public List<InstrVO> getInstrList();
    
    public boolean abandonOneCourse(CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO);
    
    public List<CrsInfAbandonReadResponseVO> selectAbandonCourse(String insttnId);
    
    public String selectOneInstrName(String crsInfId);
    
    public CrsInfCourseListReadResponseVO selectAvailableFourCoursesWithStatus(String usrId, String insttnId);
}