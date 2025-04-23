package com.learn.bbs.eduad.crntc.service;

import com.learn.bbs.eduad.crntc.vo.CrntcListVO;
import com.learn.bbs.eduad.crntc.vo.CrntcUpdateRequestVO;
import com.learn.bbs.eduad.crntc.vo.CrntcVO;
import com.learn.bbs.eduad.crntc.vo.CrntcWriteRequestVO;

/**
 * @author 최예진
 *  강좌 공지사항
 */
public interface CrNtcService {
	// 1. 강좌 공지사항 리스트 불러오기
	public CrntcListVO getAllCourseNotice();

	// 2. 강좌 공지사항 리스트 작성
	public boolean createNewCourseNotice(CrntcWriteRequestVO crntcWriteRequestVO);

	// 3. 강좌 공지사항 하나 불러오기
	public CrntcVO getOneCourseNoticeBy(String id);

	// 4. 강좌 공지사항 하나 삭제하기
	public boolean deleteOneCourseNoticeBy(String id);

	// 5. 강좌 공지사항 하나 수정하기
	public boolean updateOneCourseNoticeBy(CrntcUpdateRequestVO crntcUpdateRequestVO);
}