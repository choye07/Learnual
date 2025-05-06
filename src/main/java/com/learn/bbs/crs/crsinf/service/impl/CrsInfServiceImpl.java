package com.learn.bbs.crs.crsinf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.crs.apphstr.dao.AppHstrDao;
import com.learn.bbs.crs.cncl.dao.CnclHstrDao;
import com.learn.bbs.crs.crsinf.dao.CrsInfDao;
import com.learn.bbs.crs.crsinf.service.CrsInfService;
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
import com.learn.bbs.crs.crsinf.vo.CrsInfStartAndEndTimeRequestVO;
import com.learn.bbs.crs.crspratt.dao.CrsPrattDao;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;
import com.learn.bbs.crs.sbj.dao.SbjDao;
import com.learn.bbs.crs.sbj.vo.SbjVO;
import com.learn.bbs.pltad.cnfr.dao.CnfrHstrDao;
import com.learn.bbs.pltad.cnfr.vo.CnfrHstrConfirmReadVO;
import com.learn.bbs.pltad.crssbj.dao.CrsSbjDao;
import com.learn.bbs.pltad.crssbj.vo.CrsSbjRegistRequestVO;
import com.learn.bbs.pltad.instr.dao.InstrDao;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.exceptions.CnfrHstrInsertException;
import com.learn.exceptions.CrsInfDeleteException;
import com.learn.exceptions.CrsInfRegistException;
import com.learn.exceptions.CrsInfUpdateException;
import com.learn.exceptions.CrsPrattRegistException;

/**
 * @author 최예진
 * 강좌 정보
 */
@Service
public class CrsInfServiceImpl implements CrsInfService {

    @Autowired
    private CrsInfDao crsInfDao;
    @Autowired
    private CrsSbjDao crsSbjDao;
    @Autowired
    private SbjDao sbjDao;
    @Autowired
    private InstrDao instrDao;
    @Autowired
    private AppHstrDao appHstrDao;
    @Autowired
    private CnclHstrDao cnclHstrDao;
    @Autowired
    private CrsPrattDao crsPrattDao;
    @Autowired
    private CnfrHstrDao cnfrHstrDao;

    @Transactional
    @Override
    public boolean insertOneCourse(CrsInfRegistRequestVO crsInfRegistRequestVO) {
        // 강좌 정보 삽입
        int isInsertedCourse = this.crsInfDao.insertOneCourse(crsInfRegistRequestVO);
        
        // 강좌 정보 DB 저장 실패 시 예외 처리
        if (isInsertedCourse == 0) {
            throw new CrsInfRegistException(crsInfRegistRequestVO.getCrsInfId());
        }

        String crsInfId = crsInfRegistRequestVO.getCrsInfId();

        // 과목 정보 삽입
        for (String sbjId : crsInfRegistRequestVO.getSubjects()) {
            CrsSbjRegistRequestVO crsSbjRegistRequestVO = new CrsSbjRegistRequestVO();
            
            crsSbjRegistRequestVO.setCrsInfId(crsInfId);
            crsSbjRegistRequestVO.setSbjId(sbjId);
        	
            this.crsSbjDao.insertOneCourseSubject(crsSbjRegistRequestVO);
        }

        // DB 저장 성공
        return isInsertedCourse > 0;
    }

    @Transactional(readOnly = true)
	@Override
	public boolean countCourseName(String crsInfNm, String insttnId) {
		return this.crsInfDao.countCourseName(crsInfNm, insttnId) > 0;
	}
    
    @Transactional(readOnly = true)
	@Override
	public String selectCourseName(String crsInfId, String insttnId) {
		return this.crsInfDao.selectCourseName(crsInfId, insttnId);
	}
    
    @Transactional(readOnly = true)
    @Override
	public List<CrsInfPltadReadResponseVO> selectAllCourseForPltad(String insttnId) {
		return this.crsInfDao.selectAllCourseForPltad(insttnId);
    }

    @Transactional(readOnly = true)
	@Override
	public List<CrsInfPltadFinishedReadResponseVO> selectAllFinishedCourseForPltad(String insttnId) {
    	return this.crsInfDao.selectAllFinishedCourseForPltad(insttnId);
	}

    @Transactional
	@Override
	public boolean updateOneCourse(CrsInfModifyRequestVO crsInfModifyRequestVO) {    	
    	this.crsSbjDao.deleteCourseSubject(crsInfModifyRequestVO.getCrsInfId());
    	
        int isUpdatedCourse = this.crsInfDao.updateOneCourse(crsInfModifyRequestVO);
        
        // 강좌 정보 DB 저장 실패 시 예외 처리
        if (isUpdatedCourse == 0) {
            throw new CrsInfUpdateException(crsInfModifyRequestVO.getCrsInfId());
        }

        String crsInfId = crsInfModifyRequestVO.getCrsInfId();

        // 과목 정보 삽입
        for (String sbjId : crsInfModifyRequestVO.getSubjects()) {
            CrsSbjRegistRequestVO crsSbjRegistRequestVO = new CrsSbjRegistRequestVO();
            
            crsSbjRegistRequestVO.setCrsInfId(crsInfId);
            crsSbjRegistRequestVO.setSbjId(sbjId);
        	
            this.crsSbjDao.insertOneCourseSubject(crsSbjRegistRequestVO);
        }

        // DB 저장 성공
        return isUpdatedCourse > 0;
	}

