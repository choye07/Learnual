package com.learn.bbs.crs.crsinf.service;

import java.util.List;

import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfDetailReadResponseVO;
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
	
	public boolean countCourseName(String crsInfNm);
	
	public String selectCourseName(String crsInfId);
	
	public List<CrsInfPltadReadResponseVO> selectAllCourseForPltad();
	
	public List<CrsInfPltadFinishedReadResponseVO> selectAllFinishedCourseForPltad();
	
	public boolean updateOneCourse(CrsInfModifyRequestVO crsInfModifyRequestVO);
	
	public CrsInfModifyRequestVO selectAllInfoFromOneCourse(String crsInfId);
	
	public boolean deleteOneCourse(String crsInfId);
	
	public List<CrsInfAvailableReadResponseVO> selectRegisterableCourses();
	
	public List<CrsInfAvailableReadResponseVO> selectCoursesForUser(String usrId);
	
	public CrsInfDetailReadResponseVO selectCourseDetail(String crsInfId);
	
	// usrID 필요한데 일단 더미데이터로 박아놨어요 
	public boolean isAppliedOrCancelled(String crsInfId, String usrId);
	
	public boolean endOneCourse(String crsInfId);
	
	public int insertRegisteredUsers();
	
	public List<CnfrHstrConfirmReadVO> getConfirmedUsers(String crsInfId);
	
	public boolean insertCrsPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO);
	
	public void saveConfirmedUsersToPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO);
	
    public List<SbjVO> getSubjectList();
    
    public List<InstrVO> getInstrList();
    
    public boolean abandonOneCourse(CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO);
    
    public List<CrsInfAbandonReadResponseVO> selectAbandonCourse();
    
    public boolean updateNotAttendCourse(List<String> usrIds, String loginId);
}