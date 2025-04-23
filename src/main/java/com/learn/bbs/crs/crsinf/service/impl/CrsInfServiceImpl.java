package com.learn.bbs.crs.crsinf.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.learn.bbs.crs.crsinf.vo.CrsInfDetailReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.crs.crspratt.dao.CrsPrattDao;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;
import com.learn.bbs.crs.sbj.dao.SbjDao;
import com.learn.bbs.crs.sbj.vo.SbjVO;
import com.learn.bbs.pltad.cnfr.dao.CnfrHstrDao;
import com.learn.bbs.pltad.cnfr.vo.CnfrHstrConfirmReadVO;
import com.learn.bbs.pltad.crssbj.dao.CrsSbjDao;
import com.learn.bbs.pltad.crssbj.vo.CrsSbjRegistRequestVO;
import com.learn.bbs.pltad.dao.PltAdDao;
import com.learn.bbs.pltad.instr.dao.InstrDao;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.exceptions.CnfrHstrInsertException;
import com.learn.exceptions.CrsInfDeleteException;
import com.learn.exceptions.CrsInfRegistException;
import com.learn.exceptions.CrsInfUpdateException;
import com.learn.exceptions.CrsPrattRegistException;
import com.learn.exceptions.InstrRegistException;

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
    @Autowired
    private PltAdDao pltAdDao;

    @Transactional
    @Override
    public boolean insertOneCourse(CrsInfRegistRequestVO crsInfRegistRequestVO) {
    	// 세션 값이 들어가야하는데 일단 세팅을 해놨습니다.
    	String loginId = crsInfRegistRequestVO.getLoginId();
    	int selectCount = this.pltAdDao.selectPltadCount(loginId);
    	
    	if(selectCount == 0) {
    		throw new InstrRegistException(crsInfRegistRequestVO);
    	}
    	
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
	public boolean countCourseName(String crsInfNm) {
		return this.crsInfDao.countCourseName(crsInfNm) > 0;
	}
    
    @Transactional(readOnly = true)
	@Override
	public String selectCourseName(String crsInfId) {
		return this.crsInfDao.selectCourseName(crsInfId);
	}

    @Transactional(readOnly = true)
	@Override
	public List<CrsInfPltadReadResponseVO> selectAllCourseForPltad() {
		return this.crsInfDao.selectAllCourseForPltad();
	}

    @Transactional(readOnly = true)
	@Override
	public List<CrsInfPltadFinishedReadResponseVO> selectAllFinishedCourseForPltad() {
    	return this.crsInfDao.selectAllFinishedCourseForPltad();
	}

    @Transactional
	@Override
	public boolean updateOneCourse(CrsInfModifyRequestVO crsInfModifyRequestVO) {
    	// 세션 값이 들어가야하는데 일단 세팅을 해놨습니다.
    	String loginId = crsInfModifyRequestVO.getLoginId();
    	int selectCount = this.pltAdDao.selectPltadCount(loginId);
    	
    	if(selectCount == 0) {
    		throw new InstrRegistException(crsInfModifyRequestVO);
    	}
    	
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
	public CrsInfModifyRequestVO selectAllInfoFromOneCourse(String crsInfId) {
    	// 다시 정보 불러와서 수정 form에 보여줘야한다.
    	CrsInfModifyRequestVO oneCourse = this.crsInfDao.selectAllInfoFromOneCourse(crsInfId);
    	
    	List<String> subjectNameList = new ArrayList<>();
    	
    	for(CrsSbjRegistRequestVO subject : this.crsSbjDao.selectSubjectList(crsInfId)) {
    		subjectNameList.add(subject.getSbjId());
    	}
    	
    	oneCourse.setSubjects(subjectNameList);
    	
    	return oneCourse;
	}

    @Transactional
	@Override
	public boolean deleteOneCourse(String crsInfId) {
		int isUpdated = this.crsInfDao.deleteOneCourse(crsInfId);
		
		if(isUpdated == 0) {
			throw new CrsInfDeleteException(crsInfId);
		}
		
		return isUpdated > 0;
	}

    @Transactional
	@Override
	public List<CrsInfAvailableReadResponseVO> selectCoursesForUser(String usrId) {
    	// 수강 이력이 있는가?
		int count = this.crsPrattDao.checkUserHasCrsPratt(usrId);
		
		if(count == 0) {
			// 수강 이력 X; 수강 중인 강좌가 현재 없기 때문에 강좌 신청 가능 목록을 보여준다
	        List<CrsInfAvailableReadResponseVO> availableCourses = this.crsInfDao.selectAvailableCoursesForUser();

			return availableCourses;
		} else {
			// 수강 이력 O; 현재 수강중인 강좌 목록을 보여준다
			return this.crsInfDao.selectMyCourseForUser(usrId);
		}
	}

    @Transactional(readOnly = true)
	@Override
	public CrsInfDetailReadResponseVO selectCourseDetail(String crsInfId) {
    	return this.crsInfDao.selectCourseDetail(crsInfId);
	}

    @Transactional(readOnly = true)
    public boolean isAppliedOrCancelled(String crsInfId, String usrId) {
        // 신청 내역 ID 조회
        String appHstrId = this.appHstrDao.findAppHstrId(crsInfId, usrId);

        if (appHstrId == null) {
            // 신청 안 했으면 -> 신청 버튼 보여줌
            return false;
        }

        // 신청은 했고, 취소 안 했으면 -> 신청 취소 버튼 보여줌
        boolean isCancelled = this.cnclHstrDao.existsCancelledAppHstr(appHstrId);
        return !isCancelled;
    }

    @Transactional
	@Override
	public boolean endOneCourse(String crsInfId) {
		int isUpdated = this.crsInfDao.endOneCourse(crsInfId);
		
		// DB 수정 실패
		if(isUpdated == 0) {
			// 나중에 추가
		}
		
		return isUpdated > 0;
	}

    @Transactional(readOnly = true)
	@Override
	public List<CrsInfAvailableReadResponseVO> selectRegisterableCourses() {
		return this.crsInfDao.selectAvailableCoursesForUser();
	}
	
    @Transactional(readOnly = true)
	@Override
	public int insertRegisteredUsers() {
		int isInserted = this.cnfrHstrDao.insertRegisteredUsers();
		
		if(isInserted == 0) {
			throw new CnfrHstrInsertException();
		}
		
		return isInserted;
	}

	@Override
	public List<CnfrHstrConfirmReadVO> getConfirmedUsers(String crsInfId) {
		return this.cnfrHstrDao.selectAllConfirmedUsers(crsInfId);
	}

	@Override
	public boolean insertCrsPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO) {
        int isInserted = this.crsPrattDao.insertCrsPratt(crsPrattRegistRequestVO);
        
        if(isInserted == 0) {
            throw new CrsPrattRegistException(crsPrattRegistRequestVO.getCrsPrattId());
        }
        
        return isInserted > 0;
	}
	
	@Override
	public void saveConfirmedUsersToPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO) {
		String loginId = crsPrattRegistRequestVO.getLogId();
        int selectCount = this.pltAdDao.selectPltadCount(loginId);
        
        if(selectCount == 0) {
            throw new InstrRegistException(crsPrattRegistRequestVO);
        }
        
	    String crsInfId = crsPrattRegistRequestVO.getCrsInfId();  // 강좌 ID
	    List<String> selectedUserIds = crsPrattRegistRequestVO.getSelectedUserIds();  // 선택된 사용자 ID 리스트

	    // 모든 사용자 목록을 가져오고, 정말 강좌를 들을 학생들만 담아야함
	    List<CnfrHstrConfirmReadVO> confirmedUsers = getConfirmedUsers(crsInfId);

	    List<CnfrHstrConfirmReadVO> selectedUsers = new ArrayList<>();

	    // 선택된 사용자만 가져온다
	    for (CnfrHstrConfirmReadVO user : confirmedUsers) {
	        if (selectedUserIds.contains(user.getUsrId())) {
	            selectedUsers.add(user);
	        }
	    }

	    // 필터링된 사용자들만 처리
	    for (CnfrHstrConfirmReadVO user : selectedUsers) {
	        CrsPrattRegistRequestVO crsPrattRegistRequest = new CrsPrattRegistRequestVO();
	        
	        crsPrattRegistRequest.setCrsInfId(crsInfId);
	        crsPrattRegistRequest.setUsrId(user.getUsrId());
	        crsPrattRegistRequest.setLogId("admin");

	        this.insertCrsPratt(crsPrattRegistRequest);
	    }
	}

    @Override
    public List<SbjVO> getSubjectList() {
        return sbjDao.selectAllSubjects();
    }

    @Override
    public List<InstrVO> getInstrList() {
        return instrDao.selectAllInstrs();
    }

	@Override
	public boolean abandonOneCourse(CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO) {
		String loginId = crsInfAbandonUpdateRequestVO.getLgnId();
        int selectCount = this.pltAdDao.selectPltadCount(loginId);
        
        // 권한 없음
        if(selectCount == 0) {
            throw new InstrRegistException(crsInfAbandonUpdateRequestVO);
        }
        
		int isUpdate = this.crsInfDao.abandonOneCourse(crsInfAbandonUpdateRequestVO);
		
		// DB 수정 실패
		if(isUpdate == 0) {
			throw new CrsInfUpdateException(crsInfAbandonUpdateRequestVO.getCrsInfId());
		}
		
		return isUpdate > 0;
	}

	@Override
	public List<CrsInfAbandonReadResponseVO> selectAbandonCourse() {
		return this.crsInfDao.selectAbandonCourse();
	}

	@Override
	public boolean updateNotAttendCourse(List<String> usrIds, String loginId) {
		String curLoginId = loginId;
		int selectCount = this.pltAdDao.selectPltadCount(curLoginId);
		
		 // 권한 없음
        if(selectCount == 0) {
            throw new InstrRegistException(loginId);
        }
		
        // 마지막에 강좌를 참석하지 않겠다고 말한 사용자들의 확정 여부를 'N'으로 업데이트
        int updateCount = this.crsInfDao.updateNotAttendCourse(usrIds, curLoginId);  // 실제 업데이트 호출
        
        return updateCount > 0;
	}
}