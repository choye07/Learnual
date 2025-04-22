package com.learn.bbs.pltad.ntc.dao;

import java.util.List;

import com.learn.bbs.pltad.ntc.vo.InsttnNtcUpdateRequestVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcWriteRequestVO;

/**
 * @author 최예진 러뉴얼 공지사항
 */
public interface InsttnNtcDao {

	// 1. 학원 공지사항 작성 (post vo)
	public int insertNewInsttnNotice(InsttnNtcWriteRequestVO insttnNtcWriteRequestVO);

	// 2. 학원 러뉴얼 공지사항 리스트 불러오기
	public List<InsttnNtcVO> selectInsttnNoticeAll();
	
	// 2. 학원 공지사항 리스트 개수 불러오기
	public int selectInsttnNoticeAllCount();

//	// 3. 학원 러뉴얼 공지사항 하나 불러오기
	public InsttnNtcVO selectOneInsttnNoticeBy(String id);
//
//	// 4. 학원 러뉴얼 공지사항 하나 삭제하기
	public int deleteOneInsttnNoticeBy(String id);
//
//	// 5. 학원 러뉴얼 공지사항 하나 수정하기 (post, vo)
	public int updateOneInsttnNoticeBy(InsttnNtcUpdateRequestVO insttnNtcUpdateRequestVO);


}