package com.learn.main.ntc.service;

import com.learn.main.ntc.vo.NtcListVO;
import com.learn.main.ntc.vo.NtcVO;
import com.learn.main.ntc.vo.NtcWriteRequestVO;

/**
 * @author 최예진
 * 러뉴얼 공지사항 
 */
public interface MainNtcService {

	// 1. 메인 공지사항 리스트 select
	public NtcListVO getAllMainNotice();
	
	// 2. 메인 공지사항 글쓰기(관리자만 가능)
	public boolean createNewMainNotice(NtcWriteRequestVO ntcWriteRequestVO);
	
	// 3. 메인 공지사항 하나 불러오기
	public NtcVO getOneMainNotcie(String id);
	
	// 4. 메인 공지사항 하나 삭제하기
	public boolean deleteOneMainNoticeBy(String id);

	// 5. 메인 공지사항 하나 수정하기
	public int updateOneMainNoticeBy(String id);
}