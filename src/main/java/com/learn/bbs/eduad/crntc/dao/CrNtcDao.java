package com.learn.bbs.eduad.crntc.dao;

import java.util.List;

import com.learn.bbs.eduad.crntc.vo.CrntcUpdateRequestVO;
import com.learn.bbs.eduad.crntc.vo.CrntcVO;
import com.learn.bbs.eduad.crntc.vo.CrntcWriteRequestVO;

/**
 * @author 최예진
 *  강좌 공지사항
 */
public interface CrNtcDao {

	// 1. 강좌 러뉴얼 공지사항 리스트 불러오기
	public List<CrntcVO> selectCourseNoticeAll();
	
	// 1. 강좌 공지사항 리스트 개수 불러오기
	public int selectCourseNoticeAllCount();

	// 2. 강좌 공지사항 작성
	public int insertNewCourseNotice(CrntcWriteRequestVO crntcWriteRequestVO);

	// 3. 강좌 공지사항 하나 불러오기
	public CrntcVO selectOneCourseNoticeBy(String id);

	// 4. 강좌 공지사항 하나 삭제하기
	public int deleteOneCourseNoticeBy(String id);

	// 5. 강좌 공지사항 하나 수정하기
	public int updateOneCourseNoticeBy(CrntcUpdateRequestVO crntcUpdateRequestVO);
}