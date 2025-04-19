package com.learn.bbs.pltad.crsinf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.pltad.crsinf.dao.CrsInfDao;
import com.learn.bbs.pltad.crsinf.service.CrsInfService;
import com.learn.bbs.pltad.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.pltad.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.pltad.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.pltad.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.pltad.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.pltad.crssbj.dao.CrsSbjDao;
import com.learn.bbs.pltad.crssbj.vo.CrsSbjRegistRequestVO;
import com.learn.exceptions.CrsInfDeleteException;
import com.learn.exceptions.CrsInfRegistException;
import com.learn.exceptions.CrsInfUpdateException;

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

    @Transactional
    @Override
    public boolean insertOneCourse(CrsInfRegistRequestVO crsInfRegistRequestVO) {
        // 강좌 정보 삽입
        int isInsertedCourse = this.crsInfDao.insertOneCourse(crsInfRegistRequestVO);
        
        // 강좌 정보 DB 저장 실패 시 예외 처리
        if (isInsertedCourse == 0) {
            throw new CrsInfRegistException();
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

    @Transactional
	@Override
	public boolean countCourseName(String crsInfNm) {
		return this.crsInfDao.countCourseName(crsInfNm) > 0;
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
    	this.crsSbjDao.deleteCourseSubject(crsInfModifyRequestVO.getCrsInfId());
    	
        int isUpdatedCourse = this.crsInfDao.updateOneCourse(crsInfModifyRequestVO);
        
        // 강좌 정보 DB 저장 실패 시 예외 처리
        if (isUpdatedCourse == 0) {
            throw new CrsInfUpdateException();
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
			throw new CrsInfDeleteException();
		}
		
		return isUpdated > 0;
	}

	@Override
	public List<CrsInfAvailableReadResponseVO> selectAvailableCourses() {
		return this.crsInfDao.selectAvailableCourses();
	}
}