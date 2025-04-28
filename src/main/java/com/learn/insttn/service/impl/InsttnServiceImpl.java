package com.learn.insttn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.crs.crsinf.dao.CrsInfDao;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.insttn.dao.InsttnDao;
import com.learn.insttn.service.InsttnService;
import com.learn.insttn.vo.InsttnRegistRequestVO;
import com.learn.insttn.vo.InsttnSearchRequestVO;
import com.learn.insttn.vo.InsttnVO;

/**
 * @author 최예진 기관(학원)
 */
@Service
public class InsttnServiceImpl implements InsttnService {

	@Autowired
	private InsttnDao insttnDao;
	
	@Autowired
	private CrsInfDao crsInfDao;

	@Override
	public boolean createNewInsttn(InsttnRegistRequestVO insttnRegistRequestVO) {

		// TO-DO 학원 등록 하는 INSERT
		int insertCount = this.insttnDao.insertNewInsttn(insttnRegistRequestVO);

		return insertCount > 0;
	}

	@Override
	public InsttnVO selectOneInsttn(String insttnId) {
		
		return null;
	}

	@Override
	public List<InsttnVO> selectAllinsttn(InsttnSearchRequestVO insttnSearchRequestVO) {
	
		return this.insttnDao.selectAllInsttn(insttnSearchRequestVO);
	}

	@Override
	public List<CrsInfAvailableReadResponseVO> selectCoursesForInstr(String instrId, String insttnId) {
		return this.crsInfDao.selectCoursesForInstr(instrId, insttnId);
	}

	@Override
	public List<CrsInfAvailableReadResponseVO> selectMyCourseForUser(String usrMl, String insttnId) {
		return this.crsInfDao.selectMyCourseForUser(usrMl, insttnId);
	}

}