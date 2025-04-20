package com.learn.main.ntc.dao;

import java.util.List;

import com.learn.main.ntc.vo.NtcVO;
import com.learn.main.ntc.vo.NtcWriteRequestVO;

/**
 * @author 최예진 러뉴얼 공지사항
 */
public interface MainNtcDao {

	// 1. 메인 러뉴얼 공지사항 작성
	public int insertNewMainNotice(NtcWriteRequestVO ntcWriteRequestVO);

	// 2. 메인 러뉴얼 공지사항 리스트 불러오기
	public List<NtcVO> selectMainNoticeAll();

	// 2. 메인 러뉴얼 공지사항 개수 불러오기
	public int selectMainNoticeAllCount();

	// 3. 메인 러뉴얼 공지사항 하나 불러오기
	public NtcVO selecOneMainNotice(String id);

	// 4. 메인 러뉴얼 공지사항 하나 삭제하기
	public int deleteOneMainNotice(String id);

	// 5. 메인 러뉴얼 공지사항 하나 수정하기
	public int updateOneMainNoticeBy(String id);
}