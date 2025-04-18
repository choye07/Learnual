package com.learn.bbs.pltad.crsinf.service;

import com.learn.bbs.pltad.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.pltad.crsinf.vo.CrsInfVO;

/**
 * @author 최예진
 * 강좌 정보
 */
public interface CrsInfService {
	public boolean insertOneCourse(CrsInfRegistRequestVO crsInfRegistRequestVO);
	
	public boolean countCourseName(String crsInfNm);
}