package com.learn.bbs.file.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.file.dao.FlDao;
import com.learn.bbs.file.service.FlService;
import com.learn.bbs.file.vo.FlDeleteRequestVO;
import com.learn.bbs.file.vo.FlDownloadRequestVO;
import com.learn.bbs.file.vo.FlUpdateRequestVO;
import com.learn.bbs.file.vo.FlVO;
import com.learn.exceptions.PageNotFoundException;

@Service
public class FlServiceImpl implements FlService {

    @Autowired
    private FlDao flDao;

	@Override
	public FlVO getFile(FlDownloadRequestVO flDownloadRequestVO) {
		return this.flDao.selectOneFile(flDownloadRequestVO);
	}
	
	@Override
	public List<FlVO> getFilesById(String id) {
		return this.flDao.selectFilesById(id);
	}

	@Override
	public boolean deleteFile(FlDeleteRequestVO flDeleteRequestVO) {
		int deleteCount = this.flDao.deleteOneFile(flDeleteRequestVO);
		// 삭제된 게시글의 수가 0이라면 에러 발생
		if (deleteCount == 0) {
			throw new PageNotFoundException(flDeleteRequestVO.getFlId());
		}
		return deleteCount > 0;
	}

	@Override
	public boolean deleteAllFiles(FlDeleteRequestVO flDeleteRequestVO) {
		int deleteCount = this.flDao.deleteAllFiles(flDeleteRequestVO);
		// 삭제된 게시글의 수가 0이라면 에러 발생
		if (deleteCount == 0) {
			throw new PageNotFoundException(flDeleteRequestVO.getFlId());
		}
		return deleteCount > 0;
	}
	
	
	@Override
	public boolean updateFile(FlUpdateRequestVO flUpdateRequestVO) {
		int updateCount = this.flDao.updateOneFile(flUpdateRequestVO);
		// 업데이트의 수가 0보다 크면 게시글이 수정 성공
		if(updateCount == 0) {
			throw new PageNotFoundException(flUpdateRequestVO.getFlId());
		}
		return updateCount > 0;
	}

	@Override
	public boolean deleteFileRow(FlDeleteRequestVO flDeleteRequestVO) {
		int updateCount = this.flDao.deleteFileData(flDeleteRequestVO);
		
		if(updateCount == 0) {
			throw new PageNotFoundException(flDeleteRequestVO.getFlId());
		}
		return updateCount > 0;
	}

}