    @Transactional(readOnly = true)
	@Override
	public CrsInfModifyRequestVO selectAllInfoFromOneCourse(String crsInfId, String insttnId) {
    	// 다시 정보 불러와서 수정 form에 보여줘야한다.
    	CrsInfModifyRequestVO oneCourse = this.crsInfDao.selectAllInfoFromOneCourse(crsInfId, insttnId);
    	
    	List<String> subjectNameList = new ArrayList<>();
    	
    	for(CrsSbjRegistRequestVO subject : this.crsSbjDao.selectSubjectList(crsInfId)) {
    		subjectNameList.add(subject.getSbjId());
    	}
    	
    	oneCourse.setSubjects(subjectNameList);
    	
    	return oneCourse;
	}

    @Transactional
	@Override
	public boolean deleteOneCourse(String crsInfId, String insttnId) {
		int isUpdated = this.crsInfDao.deleteOneCourse(crsInfId, insttnId);
		
		if(isUpdated == 0) {
			throw new CrsInfDeleteException(crsInfId);
		}
		
		return isUpdated > 0;
	}
    
//    @Override
//	public List<CrsInfAvailableReadResponseVO> selectAvailableFourCoursesForUser(String usrMl) {
//    	// 수강 이력이 있는가?
//		int count = this.crsPrattDao.checkUserHasCrsPratt(usrMl);
//		
//		if(count == 0) {
//			// 수강 이력 X; 수강 중인 강좌가 현재 없기 때문에 강좌 신청 가능 목록을 보여준다
//	        List<CrsInfAvailableReadResponseVO> availableCourses = this.crsInfDao.selectAvailableFourCoursesForUser();
//
//			return availableCourses;
//		} else {
//			// 수강 이력 O; 현재 수강중인 강좌 목록을 보여준다
//			return this.crsInfDao.selectMyCourseForUser(usrMl);
//		}
//	}

    @Transactional(readOnly = true)
	@Override
	public CrsInfDetailReadResponseVO selectCourseDetail(String crsInfId, String insttnId) {
    	return this.crsInfDao.selectCourseDetail(crsInfId, insttnId);
	}

    @Transactional(readOnly = true)
    public boolean isAppliedOrCancelled(String crsInfId, String usrMl, String insttnId) {
        // 신청 내역 ID 조회
        String appHstrId = this.appHstrDao.findAppHstrId(crsInfId, usrMl, insttnId);

        if (appHstrId == null) {
            // 신청 안 했으면 -> 신청 버튼 보여줌
            return false;
        }

        // 신청은 했고, 취소 안 했으면 -> 신청 취소 버튼 보여줌
        boolean isCancelled = this.cnclHstrDao.existsCancelledAppHstr(appHstrId, insttnId);
        return !isCancelled;
    }

    @Transactional
	@Override
	public boolean endOneCourse(CrsInfEndUpdateRequestVO crsInfEndUpdateRequestVO) {
		int isUpdated = this.crsInfDao.endOneCourse(crsInfEndUpdateRequestVO);
		
		// DB 수정 실패
		if(isUpdated == 0) {
			throw new CrsInfUpdateException(crsInfEndUpdateRequestVO.getCrsInfId());
		}
		
		return isUpdated > 0;
	}

    @Transactional(readOnly = true)
	@Override
	public List<CrsInfAvailableReadResponseVO> selectRegisterableCourses(String insttnId) {
		return this.crsInfDao.selectAvailableCoursesForUser(insttnId);
	}
	
    @Transactional
	@Override
	public int insertRegisteredUsers(String insttnId) {
		int isInserted = this.cnfrHstrDao.insertRegisteredUsers(insttnId);
		
		if(isInserted == 0) {
			throw new CnfrHstrInsertException();
		}
		
		return isInserted;
	}

    @Transactional(readOnly = true)
	@Override
	public List<CnfrHstrConfirmReadVO> getConfirmedUsers(String crsInfId, String insttnId) {
		return this.cnfrHstrDao.selectAllConfirmedUsers(crsInfId, insttnId);
	}

