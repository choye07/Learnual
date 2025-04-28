package com.learn.insttn.dao;

import java.util.List;

import com.learn.insttn.vo.InsttnRegistRequestVO;
import com.learn.insttn.vo.InsttnSearchRequestVO;
import com.learn.insttn.vo.InsttnVO;

/**
 * @author 최예진
 * 기관(학원)
 */
public interface InsttnDao {
	
	//기관(학원) 등록
	public int insertNewInsttn(InsttnRegistRequestVO insttnRegistRequestVO);
	
	//기관(학원) 등록 시 이미 있는 학원인지 체크
	public int selectCheckDuplicateInsttn(InsttnRegistRequestVO insttnRegistRequestVO);
	
	//등록된 학원 List
	public List<InsttnVO> selectAllInsttn (InsttnSearchRequestVO insttnSearchRequestVO);
	
	public List<InsttnVO> selectAllInsttnBy (String insttnId);
	

}