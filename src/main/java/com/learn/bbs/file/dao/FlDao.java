package com.learn.bbs.file.dao;

import java.util.List;

import com.learn.bbs.file.vo.FlDeleteRequestVO;
import com.learn.bbs.file.vo.FlDownloadRequestVO;
import com.learn.bbs.file.vo.FlUpdateRequestVO;
import com.learn.bbs.file.vo.FlVO;

public interface FlDao {
	
	// 업로드
	public int insertNewFile(FlVO flVO);
	
	// 다운로드
	public FlVO selectOneFile(FlDownloadRequestVO fileDownloadRequestVO);
	
	// 파일 조회 - 게시글 아이디로
	public List<FlVO> selectFilesById(String id);
	
	// 삭제 - 파일 하나만 삭제
	public int deleteOneFile(FlDeleteRequestVO flDeleteRequestVO);
	
	// 파일 모두 삭제
	public int deleteAllFiles(FlDeleteRequestVO flDeleteRequestVO);
	
	// 수정
	public int updateOneFile(FlUpdateRequestVO flUpdateRequestVO);

}