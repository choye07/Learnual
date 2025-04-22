package com.learn.bbs.file.service;

import java.util.List;

import com.learn.bbs.file.vo.FlDeleteRequestVO;
import com.learn.bbs.file.vo.FlDownloadRequestVO;
import com.learn.bbs.file.vo.FlUpdateRequestVO;
import com.learn.bbs.file.vo.FlVO;

public interface FlService {

	// 다운로드
	public FlVO getFile(FlDownloadRequestVO flDownloadRequestVO);
	
	// 삭제 
	public boolean deleteFile(FlDeleteRequestVO flDeleteRequestVO);
	
	// 게시글 아이디로 파일 조회
	public List<FlVO> getFilesById(String id);
	
	// 모두 삭제
	public boolean deleteAllFiles(FlDeleteRequestVO flDeleteRequestVO);
	
	// 수정
	public boolean updateFile(FlUpdateRequestVO flUpdateRequestVO);
}