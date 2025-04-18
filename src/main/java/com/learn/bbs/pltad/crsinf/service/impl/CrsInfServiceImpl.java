package com.learn.bbs.pltad.crsinf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.pltad.crsinf.dao.CrsInfDao;
import com.learn.bbs.pltad.crsinf.service.CrsInfService;
import com.learn.bbs.pltad.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.pltad.crssbj.dao.CrsSbjDao;
import com.learn.bbs.pltad.crssbj.vo.CrsSbjRegistRequestVO;
import com.learn.exceptions.CrsInfRegistException;
import com.learn.exceptions.CrsSbjRegistException;

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

	@Override
	public boolean countCourseName(String crsInfNm) {
		return this.crsInfDao.countCourseName(crsInfNm) > 0;
	}
}