    @Transactional
	@Override
	public boolean insertCrsPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO) {
    	
        int isInserted = this.crsPrattDao.insertCrsPratt(crsPrattRegistRequestVO);
        
        if(isInserted == 0) {
            throw new CrsPrattRegistException(crsPrattRegistRequestVO.getCrsPrattId());
        }
        
        return isInserted > 0;
	}
	
    @Transactional
    @Override
    public void saveConfirmedUsersToPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO) {
        String crsInfId = crsPrattRegistRequestVO.getCrsInfId();
        String insttnId = crsPrattRegistRequestVO.getInsttnId();
        
        List<String> selectedEmails = crsPrattRegistRequestVO.getSelectedUserEmails();

        List<CnfrHstrConfirmReadVO> confirmedUsers = this.getConfirmedUsers(crsInfId, insttnId);

        List<CnfrHstrConfirmReadVO> selectedUsers = new ArrayList<>();
        for (CnfrHstrConfirmReadVO user : confirmedUsers) {
        	System.out.println("유저이메일은 " + user.getUsrMl());
            if (selectedEmails.contains(user.getUsrMl())) {
                selectedUsers.add(user);
            }
        }

        for (CnfrHstrConfirmReadVO user : selectedUsers) {
            CrsPrattRegistRequestVO crsPrattRegistRequest = new CrsPrattRegistRequestVO();
            crsPrattRegistRequest.setCrsInfId(crsInfId);
            crsPrattRegistRequest.setUsrId(user.getUsrId());
            crsPrattRegistRequest.setUsrMl(user.getUsrMl());
            crsPrattRegistRequest.setInsttnId(user.getInsttnId());

            this.insertCrsPratt(crsPrattRegistRequest);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<SbjVO> getSubjectList() {
        return this.sbjDao.selectAllSubjects();
    }

    @Transactional(readOnly = true)
    @Override
    public List<InstrVO> getInstrList() {
        return this.instrDao.selectAllInstrs();
    }

    @Transactional
	@Override
	public boolean abandonOneCourse(CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO) {
		int isUpdate = this.crsInfDao.abandonOneCourse(crsInfAbandonUpdateRequestVO);
		
		// DB 수정 실패
		if(isUpdate == 0) {
			throw new CrsInfUpdateException(crsInfAbandonUpdateRequestVO.getCrsInfId());
		}
		
		return isUpdate > 0;
	}

    @Transactional(readOnly = true)
	@Override
	public List<CrsInfAbandonReadResponseVO> selectAbandonCourse(String insttnId) {
		return this.crsInfDao.selectAbandonCourse(insttnId);
	}

    @Transactional(readOnly = true)
	@Override
	public String selectOneInstrName(String crsInfId) {
		return this.instrDao.selectOneInstrName(crsInfId);
	}

	@Transactional(readOnly = true)
	@Override
	public CrsInfCourseListReadResponseVO selectAvailableFourCoursesWithStatus(String usrMl, String insttnId) {
	    int count = this.crsPrattDao.checkUserHasCrsPratt(usrMl, insttnId);
	    boolean isRegistered = count > 0;

	    List<CrsInfAvailableReadResponseVO> courseList;
	    if (isRegistered) {
	    	// 수강 이력 O; 현재 수강중인 강좌 목록을 보여준다
	        courseList = this.crsInfDao.selectMyCourseForUser(usrMl, insttnId);
	    } else {
	    	// 수강 이력 X; 수강 중인 강좌가 현재 없기 때문에 강좌 신청 가능 목록을 보여준다
	        courseList = this.crsInfDao.selectAvailableFourCoursesForUser(insttnId);
	    }

	    CrsInfCourseListReadResponseVO responseVO = new CrsInfCourseListReadResponseVO();
	    responseVO.setCourseList(courseList);
	    responseVO.setIsRegistered(isRegistered);

	    return responseVO;
	}
	
	@Transactional(readOnly = true)
	@Override
	public CrsInfStartAndEndTimeRequestVO getCourseTimeStartAndEnd(String crsInfId) {
		CrsInfStartAndEndTimeRequestVO crsInfStartAndEndTimeRequestVO = this.crsInfDao.selectCourseTimeStartAndEnd(crsInfId);
		
		return crsInfStartAndEndTimeRequestVO;
	}

	@Transactional(readOnly = true)
	@Override
	public List<CrsInfAvailableReadResponseVO> selectFourCoursesForInstr(String instrId, String insttnId) {
		return this.crsInfDao.selectFourCoursesForInstr(instrId, insttnId);
	}
	
	// 컨트롤러 내에서 서비스를 하나만 쓰게하기 위해 생성
	@Transactional
	@Override
	public void endCourseWithUserRegistration(CrsInfEndUpdateRequestVO crsInfEndUpdateRequestVO) {
	    this.endOneCourse(crsInfEndUpdateRequestVO); // 수업을 마감 시킨 뒤에

	    // 수강생을 등록한다; 단, 0명일 시 등록하지 않음
	    try {
	        this.insertRegisteredUsers(crsInfEndUpdateRequestVO.getInsttnId());
	    } catch (CnfrHstrInsertException e) {
	    	
	    }
	}
}