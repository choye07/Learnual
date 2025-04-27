package com.learn.bbs.rsm.dao;

import java.util.List;

import com.learn.bbs.rsm.vo.RsmDeleteRequestVO;
import com.learn.bbs.rsm.vo.RsmListVO;
import com.learn.bbs.rsm.vo.RsmSearchRequestVO;
import com.learn.bbs.rsm.vo.RsmUpdateRequestVO;
import com.learn.bbs.rsm.vo.RsmVO;
import com.learn.bbs.rsm.vo.RsmWriteRequestVO;

public interface RsmDao {
	
	// 나의 이력서 총 개수
	public int selectAllRsmCount(RsmSearchRequestVO rsmSearchRequestVO);
	
	// 나의 이력서 모두 조회
	public List<RsmVO> selectAllRsm(RsmSearchRequestVO rsmSearchRequestVO);
	
	// 이력서 등록
	public int insertNewRsm(RsmWriteRequestVO rsmWriteRequestVO);
	
	// 이력서 삭제
	public int deleteOneRsm(RsmDeleteRequestVO rsmDeleteRequestVO);
	
	// 이력서 수정
	public int updateOneRsm(RsmUpdateRequestVO rsmUpdateRequestVO);

}