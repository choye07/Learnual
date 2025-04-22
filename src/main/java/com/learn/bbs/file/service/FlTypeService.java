package com.learn.bbs.file.service;

import java.util.List;
import com.learn.bbs.file.vo.FlTypeVO;

public interface FlTypeService {

	// 변환 가능한 파일 확장자 조회
	public List<FlTypeVO> getFlMdfyTypes(String flTypeNm);

	// 변환 가능한 파일 확장자 추가
	public boolean insertNewFlMdfyTypes(FlTypeVO flTypeVO);

	// 변환 가능한 파일 확장자 삭제
	public boolean deleteOneFlMdfyTypes(FlTypeVO flTypeVO);

}