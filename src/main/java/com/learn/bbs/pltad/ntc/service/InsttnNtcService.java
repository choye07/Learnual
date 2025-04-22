package com.learn.bbs.pltad.ntc.service;

import com.learn.bbs.pltad.ntc.vo.InsttnNtcListVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcUpdateRequestVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcWriteRequestVO;


/**
 * @author 최예진
 * 러뉴얼 공지사항 
 */
public interface InsttnNtcService {

	// 1. 학원 공지사항 리스트 select
	public InsttnNtcListVO getAllInsttnNotice();
	
	// 2. 학원 공지사항 글쓰기(플랫폼관리자만 가능)
	public boolean createNewInsttnNotice(InsttnNtcWriteRequestVO insttnNtcWriteRequestVO);
	
//	// 3. 학원 공지사항 하나 불러오기
	public InsttnNtcVO getOneInsttnNoticeBy(String id);
//	
//	// 4. 학원 공지사항 하나 삭제하기
	public boolean deleteOneInsttnNoticeBy(String id);
//
//	// 5. 학원 공지사항 하나 수정하기
	public boolean updateOneInsttnNoticeBy(InsttnNtcUpdateRequestVO insttnNtcUpdateRequestVO);
}