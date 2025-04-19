package com.learn.insttn.service;

import com.learn.insttn.vo.InsttnRegistRequestVO;

/**
 * @author 최예진
 * 기관(학원)
 */
public interface InsttnService {
	
	// 기관(학원) 등록
	public boolean createNewInsttn(InsttnRegistRequestVO insttnRegistRequestVO);

}