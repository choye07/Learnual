package com.learn.bbs.file.dao;

import java.util.List;

import com.learn.bbs.file.vo.FlTypeVO;

public interface FlTypeDao {

	// 변환 가능한 파일 확장자 조회
	public List<FlTypeVO> selectFlMdfyTypes(String flTypeNm);

	// 변환 가능한 파일 확장자 추가
	public int insertFlMdfyTypes(FlTypeVO flTypeVO);

	// 변환 가능한 파일 확장자 삭제
	public int deleteFlMdfyTypes(FlTypeVO flTypeVO);

}