package com.learn.insttn.service;

import java.util.List;

import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.insttn.vo.InsttnListVO;
import com.learn.insttn.vo.InsttnRegistRequestVO;
import com.learn.insttn.vo.InsttnSearchRequestVO;
import com.learn.insttn.vo.InsttnVO;

/**
 * @author 최예진
 * 기관(학원)
 */
public interface InsttnService {
	
	// 기관(학원) 등록
	public boolean createNewInsttn(InsttnRegistRequestVO insttnRegistRequestVO);
	
	public InsttnVO selectOneInsttn(String insttnId);


	public List<InsttnVO> selectAllinsttn(InsttnSearchRequestVO insttnSearchRequestVO);
	
	public List<CrsInfAvailableReadResponseVO> selectCoursesForInstr(String instrId, String insttnId);

	public List<CrsInfAvailableReadResponseVO> selectMyCourseForUser(String usrMl, String insttnId);
}