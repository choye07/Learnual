package com.learn.bbs.rsm.service;

import com.learn.bbs.rsm.vo.RsmDeleteRequestVO;
import com.learn.bbs.rsm.vo.RsmListVO;
import com.learn.bbs.rsm.vo.RsmSearchRequestVO;
import com.learn.bbs.rsm.vo.RsmUpdateRequestVO;
import com.learn.bbs.rsm.vo.RsmWriteRequestVO;

public interface RsmService {
	
	// 이력서 목록
	public RsmListVO getAllRsm(RsmSearchRequestVO rsmSearchRequestVO);
	
	// 이력서 등록
	public boolean createNewRsm(RsmWriteRequestVO rsmWriteRequestVO);
	
	// 이력서 삭제
	public boolean deleteOneRsm(RsmDeleteRequestVO rsmDeleteRequestVO);
	
	// 이력서 수정
	public boolean updateOneRsm(RsmUpdateRequestVO rsmUpdateRequestVO);

}