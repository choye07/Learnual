package com.learn.bbs.file.service;

import java.util.List;

import com.learn.bbs.file.vo.FlDeleteRequestVO;
import com.learn.bbs.file.vo.FlDownloadRequestVO;
import com.learn.bbs.file.vo.FlUpdateRequestVO;
import com.learn.bbs.file.vo.FlVO;

public interface FlService {

	// 하나의 파일 다운로드 및 하나의 파일 조회
	public FlVO getFile(FlDownloadRequestVO flDownloadRequestVO);
	
	// 삭제 
	public boolean deleteFile(FlDeleteRequestVO flDeleteRequestVO);
	
	// 여러 개의 파일 조회
	public List<FlVO> getFilesById(String id);
	
	// 모두 삭제
	public boolean deleteAllFiles(FlDeleteRequestVO flDeleteRequestVO);
	
	// 파일 삭제 x - 파일 데이터 삭제여부 바꿈
	public boolean deleteFileRow(FlDeleteRequestVO flDeleteRequestVO);
	
	// 수정
	public boolean updateFile(FlUpdateRequestVO flUpdateRequestVO);
}